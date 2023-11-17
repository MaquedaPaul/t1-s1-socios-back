package ar.utn.aceleradora.gestion.socios.seeds.reservas;

import ar.utn.aceleradora.gestion.socios.modelos.reservas.EstadoReserva;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.EspacioFisicoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.EstadoReservaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.RecursoSolicitadoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.ReservaRepository;
import ar.utn.aceleradora.gestion.socios.seeds.eventos.EventoDataEstadosEventos;
import ar.utn.aceleradora.gestion.socios.seeds.eventos.EventoDataEstadosInscriptos;
import ar.utn.aceleradora.gestion.socios.seeds.eventos.EventoDataEventos;
import ar.utn.aceleradora.gestion.socios.seeds.eventos.EventoDataInscriptos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservaInitializer {
    private final ReservaRepository reservaRepository;
    private final EspacioFisicoRepository espacioFisicoRepository;
    private final RecursoSolicitadoRepository recursoSolicitadoRepository;
    private final EstadoReservaRepository estadoReservaRepository;
    private final DepartamentoRepository departamentoRepository;


    @Autowired
    public ReservaInitializer(ReservaRepository reservaRepository, EspacioFisicoRepository espacioFisicoRepository, RecursoSolicitadoRepository recursoSolicitadoRepository, EstadoReservaRepository estadoReservaRepository, DepartamentoRepository departamentoRepository){
        this.reservaRepository = reservaRepository;
        this.espacioFisicoRepository = espacioFisicoRepository;
        this.recursoSolicitadoRepository = recursoSolicitadoRepository;
        this.estadoReservaRepository = estadoReservaRepository;
        this.departamentoRepository = departamentoRepository;
    }

    public void run() throws NoSuchFieldException, IllegalAccessException {
        ReservaDataEspacioFisico dataEspacioFisico = new ReservaDataEspacioFisico();
        ReservaDataReservas dataReservas = new ReservaDataReservas();
        ReservaDataEstadoReservas dataEstadoReservas = new ReservaDataEstadoReservas();
        ReservaDataDepartamentos reservaDataDepartamentos = new ReservaDataDepartamentos();

        //dataEspacioFisico.cargarEspacios(espacioFisicoRepository);
        reservaDataDepartamentos.cargarDepartamentos(departamentoRepository);
        dataEstadoReservas.cargarEstadosReservas(estadoReservaRepository);
        dataReservas.cargarReservas(reservaRepository);
    }

}
