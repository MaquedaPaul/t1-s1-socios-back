package ar.utn.aceleradora.gestion.socios.controladores.socios;

import ar.utn.aceleradora.gestion.socios.dto.eventos.ResponseDTO;
import ar.utn.aceleradora.gestion.socios.dto.socios.SocioCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.socios.SocioUpdateDTO;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.servicios.socios.ImagenService;
import ar.utn.aceleradora.gestion.socios.servicios.socios.SocioService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import retrofit2.http.Multipart;

import java.util.List;

@RestController
@CrossOrigin(origins= "*")
@RequestMapping("/socios")
public class SocioController {

    private final SocioService socioService;
    private final ImagenService imagenService;

    @Autowired
    public SocioController(SocioService socioService, ImagenService imagenService) {
        this.socioService = socioService;
        this.imagenService = imagenService;
    }


    @GetMapping({"", "/"})
    public ResponseEntity<List<Socio>> findAll() throws Exception {
            List<Socio> socios = socioService.findAllSocios();
            return ResponseEntity.ok(socios);
    }

    @GetMapping({"/paginado"})
    public ResponseEntity<Page<Socio>> findAllPaginado(@RequestParam(name = "page", defaultValue = "0") int page) throws Exception {
            Page<Socio> socios = socioService.findAllSociosPaginado(page);
            return ResponseEntity.ok(socios);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<ResponseDTO> createPartner(@RequestPart("file") MultipartFile file, @RequestPart("partner") String StringPartner) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            SocioCreateDTO partner = objectMapper.readValue(StringPartner, SocioCreateDTO.class);

            String rutaImagen = imagenService.guardarImagenEnSistemaDeArchivos(file);
            socioService.createSocio(partner, rutaImagen);

            return ResponseEntity.ok(new ResponseDTO("Socio creado satisfactoriamente", "CREATE", 200));
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage(), "INTERNAL_SERVER_ERROR", 500), HttpStatus.INTERNAL_SERVER_ERROR);
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
            socioService.deleteSocioById(id);
                return new ResponseEntity<>(new ResponseDTO("El socio ha sido borrado", "SUCCESS", 200),HttpStatus.OK);

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findSocioById(@PathVariable Integer id){
            Socio socio = socioService.findSocioById(id);
                return ResponseEntity.ok(socio);
            }
}