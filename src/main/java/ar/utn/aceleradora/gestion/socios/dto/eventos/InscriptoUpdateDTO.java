package ar.utn.aceleradora.gestion.socios.dto.eventos;

import lombok.Getter;

@Getter
public class InscriptoUpdateDTO {
    private String nombre;
    private String apellido;
    private String trabajo;
    private String mail;
    private String tipoEstadoInscripto;
    private String motivo;
}
