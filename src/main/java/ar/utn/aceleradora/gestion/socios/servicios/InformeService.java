package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.modelos.informe.Informe;
import ar.utn.aceleradora.gestion.socios.repositorios.InformeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
public class InformeService {
//    private final InformeRepository informeRepository;
//
//    @Autowired
//    public InformeService(InformeRepository informeRepository) {
//
//        this.informeRepository = informeRepository;
//    }
//
//    public Informe agregarInforme(Informe inf) {
//        inf.setId(null); // Establece el ID como nulo para crear un nuevo registro
//        return informeRepository.save(inf);
//    }
//
//    public void eliminarInforme(Integer id) {
//        informeRepository.deleteById(id);
//    }
//
//    public Informe obtenerInforme(Integer id) {
//        return informeRepository.findById(id).orElse(null);
//    }
//
//    public Informe actualizarInforme(Informe inf) {
//        if (inf.getId() != null) {
//            return informeRepository.save(inf);
//        }
//        return null; // El departamento no tiene un ID válido
//    }
}
