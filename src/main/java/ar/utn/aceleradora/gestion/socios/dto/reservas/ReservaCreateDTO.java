package ar.utn.aceleradora.gestion.socios.dto.reservas;

import lombok.Getter;

import java.util.List;

@Getter
public class ReservaCreateDTO {
    private Integer idDepartamento;
    private String fecha;
    private Integer espacioFisico;
    private String horaInicio;
    private String descripcion;
    private double duracion;
    private String nombre;
    private String mail;
    private String apellido;
    private String telefono;
    private List<Integer> idsRecursos;

}
