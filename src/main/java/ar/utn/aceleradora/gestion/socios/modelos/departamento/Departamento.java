package ar.utn.aceleradora.gestion.socios.modelos.departamento;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;
@Entity
@Table
@Getter@Setter
public class Departamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull@NotBlank
    private String nombre;

    @ManyToMany
    private List<Autoridad> autoridades;

    //@OneToMany(mappedBy = "departamentoPerteneciente")
    //private List<Categoria> etiquetas;


    public Departamento() {
    }

    public Departamento(String nombreDepto){
        this.nombre = nombreDepto;

    }
    public void agregarAutoridades(Autoridad autoridad){
        this.autoridades.add(autoridad);
    }
    public void agregarAutoridades(List<Autoridad> autoridades){
        this.autoridades.addAll(autoridades);

    }
  // public void asignarEtiqutaSocioEmpresa(Etiqueta etiqueta, SocioEmpresa socio){
 //       socio.recibirEtiqueta(etiqueta);
 //  }
   /* public void asignarEtiqutaSocioPlenario(Etiqueta etiqueta, SocioPlenario socio){
        socio.recibirEtiqueta(etiqueta);
    }
*/

}
