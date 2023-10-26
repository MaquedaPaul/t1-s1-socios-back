package ar.utn.aceleradora.gestion.socios.modelos.evento;

import ar.utn.aceleradora.gestion.socios.modelos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.modelos.Departamento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "eventos")
@Getter @Setter
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fechaComienzo")
    private Date fechaComienzo;

    @Column(name = "fechaFin")
    private Date fechaFin;

    @Enumerated(EnumType.STRING)
    @Column(name = "modalidad")
    private TipoModalidad modalidad;

    @Column(name = "ubicacion")
    private Ubicacion ubicacion;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "evento_socio", joinColumns = @JoinColumn(name = "evento_id"), inverseJoinColumns = @JoinColumn(name = "socio_id"))
    private List<Socio> invitados;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Inscripto> inscriptos;

    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    private Estado estado;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Departamento> departamentos;

    public Evento(Integer id, String nombre, String descripcion, Date fechaComienzo, Date fechaFin, TipoModalidad modalidad, Ubicacion ubicacion, List<Socio> invitados, List<Inscripto> inscriptos, Estado estado, List<Departamento> departamentos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaComienzo = fechaComienzo;
        this.fechaFin = fechaFin;
        this.modalidad = modalidad;
        this.ubicacion = ubicacion;
        this.invitados = new ArrayList<>();
        this.inscriptos = new ArrayList<>();
        this.estado = estado;
        this.departamentos = new ArrayList<>();
    }

    public Evento() {
    }

    public Evento(String nombre, String descripcion, Date fechaComienzo, Date fechaFin, TipoModalidad modalidad, Ubicacion ubicacion, List<Socio> invitados, List<Inscripto> inscriptos, Estado estado, List<Departamento> departamentos) {
    }

    public Evento(String nombre, String descripcion, Date fechaComienzo, Date fechaFin, TipoModalidad modalidad, Ubicacion ubicacion, Estado estado, List<Departamento> departamentos) {
    }
}

