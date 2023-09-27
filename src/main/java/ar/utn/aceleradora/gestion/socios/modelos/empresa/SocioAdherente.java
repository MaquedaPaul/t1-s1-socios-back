package ar.utn.aceleradora.gestion.socios.modelos.empresa;



import ar.utn.aceleradora.gestion.socios.modelos.departamento.Categoria;
import ar.utn.aceleradora.gestion.socios.modelos.evento.Evento;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import static ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio.SOCIO_ADHERENTE;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Departamento;

import java.util.List;


@Entity
@Getter
@Setter
//@Table
@DiscriminatorValue(value = "socioEmpresa")
public class SocioAdherente extends Socio{



  public SocioAdherente() {
  }

  public SocioAdherente(String nombreEmpresa, String telefono, String mail, Ubicacion ubicacion) {
    super(nombreEmpresa, TipoSocio.SOCIO_ADHERENTE, telefono, mail, ubicacion);
  }


}
