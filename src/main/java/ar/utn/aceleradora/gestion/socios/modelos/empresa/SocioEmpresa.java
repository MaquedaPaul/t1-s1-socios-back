package ar.utn.aceleradora.gestion.socios.modelos.empresa;



import ar.utn.aceleradora.gestion.socios.modelos.empresa.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


import static ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio.SOCIO_EMPRESA;


@Entity
@Getter
@Setter
public class SocioEmpresa implements Socio {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idSocioEmpresa;

  private String nombreEmpresa;
  @Enumerated
  private TipoSocio categoria = SOCIO_EMPRESA;
  private Boolean activo;
  private Integer telefono;
  private String mail;

  public SocioEmpresa(String nombreEmpresa, TipoSocio categoria, Integer telefono, String mail) {
    this.nombreEmpresa = nombreEmpresa;
    this.categoria = categoria;
    this.activo = true; // Suponemos que al dar de alta, el socio está activo por defecto
    this.telefono = telefono;
    this.mail = mail;
  }

  public SocioEmpresa() {

  }
}
