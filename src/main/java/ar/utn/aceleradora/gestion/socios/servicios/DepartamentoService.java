package ar.utn.aceleradora.gestion.socios.servicios;

import org.springframework.stereotype.Service;

@Service
public interface DepartamentoService {
    Boolean eliminarDepartamento(Integer id) throws Exception;

}
