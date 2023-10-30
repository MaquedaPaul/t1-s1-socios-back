package ar.utn.aceleradora.gestion.socios.servicios.socios;

import ar.utn.aceleradora.gestion.socios.modelos.socios.membresia.Membresia;
import ar.utn.aceleradora.gestion.socios.repositorios.MembresiaRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembresiaServiceImpl implements MembresiaService{

    private final MembresiaRepository membresiaRepository;

    public MembresiaServiceImpl(MembresiaRepository membresiaRepository) {
        this.membresiaRepository = membresiaRepository;
    }

    @Override
    public List<Membresia> findAllMembresias() {
        return membresiaRepository.findAll();
    }

    @Override
    public List<Membresia> guardarMembresia(Membresia membresia) {
        membresiaRepository.save(membresia);
        return membresiaRepository.findAll();
    }
}


