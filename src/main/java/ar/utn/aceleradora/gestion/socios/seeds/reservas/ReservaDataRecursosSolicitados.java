package ar.utn.aceleradora.gestion.socios.seeds.reservas;

import ar.utn.aceleradora.gestion.socios.modelos.reservas.EspacioFisico;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.Recurso;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.RecursoSolicitado;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.RecursoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.RecursoSolicitadoRepository;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
public class ReservaDataRecursosSolicitados {
    RecursoSolicitado recursoSolicitado1 = new RecursoSolicitado(5);
    RecursoSolicitado recursoSolicitado2 = new RecursoSolicitado(25);
    RecursoSolicitado recursoSolicitado3 = new RecursoSolicitado(55);
    RecursoSolicitado recursoSolicitado4 = new RecursoSolicitado(56);
    RecursoSolicitado recursoSolicitado5 = new RecursoSolicitado(35);
    RecursoSolicitado recursoSolicitado6 = new RecursoSolicitado(6);
    RecursoSolicitado recursoSolicitado7 = new RecursoSolicitado(2);
    RecursoSolicitado recursoSolicitado8 = new RecursoSolicitado(1);
    RecursoSolicitado recursoSolicitado9 = new RecursoSolicitado(7);
    RecursoSolicitado recursoSolicitado10 = new RecursoSolicitado(2);
    RecursoSolicitado recursoSolicitado11 = new RecursoSolicitado(7);
    RecursoSolicitado recursoSolicitado12 = new RecursoSolicitado(9);
    RecursoSolicitado recursoSolicitado13 = new RecursoSolicitado(3);
    RecursoSolicitado recursoSolicitado14 = new RecursoSolicitado(2);
    RecursoSolicitado recursoSolicitado15 = new RecursoSolicitado(37);
    @Getter
    public List<RecursoSolicitado> recursoSolicitados = Arrays.asList(recursoSolicitado1,recursoSolicitado2,recursoSolicitado3,recursoSolicitado4,recursoSolicitado5,recursoSolicitado6,recursoSolicitado7
            ,recursoSolicitado8,recursoSolicitado9,recursoSolicitado10,recursoSolicitado11,recursoSolicitado12,recursoSolicitado13,recursoSolicitado14,recursoSolicitado15);
    public void cargarRecursosSolicitados(RecursoRepository recursoRepository, RecursoSolicitadoRepository recursoSolicitadoRepository){
        List<Recurso> recursos = recursoRepository.findAll();
        recursoSolicitado1.setRecurso(recursos.get(0));
        recursoSolicitado2.setRecurso(recursos.get(1));
        recursoSolicitado3.setRecurso(recursos.get(2));
        recursoSolicitado4.setRecurso(recursos.get(3));
        recursoSolicitado5.setRecurso(recursos.get(4));
        recursoSolicitado6.setRecurso(recursos.get(0));
        recursoSolicitado7.setRecurso(recursos.get(1));
        recursoSolicitado8.setRecurso(recursos.get(2));
        recursoSolicitado9.setRecurso(recursos.get(3));
        recursoSolicitado10.setRecurso(recursos.get(4));
        recursoSolicitado11.setRecurso(recursos.get(0));
        recursoSolicitado12.setRecurso(recursos.get(1));
        recursoSolicitado13.setRecurso(recursos.get(2));
        recursoSolicitado14.setRecurso(recursos.get(3));
        recursoSolicitado15.setRecurso(recursos.get(4));

/*
        recursoSolicitadoRepository.save(recursoSolicitado1);
        recursoSolicitadoRepository.save(recursoSolicitado2);
        recursoSolicitadoRepository.save(recursoSolicitado3);
        recursoSolicitadoRepository.save(recursoSolicitado4);
        recursoSolicitadoRepository.save(recursoSolicitado5);
        recursoSolicitadoRepository.save(recursoSolicitado6);
        recursoSolicitadoRepository.save(recursoSolicitado7);
        recursoSolicitadoRepository.save(recursoSolicitado8);
        recursoSolicitadoRepository.save(recursoSolicitado9);
        recursoSolicitadoRepository.save(recursoSolicitado10);
        recursoSolicitadoRepository.save(recursoSolicitado11);
        recursoSolicitadoRepository.save(recursoSolicitado12);
        recursoSolicitadoRepository.save(recursoSolicitado13);
        recursoSolicitadoRepository.save(recursoSolicitado14);
        recursoSolicitadoRepository.save(recursoSolicitado15);
*/
    }


}
