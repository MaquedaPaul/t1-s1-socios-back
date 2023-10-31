package ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos;

import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Getter
@Entity
@Table(name = "inscriptos")
public class Inscripto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    @Setter
    private String nombre;

    @Column(name = "apellido")
    @Setter
    private String apellido;


    @Column(name = "trabajo")
    @Setter
    private String trabajo;


    @ManyToOne
    @JoinColumn(name = "id_socio_invitante")
    @Setter
    private Socio socioInvitante;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_estado_inscripto")
    @Setter
    private List<EstadoInscripto> estados;

    @Column(name = "mail")
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
    public Inscripto(String nombre, String apellido, String trabajo, String mail){
        this.nombre = nombre;
        this.apellido = apellido;
        this.trabajo = trabajo;
        this.mail = mail;
        this.estados = new ArrayList<>();
    }

    public void agregarEstado(EstadoInscripto estado){
        this.estados.add(estado);
    }

    public EstadoInscripto estadoActual(){
        return this.estados.get(this.estados.size()-1);
    }
}
