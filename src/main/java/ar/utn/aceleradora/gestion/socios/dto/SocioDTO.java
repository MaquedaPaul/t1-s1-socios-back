package ar.utn.aceleradora.gestion.socios.dto;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Etiqueta;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
public class SocioDTO {
  private Integer id;
  private String nombre;
  private TipoSocio tipoSocio;
  private Integer telefono;
  private String mail;
  private String nombrePresidente;  //solo para socios plenarios
  private List<Etiqueta> categoria;
  private Ubicacion ubicacion;
  public SocioDTO convertirDTO(SocioDTO socioDTO) {
    if ("SOCIO_PLENARIO".equals(socioDTO.getTipoSocio())) {
      SocioPlenarioDTO socioPlenarioDTO = new SocioPlenarioDTO();
      // copio todas las propiedades de socioDTO a socioPlenarioDTO
      BeanUtils.copyProperties(socioDTO, socioPlenarioDTO);
      return socioPlenarioDTO;
    } else {
      SocioEmpresaDTO socioEmpresaDTO = new SocioEmpresaDTO();
      // copio todas las propiedades de socioDTO a socioEmpresaDTO
      BeanUtils.copyProperties(socioDTO, socioEmpresaDTO);
      return socioEmpresaDTO;
    }
  }
}
