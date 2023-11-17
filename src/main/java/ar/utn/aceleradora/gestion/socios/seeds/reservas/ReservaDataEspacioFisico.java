package ar.utn.aceleradora.gestion.socios.seeds.reservas;

import ar.utn.aceleradora.gestion.socios.modelos.reservas.EspacioFisico;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.Recurso;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.repositorios.UbicacionRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.EspacioFisicoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.RecursoRepository;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

public class ReservaDataEspacioFisico {
    EspacioFisico espacioFisico1 = new EspacioFisico("nombre 1", "descripcion 1");
    EspacioFisico espacioFisico2 = new EspacioFisico("nombre 2", "descripcion 2");
    EspacioFisico espacioFisico3 = new EspacioFisico("nombre 3", "descripcion 3");
    EspacioFisico espacioFisico4 = new EspacioFisico("nombre 4", "descripcion 4");
    EspacioFisico espacioFisico5 = new EspacioFisico("nombre 5", "descripcion 5");
    EspacioFisico espacioFisico6 = new EspacioFisico("nombre 6", "descripcion 6");
    EspacioFisico espacioFisico7 = new EspacioFisico("nombre 7", "descripcion 7");
    EspacioFisico espacioFisico8 = new EspacioFisico("nombre 8", "descripcion 8");


    @Setter @Getter
    public List<EspacioFisico> espacios = Arrays.asList(espacioFisico1,espacioFisico2,espacioFisico3,espacioFisico4,espacioFisico5,espacioFisico6,espacioFisico7,espacioFisico8);
    public void cargarEspacios(UbicacionRepository ubicacionRepository, EspacioFisicoRepository espacioFisicoRepository, RecursoRepository recursoRepository){
        List<Recurso> recursos = recursoRepository.findAll();
        List<Ubicacion> ubicaciones = ubicacionRepository.findAll();
        for(int i=0; i<8; i++){
            espacios.get(i).setUbicacion(ubicaciones.get(i));
            espacios.get(i).agregarRecurso(recursos.get(0));
        }
        espacioFisico1.agregarRecurso(recursos.get(4));
        espacioFisico1.agregarRecurso(recursos.get(3));
        espacioFisico2.agregarRecurso(recursos.get(1));
        espacioFisico3.agregarRecurso(recursos.get(2));
        espacioFisico3.agregarRecurso(recursos.get(3));
        espacioFisico3.agregarRecurso(recursos.get(4));
        espacioFisico4.agregarRecurso(recursos.get(2));
        espacioFisico4.agregarRecurso(recursos.get(3));
        espacioFisico5.agregarRecurso(recursos.get(4));



        espacioFisicoRepository.saveAll(espacios);
    }
}