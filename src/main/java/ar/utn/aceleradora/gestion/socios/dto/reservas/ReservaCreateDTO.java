package ar.utn.aceleradora.gestion.socios.dto.reservas;

import lombok.Getter;

import java.util.List;

@Getter
public class ReservaCreateDTO {
    private Integer idDepartamento;
    private String fecha;
    private Integer idEspacioFisico;
    private String horaInicio;
    private String horaFin;
    private String descripcion;
    private String nombreReservante;
    private String mailReservante;
    private String apellidoReservante;
    private String telefonoReservante;
    private List<RecursoCreateDTO> recursosSolicitados;

}
