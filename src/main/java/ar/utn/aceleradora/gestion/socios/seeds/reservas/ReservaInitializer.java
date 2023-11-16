package ar.utn.aceleradora.gestion.socios.seeds.reservas;

import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.EspacioFisicoRepository;
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
    private final DepartamentoRepository departamentoRepository;
    private final RecursoSolicitadoRepository recursoSolicitadoRepository;


    @Autowired
    public ReservaInitializer(ReservaRepository reservaRepository, EspacioFisicoRepository espacioFisicoRepository, DepartamentoRepository departamentoRepository, RecursoSolicitadoRepository recursoSolicitadoRepository){
        this.reservaRepository = reservaRepository;
        this.espacioFisicoRepository = espacioFisicoRepository;
        this.departamentoRepository = departamentoRepository;
        this.recursoSolicitadoRepository = recursoSolicitadoRepository;
    }


    public void run() throws NoSuchFieldException, IllegalAccessException {
        ReservaDataEspacioFisico dataEspacioFisico = new ReservaDataEspacioFisico();
        ReservaDataReservas dataReservas = new ReservaDataReservas();

        dataEspacioFisico.cargarEspacios();
        dataReservas.cargarReservas();
    }

}
