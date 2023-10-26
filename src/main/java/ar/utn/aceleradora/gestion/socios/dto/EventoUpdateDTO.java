package ar.utn.aceleradora.gestion.socios.dto;

import ar.utn.aceleradora.gestion.socios.modelos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.evento.Estado;
import ar.utn.aceleradora.gestion.socios.modelos.evento.TipoModalidad;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class EventoUpdateDTO {//Tal vez algunos atributos sobran
    private String nombre;
    private Date fechaComienzo;
    private Date fechaFin;
    private TipoModalidad modalidad;
    private Ubicacion ubicacion;
    private List<Socio> invitados;
    private List<Inscripto> inscriptos;
    private Estado estado;
    private List<Departamento> departamentos;
}
