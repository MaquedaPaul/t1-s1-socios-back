package ar.utn.aceleradora.gestion.socios.servicios.reservas;

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
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.Reserva;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
        Recurso recursoTest1 = new Recurso();
        Recurso recursoTest2 = new Recurso();
        EspacioFisico espacioFisicoTest = new EspacioFisico();
        recursoRepository.save(recursoTest1);
        recursoRepository.save(recursoTest2);
        espacioFisicoRepository.save(espacioFisicoTest);


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
            nuevoRecurso.setAprobado(recursoCreateDTO.isAprobado());
            recursosSolicitados.add(nuevoRecurso);
        });
    return recursosSolicitados;
    }



}
