package ar.utn.aceleradora.gestion.socios.controladores.socios;

import ar.utn.aceleradora.gestion.socios.dto.socios.CategoriaDTO;
import ar.utn.aceleradora.gestion.socios.dto.ResponseDTO;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Categoria;
import ar.utn.aceleradora.gestion.socios.servicios.socios.CategoriaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins= "*")
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaServiceImpl categoriaService;

    public CategoriaController(CategoriaServiceImpl categoriaService) {
        this.categoriaService = categoriaService;
    }

    @PostMapping({"", "/"})
    public ResponseEntity<ResponseDTO> createCategory(@RequestBody CategoriaDTO categoriaDTO){
            categoriaService.createCategoria(categoriaDTO);
            return new ResponseEntity<>(new ResponseDTO("Categoria creada", "SUCCESS", 200),HttpStatus.OK);
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<Categoria>> getAllCategories() {
        List<Categoria> categorias = categoriaService.findAllCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

}
