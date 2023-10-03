package ar.utn.aceleradora.gestion.socios.servicios.georef.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Municipio{
  @Column(name = "Id_georef")
  public int id;
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  public long idm;
  @Column
  public String nombre;
}
