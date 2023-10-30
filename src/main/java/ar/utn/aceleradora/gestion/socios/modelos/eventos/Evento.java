package ar.utn.aceleradora.gestion.socios.modelos.eventos;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.Inscripto;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoModalidad;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.Estado;

import java.time.LocalDate;
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
    private LocalDate fechaComienzo;

    @Column(name = "fechaFin")
    private LocalDate fechaFin;

    @Enumerated(EnumType.STRING)
    @Column(name = "modalidad")
    private TipoModalidad modalidad;

    @OneToOne
    @JoinColumn(name = "ubicacion_id")
    private Ubicacion ubicacion;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "evento_socio", joinColumns = @JoinColumn(name = "evento_id"), inverseJoinColumns = @JoinColumn(name = "socio_id"))
    private List<Socio> invitados;

    @ManyToMany
    @JoinTable(name = "evento_inscripto", joinColumns = @JoinColumn(name = "evento_id"), inverseJoinColumns = @JoinColumn(name = "inscripto_id"))
    private List<Inscripto> inscriptos;

    @OneToOne
    @JoinColumn(name = "estado")
    private Estado estado;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Departamento> departamentos;

    public Evento(Integer id, String nombre, String descripcion, LocalDate fechaComienzo, LocalDate fechaFin, TipoModalidad modalidad, Ubicacion ubicacion, List<Socio> invitados, List<Inscripto> inscriptos, Estado estado, List<Departamento> departamentos) {
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

    public void finalizar() {
    }

    public void cancelar() {
    }

    public void confirmar(Socio socio) {
    }

    public void invitar(Socio socio) {
    }
}

