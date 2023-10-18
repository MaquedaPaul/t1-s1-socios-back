package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.dto.CategoriaDTO;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Categoria;

import java.util.List;

public interface CategoriaService {
    Categoria createCategoria(CategoriaDTO categoriaDTO) throws Exception;

    List<Categoria> findAllCategorias();
}
