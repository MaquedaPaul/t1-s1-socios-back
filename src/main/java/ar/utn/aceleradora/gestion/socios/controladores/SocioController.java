package ar.utn.aceleradora.gestion.socios.controladores;

import ar.utn.aceleradora.gestion.socios.modelos.Socio;
import ar.utn.aceleradora.gestion.socios.servicios.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RequestMapping("/api/socio")
@RestController
public class SocioController {

    @Autowired
    private SocioService socioService;

    public SocioController(SocioService socioService) {
      this.socioService = socioService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Socio> obtenerProducto(@PathVariable Integer id) {
      Optional<Socio> socioOptional = socioService.obtenerSocio(id);

      return socioOptional
          .map(socio -> new ResponseEntity<>(socio, HttpStatus.OK))
          .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }


}
