package ar.utn.aceleradora.gestion.socios.dto.eventos;


import ar.utn.aceleradora.gestion.socios.dto.departamentos.ProyeccionDepartamentoDTO;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.EstadoEvento;

import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoModalidad;

import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.Inscripto;

import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;

import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class EventoLimitadoDTO {

    private Integer id;
    private UUID uuid;
    private String nombre;
    private String descripcion;
    private LocalDate fechaComienzo;
    private LocalDate fechaFin;
    private TipoModalidad modalidad;
    private Ubicacion ubicacion;
    private List<Inscripto> inscriptos;
    private List<EstadoEvento> estadosEvento;
    private List<ProyeccionSocioDTO> invitados;
    private List<ProyeccionDepartamentoDTO> departamentos;
    private LocalTime hora;


}
