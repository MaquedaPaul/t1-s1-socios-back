package ar.utn.aceleradora.gestion.socios.modelos.evento;


import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter@Setter
@Table(name="evento")
public class Evento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "El nombre de evento no puede estar vacío")
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
