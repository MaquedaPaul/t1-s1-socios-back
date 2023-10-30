package ar.utn.aceleradora.gestion.socios.servicios.departamentos;


import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Autoridad;
import ar.utn.aceleradora.gestion.socios.dto.departamentos.CreacionEdicionDepartamentoDTO;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DepartamentoService {

    void removerAutoridades(Integer idDepartamento, Integer idAutoridad);

    List<Departamento> obtenerDepartamentos();

    public Page<Departamento> obtenerDepartamentoPaginado(int page);
    void eliminarDepartamento(Integer id) throws Exception;

    Departamento obtenerDepartamento(Integer id);

    Departamento crearDepartamento(CreacionEdicionDepartamentoDTO departamento) throws Exception;

    public Departamento editarDepartamento(CreacionEdicionDepartamentoDTO departamento, Integer id) throws Exception;

    List<String> obtenerNombres();
    void agregarAutoridades(List<Integer> autoridades, Integer id) throws Exception;

    void removerSocios(Integer id, Integer idSocio);

    void agregarSocios(List<Integer> sociosIds, Integer id);

    List<Autoridad> obtenerAutoridadesDe(Integer id);

    List<Autoridad> obtenerAutoridades();
}
