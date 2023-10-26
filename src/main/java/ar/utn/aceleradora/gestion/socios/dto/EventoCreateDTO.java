package ar.utn.aceleradora.gestion.socios.dto;

import ar.utn.aceleradora.gestion.socios.modelos.evento.TipoModalidad;
import lombok.Getter;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.evento.Estado;
import ar.utn.aceleradora.gestion.socios.modelos.Departamento;

import java.util.Date;
import java.util.List;

@Getter
public class EventoCreateDTO {
    private String nombre;
    private String descripcion;
    private Date fechaComienzo;
    private Date fechaFin;
    private TipoModalidad modalidad;
    private Ubicacion ubicacion;
    private List<Socio> invitados;
    private List<Inscripto> inscriptos;
    private Estado estado;
    private List<Departamento> departamentos;
}
