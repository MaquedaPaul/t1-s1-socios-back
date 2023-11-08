package ar.utn.aceleradora.gestion.socios.servicios.socios;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface ImagenService {
    String guardarImagenEnSistemaDeArchivos(MultipartFile file) throws IOException;
}
