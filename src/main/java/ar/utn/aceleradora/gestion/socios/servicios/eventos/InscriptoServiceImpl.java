package ar.utn.aceleradora.gestion.socios.servicios.eventos;

import ar.utn.aceleradora.gestion.socios.dto.eventos.InscriptoCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.eventos.InscriptoUpdateDTO;
import ar.utn.aceleradora.gestion.socios.error.SocioNotFoundException;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.Evento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoEstadoEvento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.EstadoInscripto;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.Inscripto;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.TipoEstadoInscripto;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.repositorios.InscriptoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class InscriptoServiceImpl implements InscriptoService{
    private final SocioRepository socioRepository;
    private final InscriptoRepository inscriptoRepository;

    @Autowired
    public InscriptoServiceImpl(SocioRepository socioRepository, InscriptoRepository inscriptoRepository) {
        this.socioRepository = socioRepository;
        this.inscriptoRepository = inscriptoRepository;
    }

    @Override
    public void createInscripto(InscriptoCreateDTO inscriptoDTO) throws Exception {
        try {
            Optional<Socio> socioInvitante = socioRepository.findById(inscriptoDTO.getIdSocioInvitante());

            Socio socio = socioInvitante.orElseThrow(() -> new SocioNotFoundException("No se encontró el socio invitante con ID: " + inscriptoDTO.getIdSocioInvitante()));

            Inscripto nuevoInscripto = new Inscripto(inscriptoDTO.getNombre(), inscriptoDTO.getApellido(), inscriptoDTO.getTrabajo(), inscriptoDTO.getMail(), socio);
            inscriptoRepository.save(nuevoInscripto);
        } catch (Exception e) {
            throw new Exception("Error al inscribirse, por favor inténtelo más tarde");
        }
    }

    @Override
    public Boolean updateInscripto(InscriptoUpdateDTO inscriptoDTO, Integer id) throws Exception {
        try {
            Optional<Inscripto> optionalInscripto = inscriptoRepository.findById(id);

            if (optionalInscripto.isEmpty())
                return false;

            Inscripto existingInscripto = optionalInscripto.get();

            existingInscripto.setNombre(inscriptoDTO.getNombre());
            existingInscripto.setApellido(inscriptoDTO.getApellido());
            existingInscripto.setTrabajo(inscriptoDTO.getTrabajo());
            existingInscripto.setMail(inscriptoDTO.getMail());

            if(esTipoEstadoInscriptoValido(inscriptoDTO.getTipoEstadoInscripto())){
                EstadoInscripto estado = new EstadoInscripto(obtenerTipoEstadoInscripto(inscriptoDTO.getTipoEstadoInscripto()), LocalDateTime.now(), inscriptoDTO.getMotivo());
                existingInscripto.agregarEstado(estado);
            }

            inscriptoRepository.save(existingInscripto);
            return true;
        } catch (Exception e) {
            throw new Exception("Error al editar el inscripto, por favor intentelo más tarde");
        }
    }

    private TipoEstadoInscripto obtenerTipoEstadoInscripto(Integer id) {
        return switch (id) {
            case 0 -> TipoEstadoInscripto.PENDIENTE;
            case 1 -> TipoEstadoInscripto.CONFIRMADO;
            case 2 -> TipoEstadoInscripto.CANCELADO;
            case 3 -> TipoEstadoInscripto.RECHAZADO;
            case 4 -> TipoEstadoInscripto.ASISTIO;
            default -> throw new IllegalArgumentException("Tipo de estado de inscripto no válido");
        };
    }

    private Boolean esTipoEstadoInscriptoValido(Integer id){
        if (id == null) {
            return false;
        } else {
            return id >= 0 && id <= 4;
        }
    }
}
