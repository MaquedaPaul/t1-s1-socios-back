package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.departamento.Etiqueta;
import ar.utn.aceleradora.gestion.socios.repositorios.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.EtiquetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtiquetaService {
    private final EtiquetaRepository etiquetaRepository;

    @Autowired
    public EtiquetaService(EtiquetaRepository etiquetaRepository) {

        this.etiquetaRepository = etiquetaRepository;
    }

    public Etiqueta agregarEtiqueta(Etiqueta etiqueta) {
        etiqueta.setId(null); // Establece el ID como nulo para crear un nuevo registro
        return etiquetaRepository.save(etiqueta);
    }

    public void eliminarEtiqueta(Integer id) {
        etiquetaRepository.deleteById(id);
    }

    public Etiqueta obtenerEtiqueta(Integer id) {
        return etiquetaRepository.findById(id).orElse(null);
    }

    public Etiqueta actualizarEtiqueta(Etiqueta etiqueta) {
        if (etiqueta.getId() != null) {
            return etiquetaRepository.save(etiqueta);
        }
        return null; // El departamento no tiene un ID válido
    }
}
