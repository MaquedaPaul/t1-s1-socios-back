package ar.utn.aceleradora.gestion.socios.servicios.departamentos;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Autoridad;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.AutoridadRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AutoridadServiceImpl implements AutoridadService{
    private final AutoridadRepository autoridadRepository;

    public AutoridadServiceImpl(AutoridadRepository autoridadRepository) {
        this.autoridadRepository = autoridadRepository;
    }

    @Override
    public List<Autoridad> obtenerAutoridades() {
        return autoridadRepository.findAll();
    }
}
