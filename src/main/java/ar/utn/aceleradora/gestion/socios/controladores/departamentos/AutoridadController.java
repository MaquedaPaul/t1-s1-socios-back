package ar.utn.aceleradora.gestion.socios.controladores.departamentos;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Autoridad;
import ar.utn.aceleradora.gestion.socios.servicios.departamentos.AutoridadService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/autoridades")
@CrossOrigin(origins= "*")
@RestController
public class AutoridadController {

    private final AutoridadService autoridadService;

    public AutoridadController(AutoridadService autoridadService) {
        this.autoridadService = autoridadService;
    }

    @GetMapping({"/", ""})
    public ResponseEntity<List<Autoridad>> obtenerTodos() {
        List<Autoridad> autoridades = autoridadService.obtenerAutoridades();
        return new ResponseEntity<>(autoridades, HttpStatus.OK);
    }

}
