package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.dto.CreacionEdicionDepartamentoDTO;
import ar.utn.aceleradora.gestion.socios.modelos.Departamento;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartamentoService {

    public Page<Departamento> obtenerDepartamentoPaginado(int page);
    void eliminarDepartamento(Integer id) throws Exception;

    Departamento obtenerDepartamento(Integer id);

    Departamento crearDepartamento(CreacionEdicionDepartamentoDTO departamento) throws Exception;

    public Departamento editarDepartamento(CreacionEdicionDepartamentoDTO departamento, Integer id) throws Exception;

    List<String> obtenerNombres();
    void agregarAutoridades(List<Integer> autoridades, Integer id) throws Exception;
}
