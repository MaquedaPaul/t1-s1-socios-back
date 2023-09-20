package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.modelos.membresia.Membresia;
import ar.utn.aceleradora.gestion.socios.modelos.registros.Registro;
import ar.utn.aceleradora.gestion.socios.repositorios.RegistroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegistroService {

    private final RegistroRepository registroRepository;

    @Autowired
    public RegistroService(RegistroRepository registroRepository) {

        this.registroRepository = registroRepository;
    }

    public Registro agregar(Registro registro) {
        registro.setId(null); // Establece el ID como nulo para crear un nuevo registro
        return registroRepository.save(registro);
    }

    public void eliminar(Integer id) {
        registroRepository.deleteById(id);
    }

    public Registro obtener(Integer id) {
        return registroRepository.findById(id).orElse(null);
    }

    public Registro actualizar(Registro x) {
        if (x.getId() != null) {
            return registroRepository.save(x);
        }
        return null; // El departamento no tiene un ID válido
    }

}
