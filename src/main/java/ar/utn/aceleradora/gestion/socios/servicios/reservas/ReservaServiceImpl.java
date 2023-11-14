package ar.utn.aceleradora.gestion.socios.servicios.reservas;

import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaUpdateDTO;
import ar.utn.aceleradora.gestion.socios.error.reservas.EstadoReservaNoValidoException;
import ar.utn.aceleradora.gestion.socios.error.reservas.ReservaNotFoundException;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.*;
import ar.utn.aceleradora.gestion.socios.dto.departamentos.ProyeccionDepartamentoDTO;
import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaLimitadoDTO;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.Reserva;
import ar.utn.aceleradora.gestion.socios.converters.DateConverter;
import ar.utn.aceleradora.gestion.socios.dto.reservas.RecursoCreateDTO;
import ar.utn.aceleradora.gestion.socios.error.departamentos.DepartamentoNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.reservas.EspacioFisicoNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.reservas.RecursoNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.reservas.ReservaNotCreatedException;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.EspacioFisico;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.Recurso;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.RecursoSolicitado;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.EspacioFisicoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.RecursoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.RecursoSolicitadoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.ReservaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaCreateDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;

@Service
public class ReservaServiceImpl implements ReservaService {
    private final ReservaRepository reservaRepository;
    private final RecursoRepository recursoRepository;
    private final RecursoSolicitadoRepository recursoSolicitadoRepository;
    private final EspacioFisicoRepository espacioFisicoRepository;
    private final DepartamentoRepository departamentoRepository;

    @Autowired
    public ReservaServiceImpl(ReservaRepository reservaRepository, RecursoRepository recursoRepository, RecursoSolicitadoRepository recursoSolicitadoRepository, EspacioFisicoRepository espacioFisicoRepository, DepartamentoRepository departamentoRepository) {
        this.reservaRepository = reservaRepository;
        this.recursoRepository = recursoRepository;
        this.recursoSolicitadoRepository = recursoSolicitadoRepository;
        this.espacioFisicoRepository = espacioFisicoRepository;
        this.departamentoRepository = departamentoRepository;
    }

    @Override
    public void crearReserva(ReservaCreateDTO reservaCreateDTO) {
        Reserva nuevaReserva = new Reserva();


        this.crearReservaMapearPrimitivos(nuevaReserva, reservaCreateDTO);
        List<RecursoSolicitado> recursoSolicitados = this.crearReservaMapearRecursosSolicitados(reservaCreateDTO);
        Departamento departamentoEncontrado =
                departamentoRepository
                        .findById(reservaCreateDTO.getIdDepartamento())
                        .orElseThrow(() -> new DepartamentoNotFoundException("No se encontró el departamento con el id: " + reservaCreateDTO.getIdDepartamento()));

        EspacioFisico espacioFisicoEncontrado =
                espacioFisicoRepository
                        .findById(reservaCreateDTO.getIdEspacioFisico())
                        .orElseThrow(() -> new EspacioFisicoNotFoundException("No se encontró el espacio físico con el id: " + reservaCreateDTO.getIdEspacioFisico()));

        nuevaReserva.setDepartamentoAsociado(departamentoEncontrado);
        nuevaReserva.setEspacioFisico(espacioFisicoEncontrado);
        nuevaReserva.setRecursosSolicitados(recursoSolicitados);

        try {
            reservaRepository.save(nuevaReserva);
            nuevaReserva.generarCodigoSeguimiento();
            reservaRepository.save(nuevaReserva);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ReservaNotCreatedException("No se pudo crear la reserva");
        }
    }
    private void crearReservaMapearPrimitivos(Reserva nuevaReserva, ReservaCreateDTO reservaCreateDTO){
        nuevaReserva.setFecha(DateConverter.parse(reservaCreateDTO.getFecha()));
        nuevaReserva.setHoraInicio(DateConverter.parseDateTime(reservaCreateDTO.getHoraInicio()));
        nuevaReserva.setDescripcion(reservaCreateDTO.getDescripcion());
        nuevaReserva.setHoraFin(DateConverter.parseDateTime(reservaCreateDTO.getHoraFin()));
        nuevaReserva.setNombreReservante(reservaCreateDTO.getNombreReservante());
        nuevaReserva.setMailReservante(reservaCreateDTO.getMailReservante());
        nuevaReserva.setApellidoReservante(reservaCreateDTO.getApellidoReservante());
        nuevaReserva.setTelefonoReservante(reservaCreateDTO.getTelefonoReservante());
    }
    private List<RecursoSolicitado> crearReservaMapearRecursosSolicitados(ReservaCreateDTO reservaCreateDTO){
        List<RecursoCreateDTO> recursosCreateDTO = new ArrayList<>(reservaCreateDTO.getRecursosSolicitados());
        List<RecursoSolicitado> recursosSolicitados = new ArrayList<>();
        recursosCreateDTO.forEach(recursoCreateDTO-> {
            RecursoSolicitado nuevoRecurso = new RecursoSolicitado();
            Integer idRecursoSolicitado = recursoCreateDTO.getIdRecursoSolicitado();
            Recurso recurso= recursoRepository
                    .findById(idRecursoSolicitado)
                    .orElseThrow(() -> new RecursoNotFoundException("No se pudo encontrar al recurso con id: "+idRecursoSolicitado));
            nuevoRecurso.setRecurso(recurso);
            nuevoRecurso.setCantidad(recursoCreateDTO.getCantidad());
            nuevoRecurso.setAprobado(true);
            recursosSolicitados.add(nuevoRecurso);
        });
    return recursosSolicitados;
    }




    @Override
    public List<ReservaLimitadoDTO> listarReservas() {
        List<Reserva> reservas = reservaRepository.findAll();
        List<ReservaLimitadoDTO> reservasLimitadas = new ArrayList<>();
        reservas.forEach(reserva -> this.creacionReservaLimitada(reserva, reservasLimitadas));
        return reservasLimitadas;
    }

    private void creacionReservaLimitada(Reserva reserva, List<ReservaLimitadoDTO> reservasLimitadas) {
        ReservaLimitadoDTO nuevaReservaLimitada = new ReservaLimitadoDTO();
        nuevaReservaLimitada.setId(reserva.getId());
        nuevaReservaLimitada.setDescripcion(reserva.getDescripcion());
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
