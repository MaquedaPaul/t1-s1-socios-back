package ar.utn.aceleradora.gestion.socios.modelos.empresa;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Etiqueta;
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
@DiscriminatorValue(value = "socioPlenario")
public class SocioPlenario extends Socio{



  @Column
  private String nombrePresidente;
    /*
      @Column
        private String nombreEmpresa;

      private TipoSocio categoria = SOCIO_PLENARIO;
      @Column
      private Boolean activo;
      @Column
      private Integer telefono;
    @Column
      private String mail;

     /* @ManyToMany(fetch = FetchType.LAZY)
      @JoinTable(name = "etiqueta_x_socioPlenario",
              joinColumns = @JoinColumn(name = "idPlenario"),
              inverseJoinColumns = @JoinColumn(name = "idEtiqueta")
      )
      @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
      private List<Etiqueta> etiquetas;

      @OneToOne(cascade = CascadeType.ALL)
      private Ubicacion ubicacion;
    */

  public void votar() {
    //TODO
  }


  public SocioPlenario(String nombreEmpresa, String nombrePresidente, Integer telefono, String mail, Ubicacion ubicacion) {
    super(nombreEmpresa, TipoSocio.SOCIO_PLENARIO, telefono, mail, ubicacion);
    this.nombrePresidente = nombrePresidente;
  }


}


