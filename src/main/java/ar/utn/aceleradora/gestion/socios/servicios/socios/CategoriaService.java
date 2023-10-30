package ar.utn.aceleradora.gestion.socios.servicios.socios;

import ar.utn.aceleradora.gestion.socios.dto.socios.CategoriaDTO;
import ar.utn.aceleradora.gestion.socios.error.CategoriaNotCreatedException;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Categoria;

import java.util.List;

public interface CategoriaService {
    void createCategoria(CategoriaDTO categoriaDTO) throws CategoriaNotCreatedException;

    List<Categoria> findAllCategorias();
}
