package ar.utn.aceleradora.gestion.socios.servicios.reservas;

import ar.utn.aceleradora.gestion.socios.error.departamentos.DepartamentoNotCreatedException;
import ar.utn.aceleradora.gestion.socios.error.departamentos.DepartamentoNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.reservas.EspacioFisicoNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.reservas.RecursoNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.reservas.ReservaNotCreatedException;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.EspacioFisico;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.Recurso;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.EspacioFisicoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.RecursoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.RecursoSolicitadoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.ReservaRepository;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaCreateDTO;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.Reserva;
import org.springframework.stereotype.Service;

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
        Reserva nuevaReserva = new Reserva();

        /*
        nuevaReserva.setFecha(reservaCreateDTO.getFecha());
        nuevaReserva.setHoraInicio(reservaCreateDTO.getHoraInicio());
        nuevaReserva.setDescripcion(reservaCreateDTO.getDescripcion());
        nuevaReserva.setDuracion(reservaCreateDTO.getDuracion());
        nuevaReserva.setNombre(reservaCreateDTO.getNombre());
        nuevaReserva.setMail(reservaCreateDTO.getMail());
        nuevaReserva.setApellido(reservaCreateDTO.getApellido());
        nuevaReserva.setTelefono(reservaCreateDTO.getTelefono());
*/
        Optional<Departamento> departamentoEncontrado =
                Optional.ofNullable(departamentoRepository
                        .findById(reservaCreateDTO.getIdDepartamento())
                        .orElseThrow(() -> new DepartamentoNotFoundException("No se encontró el departamento con el id: " + reservaCreateDTO.getIdDepartamento())));

        Optional<EspacioFisico> espacioFisicoEncontrado =
                Optional.ofNullable(espacioFisicoRepository
                        .findById(reservaCreateDTO.getIdEspacioFisico())
                        .orElseThrow(() -> new EspacioFisicoNotFoundException("No se encontró el espacio físico con el id: " + reservaCreateDTO.getIdEspacioFisico())));

        List<Integer> idsRecursos = reservaCreateDTO.getIdsRecursos();
        Optional<List<Recurso>> recursosEncontrados =
                Optional.of(recursoRepository.findAllById(idsRecursos));

        Optional<Integer> recursoNoEncontradoId = recursosEncontrados
                .flatMap(recursos -> idsRecursos.stream()
                        .filter(id -> recursos.stream().noneMatch(recurso -> id.equals(recurso.getId())))
                        .findFirst());

        recursoNoEncontradoId.ifPresent(id -> {
            throw new RecursoNotFoundException("No se pudo encontrar el recurso con id: " + id);
        });
        /*
        nuevaReserva.setDepartamento(departamentoEncontrado.get());
        nuevaReserva.setEspacioFisico(espacioFisicoEncontrado.get());
        nuevaReserva.setRecursosSolicitados(recursosEncontrados.get());
        */

        try {
            reservaRepository.save(nuevaReserva);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            throw new ReservaNotCreatedException("No se pudo crear la reserva");
        }
    }
}
