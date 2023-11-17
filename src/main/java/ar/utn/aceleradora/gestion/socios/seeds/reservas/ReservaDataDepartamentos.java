package ar.utn.aceleradora.gestion.socios.seeds.reservas;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.DepartamentoRepository;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ReservaDataDepartamentos {
    public void cargarDepartamentos(DepartamentoRepository departamentoRepository){
        departamentoRepository.findAll();
    }
}
