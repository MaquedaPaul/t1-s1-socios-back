package ar.utn.aceleradora.gestion.socios.servicios;

import net.coobird.thumbnailator.Thumbnails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

//@Service
public class ImagenesService {

  @Value("${PATH_IMAGENES}")
  private String path_imagenes;

  public String guardarImagen(MultipartFile archivo, Integer idSocio) throws IOException {
    String nombreArchivo = "usuario_" + idSocio;
    Path ubicacionCopia = Paths.get(path_imagenes + File.separator + nombreArchivo + ".JPEG");
    optimizarImagen(archivo, ubicacionCopia.toString());
    return ubicacionCopia.toString();
  }

  public String guardarImagenSinId(MultipartFile archivo) throws IOException {
    String nombreArchivo = UUID.randomUUID().toString() + ".JPEG"; // Genera un nombre único para la imagen
    Path ubicacionCopia = Paths.get(path_imagenes + File.separator + nombreArchivo);
    optimizarImagen(archivo, ubicacionCopia.toString());
    return nombreArchivo; // Devuelve el nombre único de la imagen
  }

  private void optimizarImagen(MultipartFile archivo, String rutaDestino) throws IOException {
    Thumbnails.of(archivo.getInputStream())
        .size(640, 360)
        .outputFormat("JPEG")
        .outputQuality(0.75)
        .toFile(rutaDestino);
  }

  public Resource obtenerImagen(String nombreArchivo) {
    try {
      nombreArchivo = nombreArchivo.endsWith(".JPEG") ? nombreArchivo : nombreArchivo + ".JPEG";
      Path rutaArchivo = Paths.get(path_imagenes).resolve(nombreArchivo).normalize();
      Resource recurso = new UrlResource(rutaArchivo.toUri());
      if (recurso.exists()) {
        return recurso;
      } else {
        throw new RuntimeException("Archivo no encontrado: " + nombreArchivo);
      }
    } catch (Exception ex) {
      throw new RuntimeException("Error al buscar el archivo: " + nombreArchivo, ex);
    }
  }

  public void eliminarImagen(String nombreArchivo) {
    try {
      Path rutaParaEliminar = Paths.get(path_imagenes + File.separator + StringUtils.cleanPath(nombreArchivo));
      Files.deleteIfExists(rutaParaEliminar);
    } catch (IOException e) {
      throw new RuntimeException("Error al eliminar la imagen", e);
    }
  }
  public boolean eliminarImagenSiExiste(String nombreArchivo) {
    try {
      Path rutaParaEliminar = Paths.get(path_imagenes + File.separator + nombreArchivo + ".JPEG");

      if (Files.exists(rutaParaEliminar)) {
        Files.delete(rutaParaEliminar);
        return true; // La imagen se eliminó con éxito
      } else {
        return false; // La imagen no existía
      }
    } catch (IOException e) {
      throw new RuntimeException("Error al eliminar la imagen", e);
    }
  }


}
