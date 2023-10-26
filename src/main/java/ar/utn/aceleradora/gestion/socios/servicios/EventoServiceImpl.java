package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.dto.EventoCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.EventoUpdateDTO;
import ar.utn.aceleradora.gestion.socios.repositorios.EventoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.utn.aceleradora.gestion.socios.modelos.evento.Evento;
import java.util.List;
import java.util.Optional;

@Service
public class EventoServiceImpl implements EventoService{
    private EventoRepository eventoRepository;

    @Autowired
    public EventoServiceImpl(EventoRepository eventoRepository) {
        this.eventoRepository = eventoRepository;
    }

    @Override
    public Boolean crearEvento(EventoCreateDTO evento) throws Exception {
        try{//Faltan verificaciones
            Evento nuevoEvento = new Evento(evento.getNombre(), evento.getDescripcion(), evento.getFechaComienzo(), evento.getFechaFin(), evento.getModalidad(), evento.getUbicacion(), evento.getEstado(), evento.getDepartamentos());
            if (evento.getNombre() == null || evento.getDescripcion() == null
                    || evento.getFechaComienzo() == null || evento.getFechaFin() == null
                    || evento.getModalidad() == null || evento.getUbicacion() == null
                    || evento.getEstado() == null)
                throw new Exception("Faltan datos obligatorios para crear el evento.");

            eventoRepository.save(nuevoEvento);
            return true;
        } catch (Exception e) {
            throw new Exception("Error al crear el evento, por favor intentelo más tarde");
        }
    }

    @Override
    public Boolean editarEvento(EventoUpdateDTO eventoUpdate, Integer id) throws Exception {
        try{
            Optional<Evento> optionalEvento = eventoRepository.findById(Long.valueOf(id));

            if (optionalEvento.isEmpty())
                return false;

            Evento existingEvento = optionalEvento.get();

            existingEvento.setNombre(eventoUpdate.getNombre());
            existingEvento.setFechaComienzo(eventoUpdate.getFechaComienzo());
            existingEvento.setFechaFin(eventoUpdate.getFechaFin());
            existingEvento.setModalidad(eventoUpdate.getModalidad());
            existingEvento.setUbicacion(eventoUpdate.getUbicacion());
            existingEvento.setInvitados(eventoUpdate.getInvitados());
            existingEvento.setInscriptos(eventoUpdate.getInscriptos());
            existingEvento.setEstado(eventoUpdate.getEstado());
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
}