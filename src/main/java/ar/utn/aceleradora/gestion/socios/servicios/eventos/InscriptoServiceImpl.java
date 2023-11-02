package ar.utn.aceleradora.gestion.socios.servicios.eventos;

import ar.utn.aceleradora.gestion.socios.dto.eventos.InscriptoCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.eventos.InscriptoUpdateDTO;
import ar.utn.aceleradora.gestion.socios.error.EventoNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.SocioNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.TipoEstadoInscriptoNoValidoException;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.Evento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.EstadoInscripto;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.Inscripto;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.TipoEstadoInscripto;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.repositorios.EventoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.InscriptoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class InscriptoServiceImpl implements InscriptoService{
    private final SocioRepository socioRepository;
    private final InscriptoRepository inscriptoRepository;
    private final EventoRepository eventoRepository;

    @Autowired
    public InscriptoServiceImpl(SocioRepository socioRepository, InscriptoRepository inscriptoRepository, EventoRepository eventoRepository) {
        this.socioRepository = socioRepository;
        this.inscriptoRepository = inscriptoRepository;
        this.eventoRepository = eventoRepository;
    }

    @Override
    public void createInscripto(InscriptoCreateDTO inscriptoDTO, Integer idEvento) throws Exception {
        try {
            Optional<Socio> socioInvitante = socioRepository.findById(inscriptoDTO.getIdSocioInvitante());
            Socio socio = socioInvitante.orElseThrow(() -> new SocioNotFoundException("No se encontró el socio invitante con ID: " + inscriptoDTO.getIdSocioInvitante()));

            Inscripto nuevoInscripto = new Inscripto(inscriptoDTO.getNombre(), inscriptoDTO.getApellido(), inscriptoDTO.getTrabajo(), inscriptoDTO.getMail(), socio);

            Optional<Evento> optionalEvento = eventoRepository.findById(idEvento);
            Evento evento = optionalEvento.orElseThrow(() -> new EventoNotFoundException("No se encontró el evento con ID: " + idEvento));

            evento.addInscripto(nuevoInscripto);

            inscriptoRepository.save(nuevoInscripto);
            eventoRepository.save(evento);
        } catch (Exception e) {
            throw new Exception("Error al inscribirse, por favor inténtelo más tarde");
        }
    }

    @Override
    public Boolean updateInscripto(InscriptoUpdateDTO inscriptoDTO, Integer idInscripto) throws Exception {
        try {
            Optional<Inscripto> optionalInscripto = inscriptoRepository.findById(idInscripto);

            if (optionalInscripto.isEmpty())
                return false;

            Inscripto existingInscripto = optionalInscripto.get();

            existingInscripto.setNombre(inscriptoDTO.getNombre());
            existingInscripto.setApellido(inscriptoDTO.getApellido());
            existingInscripto.setTrabajo(inscriptoDTO.getTrabajo());
            existingInscripto.setMail(inscriptoDTO.getMail());

            if(inscriptoDTO.getTipoEstadoInscripto() != null){
                EstadoInscripto estado = new EstadoInscripto(obtenerTipoEstadoInscripto(inscriptoDTO.getTipoEstadoInscripto()), LocalDateTime.now(), inscriptoDTO.getMotivo());
                existingInscripto.agregarEstado(estado);
            }

            inscriptoRepository.save(existingInscripto);
            return true;
        } catch (Exception e) {
            throw new Exception("Error al editar el inscripto, por favor intentelo más tarde");
        }
    }

    private TipoEstadoInscripto obtenerTipoEstadoInscripto(String tipoEstadoInscriptoString) {
        try {
            return TipoEstadoInscripto.valueOf(tipoEstadoInscriptoString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw  new TipoEstadoInscriptoNoValidoException("El tipo de estado inscripto: "+tipoEstadoInscriptoString+" no es reconocido");
        }
    }

}
