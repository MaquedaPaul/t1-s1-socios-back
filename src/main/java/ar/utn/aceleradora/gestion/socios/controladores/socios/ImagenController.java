package ar.utn.aceleradora.gestion.socios.controladores.socios;

import ar.utn.aceleradora.gestion.socios.servicios.socios.ImagenService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins= "*")
@RequestMapping("/imagenes")
public class ImagenController {

    private final ImagenService imagenService;

    @Autowired
    public ImagenController(ImagenService imagenService) {
        this.imagenService = imagenService;
    }

    @GetMapping("/{idSocio}")
    public void mostrarImagen(@PathVariable Integer idSocio, HttpServletResponse response) throws IOException {
        this.imagenService.mostrarImagen(idSocio, response);

    }

}