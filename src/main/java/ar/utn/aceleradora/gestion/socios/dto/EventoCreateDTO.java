package ar.utn.aceleradora.gestion.socios.dto;

import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoModalidad;
import lombok.Getter;

import java.util.List;

@Getter
public class EventoCreateDTO {
    private String nombre;
    private String descripcion;
    private String fechaComienzo;
    private String fechaFin;
    private Integer modalidad;
    private String direccion;
    private String piso;
    private String departamento;
    private String localidad;
    private String provincia;
    private List<Integer> id_socios_invitados;//Tal vez haya que eliminar
    private List<Integer> id_departamentos;
}
