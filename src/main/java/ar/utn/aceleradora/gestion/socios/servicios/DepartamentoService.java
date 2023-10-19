package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.repositorios.DepartamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartamentoService {


    private final DepartamentoRepository departamentoRepository;

    @Autowired
    public DepartamentoService(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }

    public Departamento agregarDepartamento(Departamento departamento) {
        departamento.setId(null); // Establece el ID como nulo para crear un nuevo registro
        return departamentoRepository.save(departamento);
    }

    public void eliminarDepartamento(Integer id) {
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        if(departamento.isPresent()){
            departamentoRepository.deleteById(id);}
        else{throw new EntityNotFoundException("no se encontro departamento con id: "+id+"para borrar");
        }
    }

   /* public Departamento obtenerDepartamento(Integer id) {

        return departamentoRepository.findById(id).orElse(null);
    }*/

    public Departamento obtenerDepartamento(Integer id) {
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        if(departamento.isPresent()){
            return departamentoRepository.findById(id).orElse(null);}
        else{throw new EntityNotFoundException("no se encontro departamento con id: "+id+"para borrar");
        }
    }

    public Departamento actualizarDepartamento(Departamento departamento) {
        if (departamento.getId() != null) {
            return departamentoRepository.save(departamento);
        }
        else{throw new EntityNotFoundException("no se encontro departamento : "+departamento+"para actualizar");}
    }

    public List<String> obtenerNombres() {
        List<Departamento> socios = departamentoRepository.findAll();
        return socios.stream().map(Departamento::getNombre).collect(Collectors.toList());
    }

    public List<Departamento> obtenerTodosLosDepartamentos(){
        return departamentoRepository.findAll();
    }
}
