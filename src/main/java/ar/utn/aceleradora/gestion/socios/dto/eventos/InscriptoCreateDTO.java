package ar.utn.aceleradora.gestion.socios.dto.eventos;

import lombok.Getter;

@Getter
public class InscriptoCreateDTO {
    private String nombre;
    private String apellido;
    private String trabajo;
    private Integer idSocioInvitante;
    private String mail;
}
