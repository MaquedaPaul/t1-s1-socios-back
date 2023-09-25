package ar.utn.aceleradora.gestion.socios.dto;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Categoria;
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
  private List<Categoria> categoria;
  private Ubicacion ubicacion;
}
