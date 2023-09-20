package ar.utn.aceleradora.gestion.socios.modelos.evento;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
@Table(name="evento")
public class Evento {

    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String nombre;
}
