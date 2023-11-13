package ar.utn.aceleradora.gestion.socios.servicios.reservas;

import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaUpdateDTO;
import ar.utn.aceleradora.gestion.socios.error.reservas.EstadoReservaNoValidoException;
import ar.utn.aceleradora.gestion.socios.error.reservas.ReservaNotFoundException;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.*;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.EspacioFisicoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.RecursoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.RecursoSolicitadoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaServiceImpl implements ReservaService{
    private final ReservaRepository reservaRepository;
    private final RecursoRepository recursoRepository;
    private final RecursoSolicitadoRepository recursoSolicitadoRepository;
    private final EspacioFisicoRepository espacioFisicoRepository;
    @Autowired
    public ReservaServiceImpl(ReservaRepository reservaRepository, RecursoRepository recursoRepository, RecursoSolicitadoRepository recursoSolicitadoRepository, EspacioFisicoRepository espacioFisicoRepository){
        this.reservaRepository = reservaRepository;
        this.recursoRepository = recursoRepository;
        this.recursoSolicitadoRepository = recursoSolicitadoRepository;
        this.espacioFisicoRepository = espacioFisicoRepository;
    }

    @Override
    public void editarReserva(ReservaUpdateDTO reservaUpdateDTO, Integer id) throws EstadoReservaNoValidoException {
        Reserva reservaEncontrada = reservaRepository.findById(id).orElseThrow(() -> new ReservaNotFoundException("No se pudo encontrar la reserva con id: "+id));
        this.gestionarEdicionEstado(reservaUpdateDTO, reservaEncontrada);
        this.gestionarAprobacionRecursos(reservaUpdateDTO, reservaEncontrada);
        reservaRepository.save(reservaEncontrada);
    }

    private void gestionarAprobacionRecursos(ReservaUpdateDTO reservaUpdateDTO, Reserva reservaEncontrada) {
        List<RecursoSolicitado> recursosSolicitados = reservaEncontrada.getRecursosSolicitados();
        List<Integer> idsNuevosAprobados = reservaUpdateDTO.getIdsRecursosAprobados();
        List<RecursoSolicitado> aprobados = recursosSolicitados.stream().filter(recursoSolicitado -> idsNuevosAprobados.contains(recursoSolicitado.getId())).toList();
        List<RecursoSolicitado> desaprobados = recursosSolicitados.stream().filter(recursoSolicitado -> !idsNuevosAprobados.contains(recursoSolicitado.getId())).toList();
        aprobados.forEach(aprobado -> aprobado.setAprobado(true));
        desaprobados.forEach(aprobado-> aprobado.setAprobado(false));
    }

    private void gestionarEdicionEstado(ReservaUpdateDTO reservaUpdateDTO, Reserva reservaEncontrada) throws EstadoReservaNoValidoException {
        String estadoReservaString = reservaUpdateDTO.getTipoEstadoReserva();
        TipoEstadoReserva tipoEstadoReserva = null;
        if(estadoReservaString != null){
            tipoEstadoReserva = obtenerTipoEstadoReserva(estadoReservaString);
            EstadoReserva nuevoEstado = new EstadoReserva(tipoEstadoReserva,reservaUpdateDTO.getMotivo());
            reservaEncontrada.agregarNuevoEstado(nuevoEstado);

        }


    }
    private TipoEstadoReserva obtenerTipoEstadoReserva(String estadoReservaString) throws EstadoReservaNoValidoException {
        try {
            return TipoEstadoReserva.valueOf(estadoReservaString.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw  new EstadoReservaNoValidoException("El estado de la reserva: "+estadoReservaString+" no es reconocido");
        }
    }
}
