package ar.utn.aceleradora.gestion.socios.dto.departamentos;

import lombok.Getter;
import java.util.List;

@Getter
public class CreacionEdicionDepartamentoDTO {
    public String nombre;
    public String descripcion;
    public List<Integer> autoridades;
    public Integer jerarquia;
    public List<Integer> idSocios;
    public Integer idCoordinacion;
}
