package ar.utn.aceleradora.gestion.socios.dto.eventos;

import ar.utn.aceleradora.gestion.socios.modelos.eventos.EstadoEvento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoEstadoEvento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoModalidad;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter @Setter
public class ListaEventoDTO {
    private Integer id;
    private UUID uuid;
    private String nombre;
    private LocalDate fechaComienzo;
    private TipoEstadoEvento tipoEstadoEvento;
    private TipoModalidad modalidad;
    private String direccion;
}
