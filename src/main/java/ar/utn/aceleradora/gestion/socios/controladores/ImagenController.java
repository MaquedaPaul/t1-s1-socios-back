package ar.utn.aceleradora.gestion.socios.controladores;

import ar.utn.aceleradora.gestion.socios.servicios.ImagenesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


public class ImagenController {
//  @Autowired
//  private ImagenesService imagenesService;
//
//  @PostMapping("/subir/{idSocio}")
//  public ResponseEntity<String> subirImagen(@PathVariable Integer idSocio, @RequestParam("imagen") MultipartFile archivo) {
//    try {
//      String ruta = imagenesService.guardarImagen(archivo, idSocio);
//      return ResponseEntity.status(HttpStatus.CREATED).body(ruta);
//    } catch (Exception e) {
//      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("No se pudo subir la imagen");
//    }
//  }
//
//  @GetMapping("/obtener/{idSocio}")
//  public ResponseEntity<?> obtenerImagen(@PathVariable Integer idSocio) {
//    try {
//      String nombreArchivo = "usuario_" + idSocio;
//      Resource imagen = imagenesService.obtenerImagen(nombreArchivo);
//      return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagen);
//    } catch (RuntimeException e) {
//      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Imagen no encontrada");
//    } catch (Exception e) {
//      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No se pudo obtener la imagen");
//    }
//  }
//
//
//  @DeleteMapping("/eliminar/{idSocio}")
//  public ResponseEntity<?> eliminarImagen(@PathVariable Integer idSocio) {
//    String nombreArchivo = "usuario_" + idSocio;
//
//    boolean eliminada = imagenesService.eliminarImagenSiExiste(nombreArchivo);
//
//    if (eliminada) {
//      return ResponseEntity.ok("Imagen eliminada correctamente");
//    } else {
//      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La imagen no existe");
//    }
//  }




}