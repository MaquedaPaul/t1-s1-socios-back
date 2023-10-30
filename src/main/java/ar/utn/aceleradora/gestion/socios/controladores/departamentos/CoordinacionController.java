package ar.utn.aceleradora.gestion.socios.controladores.departamentos;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Coordinacion;
import ar.utn.aceleradora.gestion.socios.servicios.departamentos.CoordinacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/coordinaciones")
@CrossOrigin(origins= "*")
@RestController
public class CoordinacionController {
    private CoordinacionService coordinacionService;

    @Autowired
    public CoordinacionController(CoordinacionService coordinacionService) {
        this.coordinacionService = coordinacionService;
    }

    @GetMapping({"/", ""})
    public ResponseEntity<Coordinacion> obtenerCoordinaciones() {
        try {
            List<Coordinacion> coordinaciones = coordinacionService.obtenerCoordinaciones();
            return new ResponseEntity(coordinaciones, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
