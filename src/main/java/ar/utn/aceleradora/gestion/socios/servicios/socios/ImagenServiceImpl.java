package ar.utn.aceleradora.gestion.socios.servicios.socios;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/*@Service
public class ImagenServiceImpl implements ImagenService {

  public String guardarImagenEnSistemaDeArchivos(MultipartFile file) throws IOException {
    // Definir la ubicación donde se guardarán las imágenes en el sistema de archivos
    String rutaDeAlmacenamiento = "./imagenes/";

    // Generar un nombre único para la imagen
    String nombreImagen = UUID.randomUUID() + "_" + file.getOriginalFilename();

    // Construir la ruta completa de la imagen
    String rutaCompleta = rutaDeAlmacenamiento + File.separator + nombreImagen;

    // Crear el archivo en el sistema de archivos
    File archivo = new File(rutaCompleta);

    // Guardar la imagen en el sistema de archivos
    file.transferTo(archivo);

    // Devolver la ruta relativa de la imagen, que se puede almacenar en la base de datos
    return nombreImagen;
  }

}*/

@Service
public class ImagenServiceImpl implements ImagenService {

  public String guardarImagenEnSistemaDeArchivos(MultipartFile file) throws IOException {
    try {
      // Obtén la ruta absoluta del directorio actual del proyecto
      String rutaDeAlmacenamiento = System.getProperty("user.dir");

      // Agrega la carpeta "imagenes" al path
      rutaDeAlmacenamiento = rutaDeAlmacenamiento + File.separator + "imagenes";

      // Crea la carpeta "imagenes" si no existe
      File carpetaImagenes = new File(rutaDeAlmacenamiento);
      if (!carpetaImagenes.exists()) {
        carpetaImagenes.mkdirs();
      }

      // Genera un nombre único para la imagen
      String nombreImagen = UUID.randomUUID() + "_" + file.getOriginalFilename();

      // Construye la ruta completa de la imagen
      String rutaCompleta = rutaDeAlmacenamiento + File.separator + nombreImagen;

      // Crea el archivo en el sistema de archivos y guarda la imagen
      File archivo = new File(rutaCompleta);
      file.transferTo(archivo);

      // Devuelve la ruta relativa de la imagen, que se almacena en la base de datos
      return nombreImagen;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}
