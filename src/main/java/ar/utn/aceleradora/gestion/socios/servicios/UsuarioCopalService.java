package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.modelos.usuarioCopal.UsuarioCopal;
import ar.utn.aceleradora.gestion.socios.repositorios.UsuarioCopalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class UsuarioCopalService {

//    private final UsuarioCopalRepository usuarioCopalRepository;
//
//    @Autowired
//    public UsuarioCopalService(UsuarioCopalRepository usuarioCopalRepository) {
//
//        this.usuarioCopalRepository = usuarioCopalRepository;
//    }
//
//    public UsuarioCopal agregarUsuario(UsuarioCopal x) {
//        x.setId(null); // Establece el ID como nulo para crear un nuevo registro
//        return usuarioCopalRepository.save(x);
//    }
//
//    public void eliminarUsuario(Integer id) {
//        usuarioCopalRepository.deleteById(id);
//    }
//
//    public UsuarioCopal obtenerUsuario(Integer id) {
//        return usuarioCopalRepository.findById(id).orElse(null);
//    }
//
//    public UsuarioCopal actualizarUsuario(UsuarioCopal x) {
//        if (x.getId() != null) {
//            return usuarioCopalRepository.save(x);
//        }
//        return null; // El departamento no tiene un ID válido
//    }
}
