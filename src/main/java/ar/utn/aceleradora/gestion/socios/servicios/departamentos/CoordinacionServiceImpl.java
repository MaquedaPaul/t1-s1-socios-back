package ar.utn.aceleradora.gestion.socios.servicios.departamentos;

import ar.utn.aceleradora.gestion.socios.error.departamentos.CoordinacionNotFoundException;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Coordinacion;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.CoorDepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordinacionServiceImpl implements CoordinacionService {

    private final CoorDepartamentoRepository coordinacionRepository;

    @Autowired
    public CoordinacionServiceImpl(CoorDepartamentoRepository coordinacionRepository) {
        this.coordinacionRepository = coordinacionRepository;
    }

    @Override
    public List<Coordinacion> obtenerCoordinaciones(){
        try {
            return coordinacionRepository.findAll();
        }
        catch(Exception e){
            throw new RuntimeException("No se encontraron coordinaciones.");
        }
    }

    @Override
    public Coordinacion obtenerCoordinacionPorId(Integer id) {
        return coordinacionRepository.findById(id).orElseThrow(() -> new CoordinacionNotFoundException("No se pudo encontrar la coordinación con id: "+id));
    }
}
