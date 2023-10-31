package ar.utn.aceleradora.gestion.socios.seeds.eventos;

import ar.utn.aceleradora.gestion.socios.repositorios.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.EventoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.InscriptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoInitializer {
    private final EventoRepository eventoRepository;
    private final InscriptoRepository inscriptoRepository;
    private final DepartamentoRepository departamentoRepository;


    @Autowired
    public EventoInitializer(EventoRepository eventoRepository, InscriptoRepository inscriptoRepository, DepartamentoRepository departamentoRepository) {
        this.eventoRepository = eventoRepository;
        this.inscriptoRepository = inscriptoRepository;
        this.departamentoRepository = departamentoRepository;
    }


    public void run() throws NoSuchFieldException, IllegalAccessException {
        EventoDataEventos dataEventos = new EventoDataEventos();
        EventoDataEstadosEventos dataEstadoEventos = new EventoDataEstadosEventos();
        EventoDataInscriptos dataInscriptos = new EventoDataInscriptos();
        EventoDataEstadosInscriptos dataEstadosInscriptos = new EventoDataEstadosInscriptos();

        dataEstadosInscriptos.cargarEstados();
        dataInscriptos.cargarInscriptos(inscriptoRepository,departamentoRepository, dataEstadosInscriptos);
        dataEventos.cargarEventos(dataInscriptos, departamentoRepository, dataEstadoEventos, eventoRepository);

    }
}
