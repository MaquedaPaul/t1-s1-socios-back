package ar.utn.aceleradora.gestion.socios.servicios.eventos;

import ar.utn.aceleradora.gestion.socios.dto.eventos.InscriptoCreateDTO;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.Inscripto;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.repositorios.InscriptoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InscriptoServiceImpl implements InscriptoService{
    @Autowired
    private SocioRepository socioRepository;
    @Autowired
    private InscriptoRepository inscriptoRepository;
    @Override
    public Boolean createInscripto(InscriptoCreateDTO inscriptoDTO) throws Exception {
        try {

            Optional<Socio> socioInvitante = socioRepository.findById(inscriptoDTO.getIdSocioInvitante());
            Inscripto nuevoInscripto = new Inscripto(inscriptoDTO.getNombre(), inscriptoDTO.getApellido(), inscriptoDTO.getTrabajo(), inscriptoDTO.getMail(), socioInvitante.get());

            return true;
        } catch (Exception e) {
            throw new Exception("Error al inscribirse, por favor inténtelo más tarde");
        }
    }
}
