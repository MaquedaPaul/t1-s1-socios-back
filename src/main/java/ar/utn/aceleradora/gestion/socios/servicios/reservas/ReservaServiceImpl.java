package ar.utn.aceleradora.gestion.socios.servicios.reservas;

import ar.utn.aceleradora.gestion.socios.dto.departamentos.ProyeccionDepartamentoDTO;
import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaLimitadoDTO;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.Reserva;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.EspacioFisicoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.RecursoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.RecursoSolicitadoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public List<ReservaLimitadoDTO> listarReservas() {
        Reserva reservaTest = new Reserva();

        reservaRepository.save(reservaTest);
        List<Reserva> reservas = reservaRepository.findAll();
        List<ReservaLimitadoDTO> reservasLimitadas = new ArrayList<>();
        reservas.forEach(reserva -> this.creacionReservaLimitada(reserva, reservasLimitadas));
        return reservasLimitadas;
    }

    private void creacionReservaLimitada(Reserva reserva, List<ReservaLimitadoDTO> reservasLimitadas) {
        ReservaLimitadoDTO nuevaReservaLimitada = new ReservaLimitadoDTO();
        nuevaReservaLimitada.setId(reserva.getId());
        //nuevaReservaLimitada.setDescripcion(reserva.getDescripcion); //TODO DESCOMENTAR
        nuevaReservaLimitada.setEstadosReserva(reserva.getEstadosReserva());
        nuevaReservaLimitada.setRecursosSolicitados(reserva.getRecursosSolicitados());

        nuevaReservaLimitada.setFecha(reserva.getFecha());
        nuevaReservaLimitada.setHoraInicio(reserva.getHoraInicio());
        nuevaReservaLimitada.setHoraFin(reserva.getHoraFin());
        nuevaReservaLimitada.setEspacioFisico(reserva.getEspacioFisico());

        ProyeccionDepartamentoDTO departamentoDTO = new ProyeccionDepartamentoDTO();
        Departamento departamentoAsociado = reserva.getDepartamentoAsociado();
        departamentoDTO.setNombre(departamentoAsociado.getNombre());
        departamentoDTO.setJerarquia(departamentoAsociado.getJerarquia());
        departamentoDTO.setDescripcion(departamentoAsociado.getDescripcion());
        departamentoDTO.setIcono(departamentoAsociado.getIcono());
        departamentoDTO.setId(departamentoAsociado.getId());

        nuevaReservaLimitada.setDepartamentoAsociado(departamentoDTO);

        nuevaReservaLimitada.setMailReservante(reserva.getMailReservante());
        nuevaReservaLimitada.setNombreReservante(reserva.getNombreReservante());
        nuevaReservaLimitada.setApellidoReservante(reserva.getApellidoReservante());
        nuevaReservaLimitada.setTelefonoReservante(reserva.getTelefonoReservante());

        reservasLimitadas.add(nuevaReservaLimitada);

    }
}
