package ar.utn.aceleradora.gestion.socios.servicios.eventos;

import ar.utn.aceleradora.gestion.socios.converters.DateConverter;
import ar.utn.aceleradora.gestion.socios.dto.EventoCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.EventoUpdateDTO;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.Evento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoModalidad;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.repositorios.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.EventoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService {

    private EventoRepository eventoRepository;
    private DepartamentoRepository departamentoRepository;
    private SocioRepository socioRepository;

    @Autowired
    public EventoServiceImpl(EventoRepository eventoRepository, DepartamentoRepository departamentoRepository, SocioRepository socioRepository) {
        this.eventoRepository = eventoRepository;
        this.departamentoRepository = departamentoRepository;
        this.socioRepository = socioRepository;
    }

    @Override
    public void crearEvento(EventoCreateDTO evento) throws Exception {
        try{
            LocalDate fechaComienzo = DateConverter.parse(evento.getFechaComienzo());
            LocalDate fechaFin = DateConverter.parse(evento.getFechaFin());
            Ubicacion ubicacion = new Ubicacion(evento.getDireccion(), evento.getPiso(), evento.getDepartamento(), evento.getLocalidad(), evento.getProvincia());
            List<Departamento> departamentos = this.departamentoRepository.findAllById(evento.getId_departamentos());
            List<Socio> socios = this.socioRepository.findAllById(evento.getId_socios_invitados());
            Evento nuevoEvento = new Evento(evento.getNombre(), evento.getDescripcion(), fechaComienzo, fechaFin, obtenerTipoModalidad(evento.getModalidad()), ubicacion, socios, departamentos);
            eventoRepository.save(nuevoEvento);
        } catch (Exception e) {
            throw new Exception("Error al crear el evento, por favor intentelo más tarde");
        }
    }

    @Override
    public TipoModalidad obtenerTipoModalidad(Integer modalidadInteger) {
        return switch (modalidadInteger) {
            case 0 -> TipoModalidad.HIBRIDO;
            case 1 -> TipoModalidad.VIRTUAL;
            case 2 -> TipoModalidad.PRESENCIAL;
            default -> throw new IllegalArgumentException("Valor de modalidad no válido: " + modalidadInteger);
        };
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

            LocalDate fechaComienzo = DateConverter.parse(eventoUpdate.getFechaComienzo());
            existingEvento.setFechaComienzo(fechaComienzo);
            LocalDate fechaFin = DateConverter.parse(eventoUpdate.getFechaFin());
            existingEvento.setFechaFin(fechaFin);

            existingEvento.setModalidad(eventoUpdate.getModalidad());
            existingEvento.setUbicacion(eventoUpdate.getUbicacion());
            existingEvento.setInvitados(eventoUpdate.getInvitados());
            existingEvento.setInscriptos(eventoUpdate.getInscriptos());
            //existingEvento.setEstado(eventoUpdate.getEstadoEvento());
            existingEvento.setDepartamentos(eventoUpdate.getDepartamentos());

            eventoRepository.save(existingEvento);
            return true;
        } catch (Exception e) {
            throw new Exception("Error al editar el evento, por favor intentelo más tarde");
        }
    }

    @Override
    public List<Evento> listarEventos() throws Exception {
        try{//HARDCODEADO
            return eventoRepository.findAll();
        } catch (Exception e) {
            throw new Exception("Error al listar los eventos, por favor intentelo más tarde");
        }
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