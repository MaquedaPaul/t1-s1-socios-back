package ar.utn.aceleradora.gestion.socios.controladores;

import ar.utn.aceleradora.gestion.socios.dto.ResumenSocioDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioPlenarioDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioPostDTO;
import ar.utn.aceleradora.gestion.socios.servicios.SocioService;

import com.mysql.cj.protocol.Message;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.relational.core.sql.In;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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

    @GetMapping("/obtenerSocioPorNombre/{nombre}")
    public ResponseEntity<SocioDTO> obtenerSocio(@PathVariable String nombre) {
        SocioDTO socio = socioService.obtenerSocio(nombre);
        return Optional.ofNullable(socio)
                .map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<SocioDTO> crearSocio(@Valid @RequestBody SocioPostDTO socio) {

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
            @RequestParam(defaultValue = "10") int tamanio,
            @RequestParam(name = "categoria", required = false) List<String> categorias,
            @RequestParam(name = "aniosActivos", required = false) Integer aniosActivos,
            @RequestParam(name = "tipoSocio", required = false) String tipoSocio,
            @RequestParam(name = "nombre", required = false) String nombre,
            @RequestParam(name = "activo", required = false) Boolean activo){
        Optional<List<String>> categoriasOptionales = Optional.ofNullable(categorias);
        Optional<Integer> aniosActivosOptional = Optional.ofNullable(aniosActivos);
        Optional<String> tipoSocioOptional = Optional.ofNullable(tipoSocio);
        Optional<String> nombreOptional = Optional.ofNullable(nombre);
        Optional<Boolean> activoOptional = Optional.ofNullable(activo);

        Page<ResumenSocioDTO> pages = socioService.obtenerResumenSociosPaginados(pagina, tamanio, categoriasOptionales, aniosActivosOptional, tipoSocioOptional, nombreOptional,activoOptional);
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
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (EntityNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/{id}/categorias")
    public ResponseEntity<SocioDTO> agregarCategoriasASocio(@PathVariable Integer id, @RequestBody List<String> categorias) {
        try {
            SocioDTO socioConEtiquetas = socioService.agregarCategoriasASocio(id, categorias);
            return new ResponseEntity<>(socioConEtiquetas, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Socio no encontrado", e);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error al agregar etiquetas al socio", e);
        }
    }

    @GetMapping("/{id}/categorias")
    public ResponseEntity<List<String>> obtenerCategoriasDeSocio(@PathVariable Integer id) {
        try {
            List<String> categorias = socioService.obtenerCategoriasDeSocio(id);
            return new ResponseEntity<>(categorias, HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Socio no encontrado", e);
        }
    }

    @DeleteMapping("/{id}/categorias")
    public ResponseEntity<Void> eliminarCategoriaDeSocio(@PathVariable Integer id, @RequestParam(name = "categoria") String categoria) {
        try {
            socioService.eliminarCategoriaDeSocio(id, categoria);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Socio no encontrado", e);
        }
    }

    @PutMapping("/{id}/actualizar/categorias")
    public ResponseEntity<Void> actualizarCategoriasDeSocio(@PathVariable Integer id, @RequestBody List<String> categorias) {
        try {
            socioService.actualizarCategoriasDeSocio(id, categorias);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Socio no encontrado", e);
        }
    }

    @PutMapping("/darAlta/{id}")
    public ResponseEntity<Void> darAltaSocio(@PathVariable Integer id){
        try{
            socioService.darAltaSocio(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }catch (EntityNotFoundException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Socio no encontrado", e);
        }
    }

    @GetMapping("/tipoSocio")
    public ResponseEntity<List<String>> obtenerTiposDeSocio() {
        List<String> tiposDeSocio = socioService.getAllTipoSocio();
        return new ResponseEntity<>(tiposDeSocio, HttpStatus.OK);
    }


}
