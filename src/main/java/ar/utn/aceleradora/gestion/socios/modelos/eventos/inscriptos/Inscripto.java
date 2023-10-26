package ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos;

import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.EstadoInscripto;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "inscriptos")
public class Inscripto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "trabajo")
    private String trabajo;

    @ManyToOne
    private Socio socioRepresentado;

    @OneToMany
    private List<EstadoInscripto> estados;

    @Column(name = "mail")
    private String mail;
}
