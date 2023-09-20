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
    @GeneratedValue
    private Integer id;

    @Column
    private String nombre;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "departamento_x_socioPlenario",
            joinColumns = @JoinColumn(name="idDepartamento"),
            inverseJoinColumns=@JoinColumn(name="idPlenario"))
    private List<SocioPlenario> socioPlenario;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "departamento_x_socioEmpresa",
            joinColumns = @JoinColumn(name="idDepartamento"),
            inverseJoinColumns=@JoinColumn(name="idEmpresa"))
    private List<SocioEmpresa> socioEmpresa;

    public Departamento(String nombreDepto,List<SocioEmpresa> socioEmpresa,List<SocioPlenario> socioPlenario){
        this.nombre = nombreDepto;
        this.socioEmpresa = socioEmpresa;
        this.socioPlenario = socioPlenario;

    }

    public void agregarSocioPlenario(SocioPlenario socio){
       socioPlenario.add(socio);
   }
   public void asignarEtiqutaSocioEmpresa(Etiqueta etiqueta, SocioEmpresa socio){
        socio.recibirEtiqueta(etiqueta);
   }
    public void asignarEtiqutaSocioPlenario(Etiqueta etiqueta, SocioPlenario socio){
        socio.recibirEtiqueta(etiqueta);
    }

    public void agregarSocioEmpresa(SocioEmpresa socio){
        socioEmpresa.add(socio);
    }
}
