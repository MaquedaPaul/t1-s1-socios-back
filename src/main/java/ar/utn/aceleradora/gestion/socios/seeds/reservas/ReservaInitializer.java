package ar.utn.aceleradora.gestion.socios.seeds.reservas;

import ar.utn.aceleradora.gestion.socios.repositorios.UbicacionRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservaInitializer {
    private final ReservaRepository reservaRepository;
    private final EspacioFisicoRepository espacioFisicoRepository;
    private final EstadoReservaRepository estadoReservaRepository;
    private final DepartamentoRepository departamentoRepository;
    private final UbicacionRepository ubicacionRepository;
    private final RecursoRepository recursoRepository;
    private RecursoSolicitadoRepository recursoSolicitadoRepository;


    @Autowired
    public ReservaInitializer(ReservaRepository reservaRepository, EspacioFisicoRepository espacioFisicoRepository,
                              EstadoReservaRepository estadoReservaRepository, DepartamentoRepository departamentoRepository,
                              UbicacionRepository ubicacionRepository, RecursoRepository recursoRepository, RecursoSolicitadoRepository recursoSolicitadoRepository){
        this.reservaRepository = reservaRepository;
        this.espacioFisicoRepository = espacioFisicoRepository;
        this.estadoReservaRepository = estadoReservaRepository;
        this.departamentoRepository = departamentoRepository;
        this.ubicacionRepository = ubicacionRepository;
        this.recursoRepository = recursoRepository;
        this.recursoSolicitadoRepository = recursoSolicitadoRepository;
    }

    public void run() throws NoSuchFieldException, IllegalAccessException {
        ReservaDataEspacioFisico dataEspacioFisico = new ReservaDataEspacioFisico();
        ReservaDataReservas dataReservas = new ReservaDataReservas();
        ReservaDataEstadoReservas dataEstadoReservas = new ReservaDataEstadoReservas();
        ReservaDataRecursos reservaDataRecursos = new ReservaDataRecursos();
        ReservaDataRecursosSolicitados reservaDataRecursosSolicitados = new ReservaDataRecursosSolicitados();
        reservaDataRecursos.cargarRecursos(recursoRepository);
        reservaDataRecursosSolicitados.cargarRecursosSolicitados(recursoRepository, recursoSolicitadoRepository);
        dataEspacioFisico.cargarEspacios(ubicacionRepository, espacioFisicoRepository, recursoRepository);
        dataEstadoReservas.cargarEstadosReservas(estadoReservaRepository);
        dataReservas.cargarReservas(reservaRepository, departamentoRepository,espacioFisicoRepository,reservaDataRecursosSolicitados);
    }
}