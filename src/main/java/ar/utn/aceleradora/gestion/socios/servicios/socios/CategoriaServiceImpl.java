package ar.utn.aceleradora.gestion.socios.servicios.socios;

import ar.utn.aceleradora.gestion.socios.dto.CategoriaDTO;
import ar.utn.aceleradora.gestion.socios.error.CategoriaNotCreatedException;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Categoria;

import ar.utn.aceleradora.gestion.socios.repositorios.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria createCategoria(CategoriaDTO categoryDTO) throws CategoriaNotCreatedException{
        try{
            Categoria categoria = new Categoria();
            categoria.setNombre(categoryDTO.getNombre());
            return categoriaRepository.save(categoria);
        } catch (Exception e) {
            throw new CategoriaNotCreatedException("Error al crear la categoria");
        }

    }

    @Override
    public List<Categoria> findAllCategorias() {
        return categoriaRepository.findAll();
    }

}
