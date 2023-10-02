package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Categoria;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Departamento;
import ar.utn.aceleradora.gestion.socios.repositorios.CategoriaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent()){
        categoriaRepository.deleteById(id);}
        else{throw new EntityNotFoundException("no se econtro categoria con id: "+id);}
    }

    public Categoria obtenerCategoria(Integer id) {
        Optional<Categoria> categoria = categoriaRepository.findById(id);
        if(categoria.isPresent()){
            return categoriaRepository.findById(id).orElse(null);}
        else{throw new EntityNotFoundException("no se econtro categoria con id: "+id);}
    }

    /*
    public Categoria obtenerCategoria(Integer id) { ============================================ A SI ES ES MAS LIMPIO, PERO NO SE SI ES LO MISMO, ASIQ LO DEJO ACA COMENTADO PARA TESTEAR DESPUES
    Optional<Categoria> categoriaOptional = categoriaRepository.findById(id);

    if (categoriaOptional.isPresent()) {
        return categoriaOptional.get();
    } else {
        throw new EntityNotFoundException("No se encontró una categoría con ID: " + id);
    }
}
     */

    public Categoria actualizarCategoria(Categoria etiqueta) {
        if (etiqueta.getId() != null) {
            return categoriaRepository.save(etiqueta);
        }
        else{throw new EntityNotFoundException("no se econtro una categoria : "+etiqueta);}
    }


    public List<String> obtenerNombres() {
        List<Categoria> categorias = categoriaRepository.findAll();

        return categorias.stream().map(Categoria::getNombre).collect(Collectors.toList());
    }

    public Categoria obtenerCategoriaPorNombre(String nombre) {
        Categoria categoria = categoriaRepository.findByNombre(nombre);
        if(categoria != null){
            return categoriaRepository.findByNombre(nombre);}
        else{throw new EntityNotFoundException("categoria no encontrada con nombre: "+nombre);}
    }

    public List<Categoria> obtenerCategoriasPorNombres(List<String> nombresCategorias) {
        return categoriaRepository.findByNombreIn(nombresCategorias);
    }

}
