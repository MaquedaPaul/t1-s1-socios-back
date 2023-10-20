package ar.utn.aceleradora.gestion.socios.dto;

import lombok.Getter;
import java.util.List;

public class CreacionEdicionDepartamentoDTO {
    @Getter
    public String nombre;
    @Getter
    public String descripcion;
    @Getter
    public List<Integer> autoridades;
    @Getter
    public Integer jerarquia;
    @Getter
    public List<Integer> idSocios;
    @Getter
    public Integer idCoordinacion;
}
