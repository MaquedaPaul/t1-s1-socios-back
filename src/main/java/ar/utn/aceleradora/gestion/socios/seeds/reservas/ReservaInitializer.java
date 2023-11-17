package ar.utn.aceleradora.gestion.socios.seeds.reservas;

import ar.utn.aceleradora.gestion.socios.repositorios.UbicacionRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.EspacioFisicoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.EstadoReservaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.RecursoSolicitadoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ReservaInitializer {
    private final ReservaRepository reservaRepository;
    private final EspacioFisicoRepository espacioFisicoRepository;
    private final RecursoSolicitadoRepository recursoSolicitadoRepository;
    private final EstadoReservaRepository estadoReservaRepository;
    private final DepartamentoRepository departamentoRepository;
    private final UbicacionRepository ubicacionRepository;


    @Autowired
    public ReservaInitializer(ReservaRepository reservaRepository, EspacioFisicoRepository espacioFisicoRepository, RecursoSolicitadoRepository recursoSolicitadoRepository, EstadoReservaRepository estadoReservaRepository, DepartamentoRepository departamentoRepository, UbicacionRepository ubicacionRepository){
        this.reservaRepository = reservaRepository;
        this.espacioFisicoRepository = espacioFisicoRepository;
        this.recursoSolicitadoRepository = recursoSolicitadoRepository;
        this.estadoReservaRepository = estadoReservaRepository;
        this.departamentoRepository = departamentoRepository;
        this.ubicacionRepository = ubicacionRepository;
    }

    public void run() throws NoSuchFieldException, IllegalAccessException {
        ReservaDataEspacioFisico dataEspacioFisico = new ReservaDataEspacioFisico();
        ReservaDataReservas dataReservas = new ReservaDataReservas();
        ReservaDataEstadoReservas dataEstadoReservas = new ReservaDataEstadoReservas();
        ReservaDataDepartamentos reservaDataDepartamentos = new ReservaDataDepartamentos();

        dataEspacioFisico.cargarEspacios(ubicacionRepository, espacioFisicoRepository);
        reservaDataDepartamentos.cargarDepartamentos(departamentoRepository);
        dataEstadoReservas.cargarEstadosReservas(estadoReservaRepository);
        dataReservas.cargarReservas(reservaRepository);
    }
}