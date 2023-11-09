package ar.utn.aceleradora.gestion.socios.servicios.socios;

import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImagenServiceImpl implements ImagenService {

  private final SocioRepository socioRepository;

  @Autowired
  public ImagenServiceImpl(SocioRepository socioRepository){
    this.socioRepository = socioRepository;
  }


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
      return rutaCompleta;
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }

  @Override
  public void mostrarImagen(Integer socioId, HttpServletResponse response) throws IOException {

    Optional<Socio> socioOptional = this.socioRepository.findById(socioId);

    if (socioOptional.isPresent() && socioOptional.get().getImagen().getRutaImagen() != null && socioOptional.get().getImagen() != null) {
      Socio socio = socioOptional.get();

      String filePath = socio.getImagen().getRutaImagen();
      // Abre el archivo de imagen
      File file = new File(filePath);

      if (file.exists()) {
        // Configura la respuesta HTTP para la imagen
        response.setContentType("image/jpeg");
        response.setContentLength((int) file.length());

        // Copia el contenido del archivo al flujo de salida de la respuesta
        try (FileInputStream inputStream = new FileInputStream(file);
             OutputStream outputStream = response.getOutputStream()) {
          byte[] buffer = new byte[4096];
          int bytesRead;
          while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
          }
        }
      } else {
        // el archivo de imagen no existe
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Imagen no encontrada");
      }
    } else {
      // el socio no existe o no tiene una ruta de imagen
      response.sendError(HttpServletResponse.SC_NOT_FOUND, "Socio no encontrado o sin imagen asociada");
    }
  };
}
