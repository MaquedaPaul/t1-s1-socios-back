package ar.utn.aceleradora.gestion.socios.dto;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoModalidad;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.Inscripto;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import lombok.Getter;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.Estado;


import java.util.Date;
import java.util.List;

@Getter
public class EventoCreateDTO {
    private String nombre;
    private String descripcion;
    private String fechaComienzo;
    private String fechaFin;
    private TipoModalidad modalidad;
    private Ubicacion ubicacion;
    private List<Socio> invitados;
    private List<Inscripto> inscriptos;
    private Estado estado;
    private List<Departamento> departamentos;
}
