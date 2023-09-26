package ar.utn.aceleradora.gestion.socios.modelos.empresa;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Categoria;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio.SOCIO_PLENARIO;

import java.util.List;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Departamento;

@Entity
@Getter
@Setter
//@Table
@DiscriminatorValue(value = "socioPlenario")
public class SocioPlenario extends Socio{

  @Column
  private String nombrePresidente;

  public SocioPlenario() {

  }

  public void votar() {
    //TODO
  }


  public SocioPlenario(String nombre, String nombrePresidente, Integer telefono, String mail, Ubicacion ubicacion) {
    super(nombre, TipoSocio.SOCIO_PLENARIO, telefono, mail, ubicacion);
    this.nombrePresidente = nombrePresidente;
  }


}


