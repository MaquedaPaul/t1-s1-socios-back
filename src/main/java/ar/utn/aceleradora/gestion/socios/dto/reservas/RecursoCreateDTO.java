package ar.utn.aceleradora.gestion.socios.dto.reservas;

import lombok.Getter;

@Getter
public class RecursoCreateDTO {

    private Integer idRecursoSolicitado;
    private Integer cantidad;
    private boolean aprobado;

}
