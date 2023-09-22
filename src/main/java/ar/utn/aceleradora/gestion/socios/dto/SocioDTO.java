package ar.utn.aceleradora.gestion.socios.dto;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.BeanUtils;

@Getter
@Setter
public class SocioDTO {
  private Integer id;
  private String nombre;
  private TipoSocio categoria;
  private Integer telefono;
  private String mail;
  private String nombrePresidente;  //solo para socios plenarios
  private TipoSocio tipoSocio;
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