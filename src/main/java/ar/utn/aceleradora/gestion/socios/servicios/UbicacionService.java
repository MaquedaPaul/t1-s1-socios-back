package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.repositorios.UbicacionRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        Optional<Ubicacion> ubicacion = ubicacionRepository.findById(id);
        if(ubicacion.isPresent()){
        ubicacionRepository.deleteById(id);
        }
        else{throw new EntityNotFoundException("no existe ubicacion con id "+id);
        }
    }

    public Ubicacion obtenerUbicacion(Integer id) {
        Optional<Ubicacion> ubicacion = ubicacionRepository.findById(id);
        if(ubicacion.isPresent()){
            return ubicacionRepository.findById(id).orElse(null);
        }
        else{throw new EntityNotFoundException("no esxite ubicacion con id "+id);
        }

    }

    public Ubicacion actualizarUbicacion(Ubicacion ubicacion) {
        if (ubicacion.getId() != null) {
            return ubicacionRepository.save(ubicacion);
        }
        else{throw new EntityNotFoundException("no esxite ubicacion: "+ubicacion);}
    }
}
