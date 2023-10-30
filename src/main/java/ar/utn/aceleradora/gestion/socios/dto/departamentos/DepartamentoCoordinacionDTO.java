package ar.utn.aceleradora.gestion.socios.dto.departamentos;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Coordinacion;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.serializers.CoordinacionJsonSerializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(value = "departamentos")
public class DepartamentoCoordinacionDTO {
    private Departamento departamento;
    @JsonSerialize(using = CoordinacionJsonSerializer.class)
    private Coordinacion coordinacion;

}
