package ar.utn.aceleradora.gestion.socios.seeds.reservas;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.DepartamentoRepository;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

public class ReservaDataDepartamentos {
    Departamento departamento1 = new Departamento("nombre1", "descripcion 1");
    Departamento departamento2 = new Departamento("nombre2", "descripcion 2");
    Departamento departamento3 = new Departamento("nombre3", "descripcion 3");
    Departamento departamento4 = new Departamento("nombre4", "descripcion 4");
    Departamento departamento5 = new Departamento("nombre5", "descripcion 5");
    Departamento departamento6 = new Departamento("nombre6", "descripcion 6");
    Departamento departamento7 = new Departamento("nombre7", "descripcion 7");
    Departamento departamento8 = new Departamento("nombre8", "descripcion 8");

    @Getter
    List<Departamento> departamentos = Arrays.asList(departamento1,departamento2,departamento3,departamento4,departamento5,departamento6,departamento7,departamento8);

    public void cargarDepartamentos(DepartamentoRepository departamentoRepository){
        departamentoRepository.saveAll(departamentos);
    }
}
