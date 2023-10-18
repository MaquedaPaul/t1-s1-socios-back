package ar.utn.aceleradora.gestion.socios.servicios;
import ar.utn.aceleradora.gestion.socios.dto.CreacionEdicionDepartamentoDTO;
import ar.utn.aceleradora.gestion.socios.error.DepartamentoNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.AutoridadNotFoundException;
import ar.utn.aceleradora.gestion.socios.modelos.Autoridad;
import ar.utn.aceleradora.gestion.socios.modelos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.repositorios.AutoridadRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DepartamentoServiceImpl implements DepartamentoService {


    private final DepartamentoRepository departamentoRepository;
    private final AutoridadRepository autoridadRepository;

    private final SocioRepository socioRepository;
    @Autowired
    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository, AutoridadRepository autoridadRepository, SocioRepository socioRepository) {
        this.departamentoRepository = departamentoRepository;
        this.autoridadRepository = autoridadRepository;
        this.socioRepository = socioRepository;
    }

/*
    public Departamento agregarDepartamento(Departamento departamento) {
        departamento.setId(null); // Establece el ID como nulo para crear un nuevo registro
        return departamentoRepository.save(departamento);
    }


 */

    public void eliminarDepartamento(Integer id) {
        Optional<Departamento> departamento = departamentoRepository.findById(id);
        if(departamento.isPresent())
        {
            departamentoRepository.deleteById(id);
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

    /*
    public Departamento actualizarDepartamento(Departamento departamento) {
        if (departamento.getId() != null) {
            return departamentoRepository.save(departamento);
        }
        else{throw new EntityNotFoundException("no se encontro departamento : "+departamento+"para actualizar");}
    }

     */

    public List<String> obtenerNombres() {
        List<Departamento> socios = departamentoRepository.findAll();
        return socios.stream().map(Departamento::getNombre).collect(Collectors.toList());
    }

    @Override
    public void agregarAutoridades(List<Integer> autoridadesIds, Integer id){
            Optional<Departamento> optionalDepartamento = departamentoRepository.findById(id);

            if (optionalDepartamento.isEmpty())
                throw new DepartamentoNotFoundException("No se encontro departamento con id: "+id);

            List<Optional<Autoridad>> optionalsAutoridades = autoridadesIds.stream()
                    .map(autoridadRepository::findById)
                    .toList();
            boolean todosPresentes = optionalsAutoridades.stream()
                    .allMatch(Optional::isPresent);
            if(!todosPresentes){
                throw new AutoridadNotFoundException("No se encontro alguna de las autoridades");
            }
            Departamento departamento = optionalDepartamento.get();
            List<Autoridad> autoridades = optionalsAutoridades.stream().map(Optional::get).toList();
            departamento.agregarAutoridades(autoridades);
            departamentoRepository.save(departamento);

    }

    @Override
    public Departamento crearDepartamento(CreacionEdicionDepartamentoDTO departamento) throws Exception{
        try {
            Departamento nuevoDepartamento = new Departamento();
            nuevoDepartamento.setNombre(departamento.getNombre());
            nuevoDepartamento.setJerarquia(departamento.getJerarquia());
            nuevoDepartamento.setDescripcion(departamento.getDescripcion());
            departamento.getAutoridades().stream().forEach(id -> {
                try {
                    nuevoDepartamento.agregarAutoridades(buscarAutoridadDeLaBase(id));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            departamento.getIdSocios().stream().forEach(id -> {
                try {
                    nuevoDepartamento.suscribirSocio(buscarSocioDeLaBase(id));
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });

            return departamentoRepository.save(nuevoDepartamento);
        } catch (Exception e) {
            throw new Exception("No se pudo crear el departamento");
        }

    }


    @Override
    public Departamento editarDepartamento(CreacionEdicionDepartamentoDTO departamento, Integer id) throws Exception{


        try {
            Optional<Departamento> nuevoDepartamento = departamentoRepository.findById(id);
            if(nuevoDepartamento.isEmpty()){
                throw new Exception("No existe un departamento con el id: " + id);
            }

            nuevoDepartamento.get().setNombre(departamento.getNombre());
            nuevoDepartamento.get().setJerarquia(departamento.getJerarquia());
            nuevoDepartamento.get().setDescripcion(departamento.getDescripcion());

            return departamentoRepository.save(nuevoDepartamento.get());
        } catch (Exception e) {
            throw new Exception("No se pudo editar el departamento");
        }

    }

    private Autoridad buscarAutoridadDeLaBase(Integer id) throws Exception {

        try {
            return autoridadRepository.findById(id).get();
        } catch (Exception e){
            throw new EntityNotFoundException("No se encontro la autoridad con id: " + id);
        }

    }

    private Socio buscarSocioDeLaBase(Integer id) throws Exception {

        try {
            return socioRepository.findById(id).get();
        } catch (Exception e){
            throw new EntityNotFoundException("No se encontro el socio con id: " + id);
        }

    }

}
