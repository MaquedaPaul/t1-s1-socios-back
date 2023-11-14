package ar.utn.aceleradora.gestion.socios.servicios.departamentos;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Coordinacion;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CoordinacionService {
    List<Coordinacion> obtenerCoordinaciones();


    Coordinacion obtenerCoordinacionPorId(Integer id);
}
