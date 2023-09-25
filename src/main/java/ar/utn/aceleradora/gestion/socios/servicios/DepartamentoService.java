package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Departamento;
import ar.utn.aceleradora.gestion.socios.repositorios.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        departamentoRepository.deleteById(id);
    }

    public Departamento obtenerDepartamento(Integer id) {
        return departamentoRepository.findById(id).orElse(null);
    }

    public Departamento actualizarDepartamento(Departamento departamento) {
        if (departamento.getId() != null) {
            return departamentoRepository.save(departamento);
        }
        return null; // El departamento no tiene un ID válido
    }

}
