package ar.utn.aceleradora.gestion.socios.controladores;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Categoria;
import ar.utn.aceleradora.gestion.socios.servicios.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequestMapping("/api/categoria")
@RestController
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCategoria(@PathVariable Integer id) {
        Categoria categoria = categoriaService.obtenerCategoria(id);
        return Optional.ofNullable(categoria)
                .map(s -> new ResponseEntity<>(s, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping()
    public ResponseEntity<Categoria> crearDepartamento(@RequestBody Categoria categoria) {
        Categoria nuevoCategoria = categoriaService.agregarCategoria(categoria);
        return new ResponseEntity<>(nuevoCategoria, HttpStatus.CREATED);
    }

    @GetMapping("/obtenerNombres")
    public ResponseEntity<List<String>> obtenerNombresCategoria() {
        List<String> nombres = categoriaService.obtenerNombres();
        return new ResponseEntity<>(nombres, HttpStatus.OK);
    }

    @GetMapping("/borrarCategoria/{idCategoria}")
    public ResponseEntity<String> eliminarCategoria(@PathVariable Integer idCategoria) {
        try {
            categoriaService.eliminarCategoria(idCategoria);
            return ResponseEntity.ok("Categoria eliminada exitosamente");
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La categoría no se encontró o no pudo ser eliminada");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Hubo un error al eliminar la categoría");
        }
    }
}
