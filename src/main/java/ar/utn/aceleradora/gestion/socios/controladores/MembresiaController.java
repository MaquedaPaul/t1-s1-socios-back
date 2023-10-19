package ar.utn.aceleradora.gestion.socios.controladores;

import ar.utn.aceleradora.gestion.socios.modelos.membresia.Membresia;
import ar.utn.aceleradora.gestion.socios.servicios.MembresiaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/membresias")
public class MembresiaController {

    @Autowired
    private MembresiaServiceImpl membresiaService;

    @GetMapping({"", "/"})
    public ResponseEntity<List<Membresia>> getAllMembresias() {
        List<Membresia> membresias = membresiaService.findAllMembresias();
        return new ResponseEntity<>(membresias, HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<List<Membresia>> guardarCategorias(@RequestBody Membresia membresia) {
        List<Membresia> membresias = membresiaService.guardarMembresia(membresia);
        return new ResponseEntity<>(membresias, HttpStatus.OK);
    }

}

