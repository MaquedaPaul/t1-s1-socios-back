package ar.utn.aceleradora.gestion.socios.servicios.eventos;

import ar.utn.aceleradora.gestion.socios.dto.eventos.InscriptoCreateDTO;
import ar.utn.aceleradora.gestion.socios.error.SocioNotFoundException;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.Inscripto;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.repositorios.InscriptoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InscriptoServiceImpl implements InscriptoService{
    private final SocioRepository socioRepository;
    private final InscriptoRepository inscriptoRepository;

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

        } catch (Exception e) {
            throw new Exception("Error al inscribirse, por favor inténtelo más tarde");
        }
    }
}
