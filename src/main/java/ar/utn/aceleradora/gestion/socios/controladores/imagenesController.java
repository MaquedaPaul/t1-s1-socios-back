package ar.utn.aceleradora.gestion.socios.controladores;

import ar.utn.aceleradora.gestion.socios.servicios.ImagenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/imagenes")
public class imagenesController {
  @Autowired
  private ImagenesService imagenesService;

  @PostMapping("/subir/{idSocio}")
  public ResponseEntity<String> subirImagen(@PathVariable Integer idSocio, @RequestParam("imagen") MultipartFile archivo) {
    try {
      String ruta = imagenesService.guardarImagen(archivo, idSocio);
      return ResponseEntity.ok(ruta);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo subir la imagen");
    }
  }

  @GetMapping("/obtener/{idSocio}")
  public ResponseEntity<?> obtenerImagen(@PathVariable Integer idSocio) {
    try {
      String nombreArchivo = "usuario_" + idSocio;
      Resource imagen = imagenesService.obtenerImagen(nombreArchivo);
      return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagen);
    } catch (RuntimeException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Imagen no encontrada");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo obtener la imagen");
    }
  }

}
