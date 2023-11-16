package ar.utn.aceleradora.gestion.socios.seeds.reservas;

import ar.utn.aceleradora.gestion.socios.modelos.reservas.Recurso;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.RecursoSolicitado;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.RecursoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.RecursoSolicitadoRepository;

import java.util.Arrays;
import java.util.List;

public class ReservasDataRecursos {

    final Recurso recurso1 = new Recurso("Proyector","descripcionProyector");
    final Recurso recurso2 = new Recurso("Computadora","SO Windows");
    final Recurso recurso3 = new Recurso("Micrófono","descripcionMicrofono");
    final Recurso recurso4 = new Recurso("Pizarra","descripcionPizarra");
    final Recurso recurso5 = new Recurso("Cámara","Nikon, para videoconferencias");
    final Recurso recurso6 = new Recurso("Zapatilla Eléctrica","descripcionZapatilla");
    final Recurso recurso7 = new Recurso("Teclado","descripcionTeclado");
    final Recurso recurso8 = new Recurso("Cable HDMI","descripcionCable");

    final List<Recurso> recursos = Arrays.asList(recurso1,recurso2,recurso3,recurso4,recurso5,recurso6,recurso7,recurso8);

    final RecursoSolicitado recursoSolicitado1 = new RecursoSolicitado(recurso1,1);
    final RecursoSolicitado recursoSolicitado2 = new RecursoSolicitado(recurso2,3);
    final RecursoSolicitado recursoSolicitado3 = new RecursoSolicitado(recurso3,1);
    final RecursoSolicitado recursoSolicitado4 = new RecursoSolicitado(recurso4,1);
    final RecursoSolicitado recursoSolicitado5 = new RecursoSolicitado(recurso5,1);
    final RecursoSolicitado recursoSolicitado6 = new RecursoSolicitado(recurso6,3);
    final RecursoSolicitado recursoSolicitado7 = new RecursoSolicitado(recurso7,3);
    final RecursoSolicitado recursoSolicitado8 = new RecursoSolicitado(recurso8,5);
    final RecursoSolicitado recursoSolicitado9 = new RecursoSolicitado(recurso2,4);
    final RecursoSolicitado recursoSolicitado10 = new RecursoSolicitado(recurso4,2);
    final RecursoSolicitado recursoSolicitado11 = new RecursoSolicitado(recurso3,4);

    final List<RecursoSolicitado> recursosSolicitados = Arrays.asList(recursoSolicitado1,recursoSolicitado2,recursoSolicitado3,recursoSolicitado4,recursoSolicitado5,recursoSolicitado6,recursoSolicitado7,recursoSolicitado8,recursoSolicitado9,recursoSolicitado10,recursoSolicitado11);
    void cargarRecursos(RecursoRepository recursoRepository, RecursoSolicitadoRepository recursoSolicitadoRepository){
        recursoRepository.saveAll(recursos);
        recursoSolicitadoRepository.saveAll(recursosSolicitados);

    }
}
