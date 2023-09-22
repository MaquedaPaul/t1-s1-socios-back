package ar.utn.aceleradora.gestion.socios.modelos.evento;


import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter@Setter
@Table(name="evento")
public class Evento {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String nombre;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "Evento_X_Socio",
            joinColumns = @JoinColumn(name = "idEvento"),
            inverseJoinColumns = @JoinColumn(name = "idSocio")
    )
    private List <Socio> socios;


    public Evento() {
    }

    public Evento(String nombre, List<Socio> socios) {
        this.nombre = nombre;
        this.socios = socios;
    }

}
