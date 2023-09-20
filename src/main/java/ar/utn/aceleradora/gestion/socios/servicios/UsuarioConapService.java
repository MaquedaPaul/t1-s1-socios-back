package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.modelos.registros.Registro;
import ar.utn.aceleradora.gestion.socios.modelos.usuarioConap.UsuarioConap;
import ar.utn.aceleradora.gestion.socios.repositorios.RegistroRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.UsuarioConapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioConapService {

    private final UsuarioConapRepository usuarioConapRepository;

    @Autowired
    public UsuarioConapService(UsuarioConapRepository usuarioConapRepository) {

        this.usuarioConapRepository = usuarioConapRepository;
    }

    public UsuarioConap agregarUsuario(UsuarioConap x) {
        x.setId(null); // Establece el ID como nulo para crear un nuevo registro
        return usuarioConapRepository.save(x);
    }

    public void eliminarUsuario(Integer id) {
        usuarioConapRepository.deleteById(id);
    }

    public UsuarioConap obtenerUsuario(Integer id) {
        return usuarioConapRepository.findById(id).orElse(null);
    }

    public UsuarioConap actualizarUsuario(UsuarioConap x) {
        if (x.getId() != null) {
            return usuarioConapRepository.save(x);
        }
        return null; // El departamento no tiene un ID válido
    }
}
