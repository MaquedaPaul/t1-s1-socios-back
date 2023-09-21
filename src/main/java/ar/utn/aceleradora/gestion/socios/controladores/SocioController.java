package ar.utn.aceleradora.gestion.socios.controladores;

import ar.utn.aceleradora.gestion.socios.dto.ResumenSocioDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioPlenarioDTO;
import ar.utn.aceleradora.gestion.socios.servicios.SocioService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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
    public ResponseEntity<SocioDTO> obtenerSocio(@PathVariable Integer id) {
        SocioDTO socio = socioService.obtenerSocio(id);
        return Optional.ofNullable(socio)
            .map(s -> new ResponseEntity<>(s, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<SocioDTO> crearSocio(@RequestBody SocioDTO socio) {
        SocioDTO nuevoSocio = socioService.guardarSocio(socio);
        return new ResponseEntity<>(nuevoSocio, HttpStatus.CREATED);
    }

    @GetMapping("/obtenerNombres")
    public ResponseEntity<List<String>> obtenerNombres() {
        List<String> nombres = socioService.obtenerNombres();
        return new ResponseEntity<>(nombres, HttpStatus.OK);
    }

    @GetMapping("/busquedaPaginada")
    public ResponseEntity<Page<ResumenSocioDTO>> obtenerResumenSocios(
        @RequestParam(defaultValue = "0") int pagina,
        @RequestParam(defaultValue = "10") int tamanio) {
        Page<ResumenSocioDTO> pages = socioService.obtenerResumenSociosPaginados(pagina, tamanio);
        return ResponseEntity.ok(pages);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SocioDTO> actualizarSocio(@PathVariable Integer id, @RequestBody SocioDTO socio) {
        SocioDTO socioActualizado = socioService.actualizarSocio(id, socio);
        return Optional.ofNullable(socioActualizado)
            .map(s -> new ResponseEntity<>(s, HttpStatus.OK))
            .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarSocio(@PathVariable Integer id) {
        try {
            SocioDTO socioEliminado = socioService.eliminarSocio(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
