package ar.utn.aceleradora.gestion.socios.seeds.eventos;

import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.eventos.EventoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.eventos.InscriptoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EventoInitializer {
    private final EventoRepository eventoRepository;
    private final InscriptoRepository inscriptoRepository;
    private final DepartamentoRepository departamentoRepository;
    private final UbicacionRepository ubicacionRepository;


    @Autowired
    public EventoInitializer(EventoRepository eventoRepository, InscriptoRepository inscriptoRepository, DepartamentoRepository departamentoRepository, UbicacionRepository ubicacionRepository) {
        this.eventoRepository = eventoRepository;
        this.inscriptoRepository = inscriptoRepository;
        this.departamentoRepository = departamentoRepository;
        this.ubicacionRepository = ubicacionRepository;
    }


    public void run() throws NoSuchFieldException, IllegalAccessException {
        EventoDataEventos dataEventos = new EventoDataEventos();
        EventoDataEstadosEventos dataEstadoEventos = new EventoDataEstadosEventos();
        EventoDataInscriptos dataInscriptos = new EventoDataInscriptos();
        EventoDataEstadosInscriptos dataEstadosInscriptos = new EventoDataEstadosInscriptos();

        dataEstadosInscriptos.cargarEstados();
        dataInscriptos.cargarInscriptos(inscriptoRepository,departamentoRepository, dataEstadosInscriptos);
        dataEventos.cargarEventos(dataInscriptos, departamentoRepository, dataEstadoEventos, eventoRepository, ubicacionRepository);
    }
}
