package ar.utn.aceleradora.gestion.socios.dto.socios;

import lombok.Getter;

@Getter
public class SocioUpdateDTO {
    private String nombre;
    private String nombrePresidente;
    private String cuit;
    private String telefono;
    private String mail;
    private String direccion;
    private String piso;
    private String departamento;
    private String localidad;
    private String provincia;
}
