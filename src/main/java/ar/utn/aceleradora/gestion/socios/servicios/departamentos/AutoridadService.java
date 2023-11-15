package ar.utn.aceleradora.gestion.socios.servicios.departamentos;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Autoridad;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AutoridadService {
    List<Autoridad> obtenerAutoridades();
}
