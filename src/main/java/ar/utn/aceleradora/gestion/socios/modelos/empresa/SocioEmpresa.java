package ar.utn.aceleradora.gestion.socios.modelos.empresa;



import ar.utn.aceleradora.gestion.socios.modelos.empresa.*;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import static ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio.SOCIO_EMPRESA;


@Entity
@Getter
@Setter
@Table
public class SocioEmpresa implements Socio {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idSocioEmpresa;

  @Column
  private String nombreEmpresa;
  @Enumerated
  private TipoSocio categoria = SOCIO_EMPRESA;
  @Column
  private Boolean activo;
  @Column
  private Integer telefono;
  @Column
  private String mail;

  //@OneToOne
  @Transient
  private Ubicacion ubicacion;

  public SocioEmpresa(String nombreEmpresa, TipoSocio categoria, Integer telefono, String mail,Ubicacion ubicacion) {
    this.nombreEmpresa = nombreEmpresa;
    this.categoria = categoria;
    this.activo = true; // Suponemos que al dar de alta, el socio está activo por defecto
    this.telefono = telefono;
    this.mail = mail;
    this.ubicacion = ubicacion;
  }

  public SocioEmpresa() {

  }
}
