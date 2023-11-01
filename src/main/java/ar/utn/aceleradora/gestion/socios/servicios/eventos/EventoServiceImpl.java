package ar.utn.aceleradora.gestion.socios.servicios.eventos;

import ar.utn.aceleradora.gestion.socios.converters.DateConverter;
import ar.utn.aceleradora.gestion.socios.dto.EventoCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.EventoUpdateDTO;
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

            List<Departamento> departamentos = this.departamentoRepository.findAllById(eventoUpdate.getId_departamentos());
            existingEvento.setDepartamentos(departamentos);

            List<Socio> invitados = departamentos.stream()
                    .flatMap(departamento -> departamento.getSociosSuscritos().stream())
                    .collect(Collectors.toList());
            existingEvento.setInvitados(invitados);

            EstadoEvento estado = new EstadoEvento(obtenerTipoEstadoEvento(eventoUpdate.getTipoEstadoEvento()), LocalDate.now(), eventoUpdate.getMotivo());
            existingEvento.agregarEstado(estado);

            eventoRepository.save(existingEvento);
            return true;
        } catch (Exception e) {
            throw new Exception("Error al editar el evento, por favor intentelo más tarde");
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

    public TipoModalidad obtenerTipoModalidad(Integer modalidadInteger) {
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
    public Evento listarEvento(Integer id) throws Exception{
        Evento evento = eventoRepository.findById(id).orElseThrow(() -> new EventoNotFoundException("No se pudo encontrar el evento con id: "+id));
        return evento;
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