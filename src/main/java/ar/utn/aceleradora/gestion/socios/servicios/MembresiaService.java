package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.modelos.membresia.Membresia;
import ar.utn.aceleradora.gestion.socios.repositorios.MembresiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MembresiaService {

    private final MembresiaRepository membresiaRepository;

    @Autowired
    public MembresiaService(MembresiaRepository membresiaRepository) {

        this.membresiaRepository = membresiaRepository;
    }

    public Membresia agregarMembresia(Membresia membresia) {
        membresia.setId(null); // Establece el ID como nulo para crear un nuevo registro
        return membresiaRepository.save(membresia);
    }

    public void eliminarMembresia(Integer id) {
        membresiaRepository.deleteById(id);
    }

    public Membresia obtenerMembresia(Integer id) {
        return membresiaRepository.findById(id).orElse(null);
    }

    public Membresia actualizarMembresia(Membresia m) {
        if (m.getId() != null) {
            return membresiaRepository.save(m);
        }
        return null; // El departamento no tiene un ID válido
    }
}
