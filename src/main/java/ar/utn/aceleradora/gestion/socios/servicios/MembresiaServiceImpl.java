package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.modelos.membresia.Membresia;
import ar.utn.aceleradora.gestion.socios.repositorios.MembresiaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembresiaServiceImpl implements MembresiaService{

    @Autowired
    private MembresiaRepository membresiaRepository;
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


