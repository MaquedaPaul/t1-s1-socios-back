package ar.utn.aceleradora.gestion.socios.controladores;

import ar.utn.aceleradora.gestion.socios.dto.ResponseDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioUpdateDTO;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import ar.utn.aceleradora.gestion.socios.servicios.SocioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/socios")
public class SocioController {

    @Autowired
    private SocioService socioService;


    @GetMapping({"", "/"})
    public ResponseEntity<List<Socio>> findAll() {
        try {
            List<Socio> socios = socioService.findAllSocios();

            return ResponseEntity.ok(socios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping({"/paginado"})
    public ResponseEntity<Page<Socio>> findAllPaginado(@RequestParam(name = "page", defaultValue = "0") int page) {
        try {
            Page<Socio> socios = socioService.findAllSociosPaginado(page);

            return ResponseEntity.ok(socios);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

//    @GetMapping("/{id}")
//    public ResponseEntity<Socio> findById(@PathVariable Integer id) {
//        try {
//            Socio socio = socioRepository.findById(id).orElseThrow();
//
//            return ResponseEntity.ok(socio);
//        } catch (Exception e) {
//            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
//        }
//    }

    @PostMapping({"", "/"})
    public ResponseEntity<ResponseDTO> createPartner(@RequestBody SocioCreateDTO partner) {
        try {
            socioService.createSocio(partner);

            return ResponseEntity.ok(new ResponseDTO("Socio creado satisfactoriamente", "CREATE", 200));
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage(), "SECCESS", 500), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PatchMapping({"{id}"})
    public ResponseEntity<ResponseDTO> updatePartner (@RequestBody SocioUpdateDTO socio, @PathVariable Integer id) {
        try {
            socioService.updateSocio(socio, id);

            return ResponseEntity.ok(new ResponseDTO("Socio editado satisfactoriamente", "SUCCESS", 200));
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage(), "INTERNAL_SERVER_ERROR", 500),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseDTO> delete(@PathVariable Integer id) {
        try {
            Boolean deleted = socioService.deleteSocioById(id);

            if (deleted)
                return new ResponseEntity<>(new ResponseDTO("El socio ha sido borrado", "SUCCESS", 200),HttpStatus.OK);
            return new ResponseEntity<>(new ResponseDTO("socio con " + id + " no encontrado", "INTERNAL_SERVER_ERROR", 404),HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage(), "INTERNAL_SERVER_ERROR", 500),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}