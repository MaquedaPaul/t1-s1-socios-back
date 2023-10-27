package ar.utn.aceleradora.gestion.socios.controladores.socios;

import ar.utn.aceleradora.gestion.socios.dto.CategoriaDTO;
import ar.utn.aceleradora.gestion.socios.dto.ResponseDTO;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Categoria;
import ar.utn.aceleradora.gestion.socios.servicios.socios.CategoriaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaServiceImpl categoriaService;

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
