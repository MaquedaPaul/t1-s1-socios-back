package ar.utn.aceleradora.gestion.socios.dto.reservas;

import lombok.Getter;

import java.util.List;

@Getter
public class ReservaUpdateDTO {
    //El estado, motivo se mandan en null si no se cambia. El usuario probablemente esté hardcodeado
    private String tipoEstadoReserva;
    private String motivo;
    private String usuario;
    private List<Integer> idsRecursosAprobados;
}
