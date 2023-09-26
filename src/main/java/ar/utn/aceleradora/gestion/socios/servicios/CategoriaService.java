package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Categoria;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Departamento;
import ar.utn.aceleradora.gestion.socios.repositorios.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository) {

        this.categoriaRepository = categoriaRepository;
    }

    public Categoria agregarCategoria(Categoria categoria) {
        categoria.setId(null); // Establece el ID como nulo para crear un nuevo registro
        return categoriaRepository.save(categoria);
    }

    public void eliminarCategoria(Integer id) {
        categoriaRepository.deleteById(id);
    }

    public Categoria obtenerCategoria(Integer id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    public Categoria actualizarCategoria(Categoria etiqueta) {
        if (etiqueta.getId() != null) {
            return categoriaRepository.save(etiqueta);
        }
        return null; // El departamento no tiene un ID válido
    }


    public List<String> obtenerNombres() {
        List<Categoria> socios = categoriaRepository.findAll();
        return socios.stream().map(Categoria::getNombre).collect(Collectors.toList());
    }

    public List<Categoria> obtenerCategoriasPorNombres(List<String> nombresCategorias) {
        return categoriaRepository.findByNombreIn(nombresCategorias);
    }

}
