package ar.utn.aceleradora.gestion.socios.dto.departamentos;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Autoridad;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Coordinacion;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.serializers.CoordinacionJsonSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class DepartamentoCoordinacionDTO {
    private Integer id;
    private LocalDateTime fechaBaja;
    private String nombre;
    private String descripcion;
    private String icono;
    private int jerarquia;
    private List<Autoridad> autoridades;
    private List<Socio> sociosSuscritos;
    @JsonIgnoreProperties(value = "departamentos")
    private Coordinacion coordinacion;
}
