package ar.utn.aceleradora.gestion.socios.servicios.socios;

import ar.utn.aceleradora.gestion.socios.servicios.socios.ImagenService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class ImagenServiceImpl implements ImagenService {

  public String guardarImagenEnSistemaDeArchivos(MultipartFile file) throws IOException {
    // Definir la ubicación donde se guardarán las imágenes en el sistema de archivos
    String rutaDeAlmacenamiento = "src/main/resources/imagenes";

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


}
