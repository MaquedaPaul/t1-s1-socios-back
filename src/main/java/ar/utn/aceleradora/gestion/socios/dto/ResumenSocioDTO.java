package ar.utn.aceleradora.gestion.socios.dto;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Etiqueta;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
public class ResumenSocioDTO{
  private String nombre;
  private String apellidoPresidente;
  private TipoSocio tipoSocio;
  private List<Etiqueta> categoria;
  private Boolean activo;
  private String mail;
  private String telefono;
  private Ubicacion ubicacion;
  //TODO: deberia ser un date
  private Integer AniosDeAntiguedad;
}