package ar.utn.aceleradora.gestion.socios.servicios.socios;

import ar.utn.aceleradora.gestion.socios.dto.socios.SocioCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.socios.SocioUpdateDTO;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SocioService {
    public Page<Socio> findAllSociosPaginado(int page) throws Exception;
    List<Socio> findAllSocios() throws Exception;

    Boolean deleteSocioById(Integer id);

    Boolean updateSocio(SocioUpdateDTO partner, Integer id) throws Exception;

    Boolean createSocio(SocioCreateDTO partner) throws Exception;
    Socio findSocioById(Integer id);

}