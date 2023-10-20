package ar.utn.aceleradora.gestion.socios.servicios;
import ar.utn.aceleradora.gestion.socios.dto.CreacionEdicionDepartamentoDTO;
import ar.utn.aceleradora.gestion.socios.error.DepartamentoNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.AutoridadNotFoundException;
import ar.utn.aceleradora.gestion.socios.modelos.Autoridad;
import ar.utn.aceleradora.gestion.socios.modelos.Coordinacion;
import ar.utn.aceleradora.gestion.socios.modelos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.repositorios.AutoridadRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.CoorDepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class DepartamentoServiceImpl implements DepartamentoService {


    private final DepartamentoRepository departamentoRepository;
    private final AutoridadRepository autoridadRepository;

    private final SocioRepository socioRepository;

    private final CoorDepartamentoRepository coordinacionRepository;

    @Autowired
    public DepartamentoServiceImpl(DepartamentoRepository departamentoRepository, AutoridadRepository autoridadRepository, SocioRepository socioRepository, CoorDepartamentoRepository coordinacionRepository) {
        this.departamentoRepository = departamentoRepository;
        this.autoridadRepository = autoridadRepository;
        this.socioRepository = socioRepository;
        this.coordinacionRepository = coordinacionRepository;
    }

/*
    public Departamento agregarDepartamento(Departamento departamento) {
        departamento.setId(null); // Establece el ID como nulo para crear un nuevo registro
        return departamentoRepository.save(departamento);
    }


 */

    @Override
    public Page<Departamento> obtenerDepartamentoPaginado(int page){
        Pageable pageable = Pageable.ofSize(10).withPage(page);
        return departamentoRepository.findAll(pageable);

    }
    @Override
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

    @Override
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

    @Override
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

            Optional<Coordinacion> coordinacionEncontrada = coordinacionRepository.findById(departamento.getIdCoordinacion());

            if(coordinacionEncontrada.isEmpty()){
                throw new Exception("No se encontro la coordinacion");
            }

            nuevoDepartamento.setCoordinacionDepartamental(coordinacionEncontrada.get());

            departamento.getAutoridades().stream().forEach(id -> {
                try {
                    nuevoDepartamento.agregarAutoridades(buscarAutoridadDeLaBase(id));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    throw new RuntimeException(e);
                }
            });


            departamento.getIdSocios().stream().forEach(id -> {
                try {
                    nuevoDepartamento.suscribirSocio(buscarSocioDeLaBase(id));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    throw new RuntimeException(e);
                }
            });

            return departamentoRepository.save(nuevoDepartamento);
        } catch (Exception e) {
            System.out.println(e.getMessage());
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
            System.out.println(e.getMessage());
            throw new Exception("No se pudo editar el departamento");
        }

    }

    private Autoridad buscarAutoridadDeLaBase(Integer id) throws Exception {

        try {
            return autoridadRepository.findById(id).get();
        } catch (Exception e){
            System.out.println(e.getMessage());
            throw new EntityNotFoundException("No se encontro la autoridad con id: " + id);
        }

    }

    private Socio buscarSocioDeLaBase(Integer id) throws Exception {

        try {
            return socioRepository.findById(id).get();
        } catch (Exception e){
            System.out.println(e.getMessage());
            throw new EntityNotFoundException("No se encontro el socio con id: " + id);
        }

    }

    @Override
    public List<Departamento> obtenerDepartamentos() {
        try{
            return departamentoRepository.findAll();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            throw new EntityNotFoundException("No se encontraron departamentos");
        }
    }

    @Override
    public void removerAutoridades(Integer idDepartamento, Integer idAutoridad){

        Optional<Departamento> departamentoAModificar = departamentoRepository.findById(idDepartamento);

        if (departamentoAModificar.isEmpty()){
            throw new DepartamentoNotFoundException("No se encontro el departamento con el id: "+idDepartamento);
        }

        if (departamentoAModificar.get().getAutoridades().stream().map(Autoridad::getId).noneMatch(id -> id.equals(idAutoridad))){
            throw new AutoridadNotFoundException("No existe una autoridad con el id: "+idAutoridad + " en el departamento");
        }

        Autoridad autoridad = autoridadRepository.findById(idAutoridad).get();

        try {
            departamentoAModificar.get().removerAutoridades(autoridad);
            departamentoRepository.save(departamentoAModificar.get());
        } catch (Exception e) {
            throw new RuntimeException("No se pudo guardar el departamento");
        }

    }

    @Override
    public void removerSocios(Integer idDepartamento, Integer idSocio) {
        Optional<Departamento> departamentoAModificar = departamentoRepository.findById(idDepartamento);

        if (departamentoAModificar.isEmpty()){
            throw new DepartamentoNotFoundException("No se encontro el departamento con el id: "+idDepartamento);
        }

        if (departamentoAModificar.get().getSociosSuscritos().stream().map(Socio::getId).noneMatch(id -> id.equals(idSocio))){
            throw new AutoridadNotFoundException("No existe una socio con el id: "+idSocio + " en el departamento");
        }

        Socio socio = socioRepository.findById(idSocio).get();

        try {
            departamentoAModificar.get().removerSocio(socio);
            departamentoRepository.save(departamentoAModificar.get());
        } catch (Exception e) {
            throw new RuntimeException("No se pudo guardar el departamento");
        }

    }

    @Override
    public void agregarSocios(List<Integer> sociosIds, Integer id) {
        Optional<Departamento> departamentoAModificar = departamentoRepository.findById(id);

        if (departamentoAModificar.isEmpty()){
            throw new DepartamentoNotFoundException("No se encontro el departamento con el id: "+id);
        }

        List<Optional<Socio>> optionalsSocios = sociosIds.stream()
                .map(socioRepository::findById)
                .toList();

        boolean todosPresentes = optionalsSocios.stream()
                .allMatch(Optional::isPresent);

        if(!todosPresentes){
            throw new DepartamentoNotFoundException("No se encontro alguno de los socios");
        }

        Departamento departamento = departamentoAModificar.get();
        List<Socio> socios = optionalsSocios.stream().map(Optional::get).toList();
        departamento.agregarSocios(socios);

        try{
            departamentoRepository.save(departamento);
        } catch (Exception e){
            throw new RuntimeException("No se pudo guardar el departamento");
        }


    }

}
