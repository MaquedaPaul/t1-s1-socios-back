package ar.utn.aceleradora.gestion.socios.dto.reservas;

import ar.utn.aceleradora.gestion.socios.dto.departamentos.ProyeccionDepartamentoDTO;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.EspacioFisico;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.EstadoReserva;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.RecursoSolicitado;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
public class ReservaLimitadoDTO {
    private Integer id;
    private ProyeccionDepartamentoDTO departamentoAsociado;
    private EspacioFisico espacioFisico;
    private String descripcion;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private String nombreReservante;
    private String apellidoReservante;
    private String mailReservante;
    private String telefonoReservante;
    private List<RecursoSolicitado> recursosSolicitados;
    private List<EstadoReserva> estadosReserva;
    private String codigoSeguimiento;
}
