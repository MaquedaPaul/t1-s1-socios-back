package ar.utn.aceleradora.gestion.socios.modelos.departamento;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioEmpresa;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioPlenario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

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
    @JoinTable(name = "departamento_x_socio",
            joinColumns = @JoinColumn(name="id"),
            inverseJoinColumns=@JoinColumn(name="id"))
    private List<Socio> miembros;
    @OneToMany(mappedBy = "Departamento",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Etiqueta> etiquetas;

    public Departamento(String nombreDepto,List<Socio> miembrosDptos,List<Etiqueta> etiquetas){
        this.nombre = nombreDepto;
        this.miembros = miembrosDptos;
        this.etiquetas = etiquetas;
    }

    public void agregarSocio(Socio socio){
       miembros.add(socio);
   }
   public void asignarEtiqutaSocioEmpresa(Etiqueta etiqueta, SocioEmpresa socio){
        socio.recibirEtiqueta(etiqueta);
   }
    public void asignarEtiqutaSocioPlenario(Etiqueta etiqueta, SocioPlenario socio){
        socio.recibirEtiqueta(etiqueta);
    }

}
