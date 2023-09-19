package ar.utn.aceleradora.gestion.socios.modelos.empresa;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Etiqueta;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.*;
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
@Table
public class SocioPlenario implements Socio {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer idPlenario;
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

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "etiqueta_x_socioPlenario",
          joinColumns = @JoinColumn(name = "idPlenario"),
          inverseJoinColumns = @JoinColumn(name = "idEtiqueta")
  )
  private List<Etiqueta> etiquetas;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "departamento_x_socioPlenario",
          joinColumns = @JoinColumn(name = "idEmpresa"),
          inverseJoinColumns = @JoinColumn(name = "idDepartamento")
  )
  private List<Departamento> departamentos;

  @OneToOne(cascade = CascadeType.ALL)
  private Ubicacion ubicacion;

  public SocioPlenario() {
  }

  public void votar() {
    //TODO
  }

  public SocioPlenario(String nombreEmpresa, String nombrePresidente, Integer telefono, String mail, Ubicacion ubicacion) {
    this.nombreEmpresa = nombreEmpresa;
    this.nombrePresidente = nombrePresidente;
    this.activo = true; // Suponemos que al dar de alta, el socio está activo por defecto
    this.telefono = telefono;
    this.mail = mail;
    this.ubicacion = ubicacion;
  }

  public void recibirEtiqueta(Etiqueta etiqueta) {
    this.etiquetas.add(etiqueta);
  }
}


