package ar.utn.aceleradora.gestion.socios.modelos.empresa;



import ar.utn.aceleradora.gestion.socios.modelos.departamento.Etiqueta;
import ar.utn.aceleradora.gestion.socios.modelos.evento.Evento;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import static ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio.SOCIO_EMPRESA;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Departamento;

import java.util.List;


@Entity
@Getter
@Setter
@Table
@DiscriminatorValue(value = "socioEmpresa")
public class SocioEmpresa extends Socio{
  public SocioEmpresa(String nombreEmpresa, Integer telefono, String mail, Ubicacion ubicacion) {
    super(nombreEmpresa, TipoSocio.SOCIO_EMPRESA, telefono, mail, ubicacion);
  }

  public SocioEmpresa() {
  }
}
