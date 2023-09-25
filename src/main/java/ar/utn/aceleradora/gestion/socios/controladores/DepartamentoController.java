package ar.utn.aceleradora.gestion.socios.controladores;


import ar.utn.aceleradora.gestion.socios.dto.SocioDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioPostDTO;
import ar.utn.aceleradora.gestion.socios.modelos.departamento.Departamento;
import ar.utn.aceleradora.gestion.socios.servicios.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/api/departamento")
@RestController
public class DepartamentoController {

    @Autowired
    private DepartamentoService departamentoService;

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



}
