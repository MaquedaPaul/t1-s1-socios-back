package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.dto.SocioCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioUpdateDTO;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SocioService {
    public Page<Socio> findAllSociosPaginado(int page) throws Exception;
    List<Socio> findAllSocios() throws Exception;

    Boolean deleteSocioById(Integer id) throws Exception;

    Boolean updateSocio(SocioUpdateDTO partner, Integer id) throws Exception;

    Boolean createSocio(SocioCreateDTO partner) throws Exception;

}