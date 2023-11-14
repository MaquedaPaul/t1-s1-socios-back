package ar.utn.aceleradora.gestion.socios.servicios.eventos;

import ar.utn.aceleradora.gestion.socios.converters.DateConverter;
import ar.utn.aceleradora.gestion.socios.dto.departamentos.ProyeccionDepartamentoDTO;
import ar.utn.aceleradora.gestion.socios.dto.eventos.*;
import ar.utn.aceleradora.gestion.socios.dto.eventos.EventoCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.eventos.EventoUpdateDTO;
import ar.utn.aceleradora.gestion.socios.dto.eventos.ListaEventoDTO;
import ar.utn.aceleradora.gestion.socios.error.departamentos.AutoridadNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.eventos.EstadoEventoNoValidoException;
import ar.utn.aceleradora.gestion.socios.error.eventos.EventoNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.eventos.ModalidadNoValidaException;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Autoridad;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.EstadoEvento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.Evento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoEstadoEvento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoModalidad;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.TipoEstadoInscripto;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.AutoridadRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.eventos.EventoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.socios.SocioRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EventoServiceImpl implements EventoService {

    private EventoRepository eventoRepository;
    private DepartamentoRepository departamentoRepository;
    private SocioRepository socioRepository;
    private UbicacionRepository ubicacionRepository;
    private AutoridadRepository autoridadRepository;

    @Autowired
    public EventoServiceImpl(EventoRepository eventoRepository, DepartamentoRepository departamentoRepository, SocioRepository socioRepository, UbicacionRepository ubicacionRepository, AutoridadRepository autoridadRepository) {
        this.eventoRepository = eventoRepository;
        this.departamentoRepository = departamentoRepository;
        this.socioRepository = socioRepository;
        this.ubicacionRepository = ubicacionRepository;
        this.autoridadRepository = autoridadRepository;
    }

    @Override
    public void crearEvento(EventoCreateDTO evento) throws Exception {
        try{
            LocalDate fechaComienzo = DateConverter.parse(evento.getFechaComienzo());
            LocalDate fechaFin = DateConverter.parse(evento.getFechaFin());
            LocalTime hora = DateConverter.parseDateTime(evento.getHora());
            Ubicacion ubicacion = new Ubicacion(evento.getDireccion(), evento.getPiso(), evento.getDepartamento(), evento.getLocalidad(), evento.getProvincia());
            ubicacionRepository.save(ubicacion);
            List<Departamento> departamentos = this.departamentoRepository.findAllById(evento.getId_departamentos());
            Evento nuevoEvento = new Evento(evento.getNombre(), evento.getDescripcion(), fechaComienzo, fechaFin, obtenerTipoModalidad(evento.getModalidad()), ubicacion, departamentos, hora);

            eventoRepository.save(nuevoEvento);
        } catch (Exception e) {
            throw new Exception("Error al crear el evento, por favor intentelo más tarde");
        }
    }


    @Override
    public Evento obtenerEventoPorId(Integer eventoId) throws Exception {
        try{
            return eventoRepository.findById(eventoId).orElse(null);
        } catch (Exception e) {
            throw new Exception("Error al obtener evento por id, por favor intentelo más tarde");
        }
    }


    @Override
    public Autoridad obtenerAutoridadPorId(Integer autoridadId) {
        return autoridadRepository.findById(autoridadId)
                .orElseThrow(() -> new AutoridadNotFoundException("No se encontró ninguna autoridad con el ID proporcionado: " + autoridadId));
    }

    @Override
    public List<TipoModalidad> listasModalidades() {
        return  new ArrayList<>(List.of(TipoModalidad.values()));
    }

    @Override
    public List<TipoEstadoEvento> listarEstadosEventos() {
        return  new ArrayList<>(List.of(TipoEstadoEvento.values()));
    }

    @Override
    public List<TipoEstadoInscripto> listarEstadosInscriptos() {
        return  new ArrayList<>(List.of(TipoEstadoInscripto.values()));
    }

    @Override
    public Boolean editarEvento(EventoUpdateDTO eventoUpdate, Integer id) throws Exception {
        try{
            Optional<Evento> optionalEvento = eventoRepository.findById(id);

            if (optionalEvento.isEmpty())
                return false;

            Evento existingEvento = optionalEvento.get();

            existingEvento.setNombre(eventoUpdate.getNombre());
            existingEvento.setDescripcion(eventoUpdate.getDescripcion());

            LocalDate fechaComienzo = DateConverter.parse(eventoUpdate.getFechaComienzo());
            existingEvento.setFechaComienzo(fechaComienzo);
            LocalDate fechaFin = DateConverter.parse(eventoUpdate.getFechaFin());
            existingEvento.setFechaFin(fechaFin);

            existingEvento.setModalidad(obtenerTipoModalidad(eventoUpdate.getModalidad()));

            Ubicacion ubicacion = new Ubicacion(eventoUpdate.getDireccion(), eventoUpdate.getPiso(), eventoUpdate.getDepartamento(), eventoUpdate.getLocalidad(), eventoUpdate.getProvincia());
            existingEvento.setUbicacion(ubicacion);

            List<Departamento> departamentos = this.departamentoRepository.findAllById(eventoUpdate.getId_departamentos());
            existingEvento.setDepartamentos(departamentos);

            List<Socio> invitados = departamentos.stream()
                    .flatMap(departamento -> departamento.getSociosSuscritos().stream())
                    .collect(Collectors.toList());
            existingEvento.setInvitados(invitados);

            if(noEsVacio(eventoUpdate.getTipoEstadoEvento())) {
                EstadoEvento estado = new EstadoEvento(obtenerTipoEstadoEvento(eventoUpdate.getTipoEstadoEvento()), LocalDateTime.now(), eventoUpdate.getMotivo());
                existingEvento.agregarEstado(estado);
            }

            ubicacionRepository.save(ubicacion);
            eventoRepository.save(existingEvento);
            return true;
        } catch (Exception e) {
            throw new Exception("Error al editar el evento, por favor intentelo más tarde");
        }
    }

    private boolean noEsVacio(String id) {
            return id != null;
    }

    private TipoEstadoEvento obtenerTipoEstadoEvento(String estadoEventoString) {

        try {
            return TipoEstadoEvento.valueOf(estadoEventoString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw  new EstadoEventoNoValidoException("El estado del evento: "+estadoEventoString+" no es reconocido");
        }
    }

    private TipoModalidad obtenerTipoModalidad(String modalidadString) {

        try {
            return TipoModalidad.valueOf(modalidadString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw  new ModalidadNoValidaException("La modalidad: "+modalidadString+" no es reconocida");
        }

    }

    @Override
    public List<ListaEventoDTO> listarEventos() throws Exception {
        List<Evento> eventos = eventoRepository.findAll();
        List<ListaEventoDTO> eventoDTOs = new ArrayList<>();
        try {
            for (Evento evento : eventos) {
                ListaEventoDTO eventoDTO = new ListaEventoDTO();
                eventoDTO.setId(evento.getId());
                eventoDTO.setUuid(evento.getUuid());
                eventoDTO.setNombre(evento.getNombre());
                eventoDTO.setFechaComienzo(evento.getFechaComienzo());
                eventoDTO.setTipoEstadoEvento(evento.estadoActual().getTipoEstadoEvento());
                eventoDTO.setDireccion(evento.getUbicacion().getDireccion());
                eventoDTO.setModalidad(evento.getModalidad());
                eventoDTOs.add(eventoDTO);
            }
            return eventoDTOs;
        } catch (Exception e) {
            throw new Exception("Error al listar los eventos, por favor intentelo más tarde");
        }
    }

    @Override
    public EventoLimitadoDTO listarEvento(UUID id) throws Exception{

        Evento evento = eventoRepository.findByUuid(id).orElseThrow(() -> new EventoNotFoundException("No se pudo encontrar el evento con uuid: "+id));
        EventoLimitadoDTO eventoLimitadoDTO = new EventoLimitadoDTO();

        List<ProyeccionDepartamentoDTO> proyeccionesDepartamentoDTO = new ArrayList<>();
        List<ProyeccionSocioDTO> proyeccionesSocioDTO = new ArrayList<>();
        List<Socio> invitados = evento.getInvitados();
        List<Departamento> departamentos = evento.getDepartamentos();

        mapearDatosPrimitivos(eventoLimitadoDTO, evento);
        mapearProyeccionDepartamentos(departamentos, proyeccionesDepartamentoDTO);
        mapearProyeccionInvitados(invitados, proyeccionesSocioDTO);

        eventoLimitadoDTO.setDepartamentos(proyeccionesDepartamentoDTO);
        eventoLimitadoDTO.setInvitados(proyeccionesSocioDTO);
        eventoLimitadoDTO.setInscriptos(evento.getInscriptos());
        return eventoLimitadoDTO;
    }
    private void mapearDatosPrimitivos(EventoLimitadoDTO eventoLimitadoDTO, Evento evento){
        eventoLimitadoDTO.setId(evento.getId());
        eventoLimitadoDTO.setUuid(evento.getUuid());
        eventoLimitadoDTO.setEstadosEvento(evento.getEstadosEvento());
        eventoLimitadoDTO.setDescripcion(evento.getDescripcion());
        eventoLimitadoDTO.setUbicacion(evento.getUbicacion());
        eventoLimitadoDTO.setNombre(evento.getNombre());
        eventoLimitadoDTO.setFechaFin(evento.getFechaFin());
        eventoLimitadoDTO.setFechaComienzo(evento.getFechaComienzo());
        eventoLimitadoDTO.setModalidad(evento.getModalidad());
        eventoLimitadoDTO.setHora(evento.getHora());
    }
    private void mapearProyeccionInvitados(List<Socio> invitados, List<ProyeccionSocioDTO> proyeccionesSocioDTO){
        invitados.forEach(invitado ->
        {
            ProyeccionSocioDTO proyeccionSocioDTO = new ProyeccionSocioDTO();
            proyeccionSocioDTO.setId(invitado.getId());
            proyeccionSocioDTO.setMail(invitado.getMail());
            proyeccionSocioDTO.setNombre(invitado.getNombre());
            proyeccionesSocioDTO.add(proyeccionSocioDTO);
        });

    }
    private void mapearProyeccionDepartamentos(List<Departamento> departamentos, List<ProyeccionDepartamentoDTO> proyeccionesDepartamentoDTO){

        departamentos.forEach(departamento -> {
            ProyeccionDepartamentoDTO proyeccionDepartamentoDTO = new ProyeccionDepartamentoDTO();
            proyeccionDepartamentoDTO.setNombre(departamento.getNombre());
            proyeccionDepartamentoDTO.setIcono(departamento.getIcono());
            proyeccionDepartamentoDTO.setJerarquia(departamento.getJerarquia());
            proyeccionDepartamentoDTO.setId(departamento.getId());
            proyeccionDepartamentoDTO.setDescripcion(departamento.getDescripcion());
            proyeccionesDepartamentoDTO.add(proyeccionDepartamentoDTO);
        });

    }


    @Override
    public void invitar(Evento evento, Socio socio) throws Exception {
        try{//HARDCODEADO
            evento.invitar(socio);
            eventoRepository.save(evento);
        } catch (Exception e) {
            throw new Exception("Error al listar los eventos, por favor intentelo más tarde");
        }
    }

    @Override
    public void confirmar(Evento evento, Socio socio) throws Exception {
        try{//HARDCODEADO
            evento.confirmar(socio);
            eventoRepository.save(evento);
        } catch (Exception e) {
            throw new Exception("Error al listar los eventos, por favor intentelo más tarde");
        }
    }

    @Override
    public void cancelar(Evento evento) throws Exception {
        try{//HARDCODEADO
            evento.cancelar();
            eventoRepository.save(evento);
        } catch (Exception e) {
            throw new Exception("Error al listar los eventos, por favor intentelo más tarde");
        }
    }

    @Override
    public void finalizar(Evento evento) throws Exception {
        try{//HARDCODEADO
            evento.finalizar();
            eventoRepository.save(evento);
        } catch (Exception e) {
            throw new Exception("Error al listar los eventos, por favor intentelo más tarde");
        }
    }

}