package ar.utn.aceleradora.gestion.socios.controladores;


import ar.utn.aceleradora.gestion.socios.error.AutoridadNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.DepartamentoNotFoundException;
import ar.utn.aceleradora.gestion.socios.modelos.departamento.Departamento;
import ar.utn.aceleradora.gestion.socios.servicios.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/departamentos")
@RestController
public class DepartamentoController {


    private DepartamentoService departamentoService;
    @Autowired
    public DepartamentoController(DepartamentoService departamentoService) {
      this.departamentoService = departamentoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Departamento> obtenerDepartamento(@PathVariable Integer id) {
        Departamento departamento = departamentoService.obtenerDepartamento(id);
        return Optional.ofNullable(departamento)
                .map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<Departamento> crearDepartamento(@RequestBody Departamento dpto) {
        Departamento nuevoDpto = departamentoService.agregarDepartamento(dpto);
        return new ResponseEntity<>(nuevoDpto, HttpStatus.CREATED);
    }

    @GetMapping("/obtenerNombres")
    public ResponseEntity<List<String>> obtenerNombresDepartamento() {
        List<String> nombres = departamentoService.obtenerNombres();
        return new ResponseEntity<>(nombres, HttpStatus.OK);
    }

/*    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            Boolean deleted = departamentoService.eliminarDepartamento(id);
            if (deleted)
            {
                return new ResponseEntity<>("El departamento ha sido borrado",HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>("Departamento con " + id + " no encontrado",HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
*/
    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        try {
            departamentoService.eliminarDepartamento(id);
            return ResponseEntity.noContent().build();
        } catch (DepartamentoNotFoundException ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
        }
    }
/*
    @PatchMapping({"{id}/autoridades"})
    public ResponseEntity<String> agregarAutoridades (@RequestBody AutoridadDTO autoridadDTO, @PathVariable Integer id) {
        try {
            departamentoService.agregarAutoridades(autoridadDTO, id);
            return ResponseEntity.ok(new ResponseDTO("Socio editado satisfactoriamente", "SECCESS", 200));
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage(), "INTERNAL_SERVER_ERROR", 500),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

 */
    @PatchMapping("/{id}/autoridades")
    public ResponseEntity<String> agregarAutoridades(@RequestBody List<Integer> autoridadesIds, @PathVariable Integer id) {
        try {
            departamentoService.agregarAutoridades(autoridadesIds, id);
            return ResponseEntity.ok("Autoridades añadidas satisfactoriamente");

        }catch (DepartamentoNotFoundException | AutoridadNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}