package ar.utn.aceleradora.gestion.socios.dto;

import lombok.Getter;
import java.util.List;

public class CreacionEdicionDepartamentoDTO {
    @Getter
    public String nombreDepartamento;
    @Getter
    public List<AutoridadDTO> autoridades;
    @Getter
    public JerarquiaDTO jerarquia;
    @Getter
    public List<Long> idSocios;
}
