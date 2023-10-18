package ar.utn.aceleradora.gestion.socios.servicios;
import ar.utn.aceleradora.gestion.socios.error.DepartamentoNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.AutoridadNotFoundException;
import ar.utn.aceleradora.gestion.socios.modelos.departamento.Departamento;
import ar.utn.aceleradora.gestion.socios.repositorios.DepartamentoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DepartamentoServiceImpl implements DepartamentoService {


    private final DepartamentoRepository departamentoRepository;
    @Autowired
    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository) {
        this.departamentoRepository = departamentoRepository;
    }


    public Departamento agregarDepartamento(Departamento departamento) {
        departamento.setId(null); // Establece el ID como nulo para crear un nuevo registro
        return departamentoRepository.save(departamento);
    }

    public Boolean eliminarDepartamento(Integer id) {
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        if(departamento.isPresent())
        {
            departamentoRepository.deleteById(id);
            return true;
        }
        else{
            throw new DepartamentoNotFoundException("no se encontro departamento con id: "+id+"para borrar");
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

    @Override
    public void agregarAutoridades(List<Integer> autoridadesIds, Integer id) throws Exception {
        try {
            Optional<Departamento> optionalDepartamento = departamentoRepository.findById(id);

            if (optionalDepartamento.isEmpty())
                throw new DepartamentoNotFoundException("No se encontro departamento con id: "+id);
            List<Optional<Departamento>> optionalsAutoridades = autoridadesIds.stream()
                    .map(departamentoRepository::findById)
                    .toList();
            boolean todosPresentes = optionalsAutoridades.stream()
                    .allMatch(Optional::isPresent);
            if(!todosPresentes){
                throw new AutoridadNotFoundException("No se encontro alguno de las autoridades");
            }
            Departamento departamento = optionalDepartamento.get();
            List<Departamento> autoridades = optionalsAutoridades.stream().map(Optional::get).toList();
            departamento.agregarAutoridades(autoridades);
            departamentoRepository.save(departamento);
        } catch (Exception e) {
            throw new Exception("Error al agregar una autoridad, por favor intentelo más tarde");
        }
    }

}
