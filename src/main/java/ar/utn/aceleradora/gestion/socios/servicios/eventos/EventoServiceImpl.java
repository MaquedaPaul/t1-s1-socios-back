package ar.utn.aceleradora.gestion.socios.servicios.eventos;

import ar.utn.aceleradora.gestion.socios.converters.DateConverter;
import ar.utn.aceleradora.gestion.socios.dto.eventos.*;
import ar.utn.aceleradora.gestion.socios.dto.eventos.EventoCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.eventos.EventoUpdateDTO;
import ar.utn.aceleradora.gestion.socios.dto.eventos.ListaEventoDTO;
import ar.utn.aceleradora.gestion.socios.error.EventoNotFoundException;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.EstadoEvento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.Evento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoEstadoEvento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoModalidad;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.repositorios.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.EventoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EventoServiceImpl implements EventoService {

    private EventoRepository eventoRepository;
    private DepartamentoRepository departamentoRepository;
    private SocioRepository socioRepository;
    private UbicacionRepository ubicacionRepository;

    @Autowired
    public EventoServiceImpl(EventoRepository eventoRepository, DepartamentoRepository departamentoRepository, SocioRepository socioRepository, UbicacionRepository ubicacionRepository) {
        this.eventoRepository = eventoRepository;
        this.departamentoRepository = departamentoRepository;
        this.socioRepository = socioRepository;
        this.ubicacionRepository = ubicacionRepository;
    }

    @Override
    public void crearEvento(EventoCreateDTO evento) throws Exception {
        try{
            LocalDate fechaComienzo = DateConverter.parse(evento.getFechaComienzo());
            LocalDate fechaFin = DateConverter.parse(evento.getFechaFin());
            Ubicacion ubicacion = new Ubicacion(evento.getDireccion(), evento.getPiso(), evento.getDepartamento(), evento.getLocalidad(), evento.getProvincia());
            ubicacionRepository.save(ubicacion);
            List<Departamento> departamentos = this.departamentoRepository.findAllById(evento.getId_departamentos());
            Evento nuevoEvento = new Evento(evento.getNombre(), evento.getDescripcion(), fechaComienzo, fechaFin, obtenerTipoModalidad(evento.getModalidad()), ubicacion, departamentos);


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

            if(esTipoEstadoEventoValido(eventoUpdate.getTipoEstadoEvento())) {
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

    private boolean esTipoEstadoEventoValido(Integer id) {
        if (id == null) {
            return false;
        } else {
            return id >= 0 && id <= 3;
        }
    }

    private TipoEstadoEvento obtenerTipoEstadoEvento(Integer id) {
        return switch (id) {
            case 0 -> TipoEstadoEvento.PENDIENTE;
            case 1 -> TipoEstadoEvento.CONFIRMADO;
            case 2 -> TipoEstadoEvento.FINALIZADO;
            case 3 -> TipoEstadoEvento.CANCELADO;
            default -> throw new IllegalArgumentException("Tipo de estado de evento no válido");
        };
    }

    private TipoModalidad obtenerTipoModalidad(Integer modalidadInteger) {
        return switch (modalidadInteger) {
            case 0 -> TipoModalidad.HIBRIDO;
            case 1 -> TipoModalidad.VIRTUAL;
            case 2 -> TipoModalidad.PRESENCIAL;
            default -> throw new IllegalArgumentException("Valor de modalidad no válido: " + modalidadInteger);
        };
    }

    @Override
    public List<ListaEventoDTO> listarEventos() throws Exception {
        List<Evento> eventos = eventoRepository.findAll();
        List<ListaEventoDTO> eventoDTOs = new ArrayList<>();
        try {
            for (Evento evento : eventos) {
                ListaEventoDTO eventoDTO = new ListaEventoDTO();
                eventoDTO.setId(evento.getId());
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
    public EventoLimitadoDTO listarEvento(Integer id) throws Exception{

        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new EventoNotFoundException("No se pudo encontrar el evento con id: "+id));
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
        eventoLimitadoDTO.setEstadosEvento(evento.getEstadosEvento());
        eventoLimitadoDTO.setDescripcion(evento.getDescripcion());
        eventoLimitadoDTO.setUbicacion(evento.getUbicacion());
        eventoLimitadoDTO.setNombre(evento.getNombre());
        eventoLimitadoDTO.setFechaFin(evento.getFechaFin());
        eventoLimitadoDTO.setFechaComienzo(evento.getFechaComienzo());
        eventoLimitadoDTO.setModalidad(evento.getModalidad());
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