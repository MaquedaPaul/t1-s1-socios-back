package ar.utn.aceleradora.gestion.socios.modelos.empresa;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.*;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import static ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio.SOCIO_PLENARIO;

@Entity
@Getter
@Setter
public class SocioPlenario implements Socio {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idSocioPlenario;
  @Enumerated
  private TipoSocio categoria = SOCIO_PLENARIO;
  @Column
  private String nombreEmpresa;
  @Column
  private String nombrePresidente;
  @Column
  private Boolean activo;

  @Column
  private Integer telefono;

  @Column
  private String mail;

  public SocioPlenario() {
  }

  public void votar(){
    //TODO
  }

  public SocioPlenario(String nombreEmpresa, String nombrePresidente, Integer telefono, String mail) {
    this.nombreEmpresa = nombreEmpresa;
    this.nombrePresidente = nombrePresidente;
    this.activo = true; // Suponemos que al dar de alta, el socio está activo por defecto
    this.telefono = telefono;
    this.mail = mail;
  }

}


