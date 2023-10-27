package ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos;

import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "inscriptos")
public class Inscripto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;

    @Column(name = "nombre")
    @Getter @Setter
    private String nombre;

    @Column(name = "apellido")
    @Getter @Setter
    private String apellido;


    @Column(name = "trabajo")
    @Getter @Setter
    private String trabajo;


    @ManyToOne
    @JoinColumn(name = "id_socio_invitante")
    @Getter @Setter
    private Socio socioInvitante;

    @OneToMany
    @JoinColumn(name = "id_estado_inscripto")
    @Getter @Setter
    private List<EstadoInscripto> estados;

    @Column(name = "mail")
    @Getter
    @Setter
    private String mail;

    public Inscripto(){
        this.estados = new ArrayList<>();
        this.estados.add(new EstadoInscripto(TipoEstadoInscripto.PENDIENTE, LocalDateTime.now(), "Recien inscripto"));
    }

    public Inscripto(String nombre, String apellido, String trabajo, String mail, Socio socio){
        this.nombre = nombre;
        this.apellido = apellido;
        this.trabajo = trabajo;
        this.mail = mail;
        this.socioInvitante = socio;
        this.estados = new ArrayList<>();
        this.estados.add(new EstadoInscripto(TipoEstadoInscripto.PENDIENTE, LocalDateTime.now(), "Recien inscripto"));
    }

    public void agregarEstado(EstadoInscripto estado){
        this.estados.add(estado);
    }

    public EstadoInscripto estadoActual(){
        return this.estados.get(this.estados.size()-1);
    }
}
