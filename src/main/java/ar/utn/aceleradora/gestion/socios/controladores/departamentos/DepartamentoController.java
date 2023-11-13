package ar.utn.aceleradora.gestion.socios.controladores.departamentos;


import ar.utn.aceleradora.gestion.socios.dto.departamentos.CreacionEdicionDepartamentoDTO;
import ar.utn.aceleradora.gestion.socios.dto.departamentos.DepartamentoCoordinacionDTO;
import ar.utn.aceleradora.gestion.socios.error.departamentos.AutoridadNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.departamentos.DepartamentoNotFoundException;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Autoridad;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Coordinacion;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.EspacioFisico;
import ar.utn.aceleradora.gestion.socios.servicios.departamentos.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping("/departamentos")
@CrossOrigin(origins= "*")
@RestController
public class DepartamentoController {


    private final DepartamentoService departamentoService;
    @Autowired
    public DepartamentoController(DepartamentoService departamentoService) {
      this.departamentoService = departamentoService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartamentoCoordinacionDTO> obtenerDepartamento(@PathVariable Integer id) {
        Departamento departamento = departamentoService.obtenerDepartamento(id);
        Coordinacion coordinacion = departamento.getCoordinacionDepartamental();
            DepartamentoCoordinacionDTO departamentoCoordinacionDTO = new DepartamentoCoordinacionDTO();

            departamentoCoordinacionDTO.setId(departamento.getId());
            departamentoCoordinacionDTO.setIcono(departamento.getIcono());
            departamentoCoordinacionDTO.setDescripcion(departamento.getDescripcion());
            departamentoCoordinacionDTO.setNombre(departamento.getNombre());
            departamentoCoordinacionDTO.setAutoridades(departamento.getAutoridades());
            departamentoCoordinacionDTO.setJerarquia(departamento.getJerarquia());
            departamentoCoordinacionDTO.setFechaBaja(departamento.getFechaBaja());
            departamentoCoordinacionDTO.setSociosSuscritos(departamento.getSociosSuscritos());


            departamentoCoordinacionDTO.setCoordinacion(coordinacion);
            return new ResponseEntity<>(departamentoCoordinacionDTO, HttpStatus.OK);
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<Departamento>> obtenerTodos() {
            List<Departamento> departamentos = departamentoService.obtenerDepartamentos();
            return new ResponseEntity<>(departamentos, HttpStatus.OK);
    }

    @GetMapping("/paginado")
    public ResponseEntity<Page<Departamento>> obtenerDepartamentoPaginado(@RequestParam(name = "page", defaultValue = "0") int page) {
        Page<Departamento> departamento = departamentoService.obtenerDepartamentoPaginado(page);
        return Optional.ofNullable(departamento)
                .map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElseThrow(() -> new DepartamentoNotFoundException("No se ha encontrado el departamento."));
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


    @GetMapping("/{id}/autoridades")
    public ResponseEntity<List<Autoridad>> obtenerAutoridades(@PathVariable Integer id) {
        List<Autoridad> autoridades = departamentoService.obtenerAutoridadesDe(id);
        return new ResponseEntity<>(autoridades, HttpStatus.OK);
    }


    @PatchMapping("/{id}/autoridades/{idAutoridad}")
    public ResponseEntity<String> removerAutoridad(@PathVariable Integer id, @PathVariable Integer idAutoridad) {
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
    //Se plantea desde el departamento porque teóricamente pertenecen a los departamentos, pero como actualmente se consideran que t
    // todos los espacios físicos pertenecen a todos los departamentos no lo implementamos totalmente
    @GetMapping("/espaciosFisicos")
    public ResponseEntity<List<EspacioFisico>> obtenerEspaciosFisicos() {
        List<EspacioFisico> espacioFisicos = departamentoService.obtenerEspaciosFisicos();
        return new ResponseEntity<>(espacioFisicos, HttpStatus.OK);
    }



}