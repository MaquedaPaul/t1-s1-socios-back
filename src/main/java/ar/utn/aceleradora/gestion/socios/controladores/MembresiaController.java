package ar.utn.aceleradora.gestion.socios.controladores;

import ar.utn.aceleradora.gestion.socios.modelos.membresia.Membresia;
import ar.utn.aceleradora.gestion.socios.servicios.MembresiaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/membresias")
public class MembresiaController {

    @Autowired
    private MembresiaServiceImpl membresiaService;

    @GetMapping({"", "/"})
    public ResponseEntity<List<Membresia>> getAllCategories() {
        List<Membresia> membresias = membresiaService.findAllMembresias();
        return new ResponseEntity<>(membresias, HttpStatus.OK);
    }

}

