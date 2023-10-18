package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.modelos.Departamento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartamentoService {
    void eliminarDepartamento(Integer id) throws Exception;

    Departamento obtenerDepartamento(Integer id);



    List<String> obtenerNombres();
    void agregarAutoridades(List<Integer> autoridades, Integer id) throws Exception;
}
