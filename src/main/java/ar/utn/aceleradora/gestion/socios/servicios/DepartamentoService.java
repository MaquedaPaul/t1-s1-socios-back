package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Departamento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartamentoService {
    void eliminarDepartamento(Integer id) throws Exception;

    Departamento obtenerDepartamento(Integer id);

    Departamento agregarDepartamento(Departamento dpto);

    List<String> obtenerNombres();
    void agregarAutoridades(List<Integer> autoridades, Integer id) throws Exception;
}
