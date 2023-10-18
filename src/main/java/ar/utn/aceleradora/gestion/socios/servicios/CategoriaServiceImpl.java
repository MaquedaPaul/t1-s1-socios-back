package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.dto.CategoriaDTO;
import ar.utn.aceleradora.gestion.socios.modelos.departamento.Categoria;

import ar.utn.aceleradora.gestion.socios.repositorios.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    @Override
    public Categoria createCategoria(CategoriaDTO categoryDTO) throws Exception{
        try{
            Categoria categoria = new Categoria();
            categoria.setNombre(categoryDTO.getNombre());
            return categoriaRepository.save(categoria);
        } catch (Exception e) {
            throw new Exception("Error al crear la categoria");
        }

    }

    @Override
    public List<Categoria> findAllCategorias() {
        return categoriaRepository.findAll();
    }

}
