package ar.utn.aceleradora.gestion.socios.modelos.departamento;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioEmpresa;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioPlenario;
import jakarta.persistence.*;
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

    @Column
    private String nombre;

    @OneToMany(mappedBy = "departamentoPerteneciente")
    private List<Categoria> etiquetas;


    public Departamento() {
    }

    public Departamento(String nombreDepto, List<Categoria> etiquetas){
        this.nombre = nombreDepto;
        this.etiquetas = etiquetas;
    }

    public void agregarEtiqueta(Categoria e){
       etiquetas.add(e);
   }
  // public void asignarEtiqutaSocioEmpresa(Etiqueta etiqueta, SocioEmpresa socio){
 //       socio.recibirEtiqueta(etiqueta);
 //  }
   /* public void asignarEtiqutaSocioPlenario(Etiqueta etiqueta, SocioPlenario socio){
        socio.recibirEtiqueta(etiqueta);
    }
*/

}
