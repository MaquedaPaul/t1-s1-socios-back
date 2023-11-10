package ar.utn.aceleradora.gestion.socios.servicios.socios;

import ar.utn.aceleradora.gestion.socios.dto.socios.CategoriaDTO;
import ar.utn.aceleradora.gestion.socios.error.socios.CategoriaNotCreatedException;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Categoria;

import ar.utn.aceleradora.gestion.socios.repositorios.socios.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public void createCategoria(CategoriaDTO categoryDTO) throws CategoriaNotCreatedException{
        try{
            Categoria categoria = new Categoria();
            categoria.setNombre(categoryDTO.getNombre());
            categoriaRepository.save(categoria);
        } catch (Exception e) {
            throw new CategoriaNotCreatedException("Error al crear la categoria");
        }

    }

    @Override
    public List<Categoria> findAllCategorias() {
        return categoriaRepository.findAll();
    }

}
