package ar.utn.aceleradora.gestion.socios.modelos.departamento;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
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

    public Departamento(String nombreDepto,List<Socio> miembrosDptos){
        this.nombre = nombreDepto;
        this.miembros = miembrosDptos;
    }

    public void agregarSocio(Socio socio){
       miembros.add(socio);
   }

}
