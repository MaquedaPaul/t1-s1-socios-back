package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.repositorios.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UbicacionService {

    private final UbicacionRepository ubicacionRepository;

    @Autowired
    public UbicacionService(UbicacionRepository ubicacionRepository) {

        this.ubicacionRepository = ubicacionRepository;
    }

    public Ubicacion agregarUbicacion(Ubicacion ubicacion) {
        ubicacion.setId(null); // Establece el ID como nulo para crear un nuevo registro
        return ubicacionRepository.save(ubicacion);
    }

    public void eliminarUbicacion(Integer id) {
        ubicacionRepository.deleteById(id);
    }

    public Ubicacion obtenerUbicacion(Integer id) {
        return ubicacionRepository.findById(id).orElse(null);
    }

    public Ubicacion actualizarUbicacion(Ubicacion ubicacion) {
        if (ubicacion.getId() != null) {
            return ubicacionRepository.save(ubicacion);
        }
        return null; // El departamento no tiene un ID válido
    }
}
