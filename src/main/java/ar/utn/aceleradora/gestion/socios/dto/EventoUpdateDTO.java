package ar.utn.aceleradora.gestion.socios.dto;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.EstadoEvento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoModalidad;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.Inscripto;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import lombok.Getter;

import java.util.List;

@Getter
public class EventoUpdateDTO {
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
    private List<Integer> id_invitados;
    private List<Integer> id_departamentos;
    private Integer tipoEstadoEvento;
    private String motivo;
}
