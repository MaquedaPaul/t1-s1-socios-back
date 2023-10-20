package ar.utn.aceleradora.gestion.socios.controladores;


import ar.utn.aceleradora.gestion.socios.dto.CreacionEdicionDepartamentoDTO;
import ar.utn.aceleradora.gestion.socios.error.AutoridadNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.DepartamentoNotFoundException;
import ar.utn.aceleradora.gestion.socios.modelos.Departamento;
import ar.utn.aceleradora.gestion.socios.servicios.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/departamentos")
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

    @GetMapping({"/", ""})
    public ResponseEntity<Departamento> obtenerTodos() {
        try {
            List<Departamento> departamentos = departamentoService.obtenerDepartamentos();
            return new ResponseEntity(departamentos, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<Departamento>> obtenerDepartamentoPaginado(@RequestParam(name = "page", defaultValue = "0") int page) {
        Page<Departamento> departamento = departamentoService.obtenerDepartamentoPaginado(page);
        return Optional.ofNullable(departamento)
                .map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Departamento> editarDepartamento(@PathVariable Integer id, @RequestBody CreacionEdicionDepartamentoDTO dpto) {
        try {
            Departamento dptoEditado = departamentoService.editarDepartamento(dpto, id);
            return new ResponseEntity<>(dptoEditado, HttpStatus.OK);
        } catch (DepartamentoNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping({"/", ""})
    public ResponseEntity<Departamento> crearDepartamento(@RequestBody CreacionEdicionDepartamentoDTO dpto) {
        try {
            Departamento nuevoDpto = departamentoService.crearDepartamento(dpto);
            return new ResponseEntity<>(nuevoDpto, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

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

    @PatchMapping("/{id}/autoridades/{idAutoridad}")
    public ResponseEntity<String> removerAutoridades(@PathVariable Integer id, @PathVariable Integer idAutoridad) {
        try {
            departamentoService.removerAutoridades(id, idAutoridad);
            return ResponseEntity.ok("Autoridad removida satisfactoriamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }


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
    @PatchMapping("/{id}/socios")
    public ResponseEntity<String> agregarASocios(@RequestBody List<Integer> sociosIds, @PathVariable Integer id) {
        try {
            departamentoService.agregarSocios(sociosIds, id);
            return ResponseEntity.ok("Autoridades añadidas satisfactoriamente");

        }catch (DepartamentoNotFoundException | AutoridadNotFoundException e){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("/{id}/socios/{idSocio}")
    public ResponseEntity<String> removerSocios(@PathVariable Integer id, @PathVariable Integer idSocio) {
        try {
            departamentoService.removerSocios(id, idSocio);
            return ResponseEntity.ok("Socio removido satisfactoriamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}