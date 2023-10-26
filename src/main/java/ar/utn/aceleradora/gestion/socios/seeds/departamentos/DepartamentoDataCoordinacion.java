package ar.utn.aceleradora.gestion.socios.seeds.departamentos;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Autoridad;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Coordinacion;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.repositorios.AutoridadRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.CoorDepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.DepartamentoRepository;

import java.util.List;


public class DepartamentoDataCoordinacion {
    Autoridad autoridadCoordinacionDepartamental = new Autoridad("Darinka", "Anzulovich", "autoridad/darinkaanzulovich.jpg", "Coordinación Departamentos Técnicos");
    Coordinacion coordinacion1 = new Coordinacion("Coordinación Departamentos Técnicos", "Supervisa cada uno de los departamentos técnicos en pos de que se cumplan sus respectivos objetivos", "icono_coordinacion_departamentos.png", 1, autoridadCoordinacionDepartamental);


    public void cargarCoordinaciones(CoorDepartamentoRepository coorDepartamentoRepository, AutoridadRepository autoridadRepository, DepartamentoRepository departamentoRepository, DepartamentoDataDepartamentos dataDepartamentos) {
        List<Departamento> departamentos = dataDepartamentos.getDepartamentos();
        departamentos.forEach(depa -> coordinacion1.agregarDepartamento(depa));
        autoridadRepository.save(autoridadCoordinacionDepartamental);
        coorDepartamentoRepository.save(coordinacion1);

    }
}

