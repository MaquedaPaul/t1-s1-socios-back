package ar.utn.aceleradora.gestion.socios.dto.socios;

import lombok.Getter;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;

@Getter
public class SocioCreateDTO {
    private String nombre;
    private String nombrePresidente;
    private String cuit;
    private String tipoSocio;
    private String telefono;
    private String mail;
    private List<Integer> categorias;
    private String direccion;
    private String piso;
    private String departamento;
    private String localidad;
    private String provincia;
    private Double valor;
    private Integer membresiaId;
    public String fechaInicio;
}
