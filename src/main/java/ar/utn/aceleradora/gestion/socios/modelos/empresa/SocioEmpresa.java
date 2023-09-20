package ar.utn.aceleradora.gestion.socios.modelos.empresa;



import ar.utn.aceleradora.gestion.socios.modelos.departamento.Etiqueta;
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


  @Column
  private String nombreEmpresa;


  private TipoSocio categoria = SOCIO_EMPRESA;
  @Column
  private Boolean activo;
  @Column
  private Integer telefono;
  @Column
  private String mail;
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "etiqueta_x_socioEmpresa",
          joinColumns = @JoinColumn(name = "idEmpresa"),
          inverseJoinColumns = @JoinColumn(name = "idEtiqueta")
  )
  private List<Etiqueta> etiquetas;

  @ManyToMany( fetch = FetchType.LAZY)
  @JoinTable(name = "departamento_x_socioEmpresa",
          joinColumns = @JoinColumn(name = "idEmpresa"),
          inverseJoinColumns = @JoinColumn(name = "idDepartamento")
  )
  private List<Departamento> departamentos;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private Ubicacion ubicacion;

  public SocioEmpresa(String nombreEmpresa, TipoSocio categoria, Integer telefono, String mail,Ubicacion ubicacion) {
    this.nombreEmpresa = nombreEmpresa;
    this.categoria = categoria;
    this.activo = true; // Suponemos que al dar de alta, el socio está activo por defecto
    this.telefono = telefono;
    this.mail = mail;
    this.ubicacion = ubicacion;
  }

  public SocioEmpresa() {}

  public void recibirEtiqueta(Etiqueta etiqueta){
    this.etiquetas.add(etiqueta);
  }
}
