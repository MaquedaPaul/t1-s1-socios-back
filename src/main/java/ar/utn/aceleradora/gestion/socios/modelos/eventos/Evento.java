package ar.utn.aceleradora.gestion.socios.modelos.eventos;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.Inscripto;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
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
    private List<Socio> invitados;

    @ManyToMany(cascade = CascadeType.MERGE)
    private List<Inscripto> inscriptos;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "estado")
    private List<EstadoEvento> estadoEvento;

    @ManyToMany
    private List<Departamento> departamentos;

    public Evento(Integer id, String nombre, String descripcion, LocalDate fechaComienzo, LocalDate fechaFin, TipoModalidad modalidad, Ubicacion ubicacion, List<Socio> invitados, List<Inscripto> inscriptos, EstadoEvento estadoEvento, List<Departamento> departamentos) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaComienzo = fechaComienzo;
        this.fechaFin = fechaFin;
        this.modalidad = modalidad;
        this.ubicacion = ubicacion;
        this.invitados = new ArrayList<>();
        this.inscriptos = new ArrayList<>();
        this.estadoEvento = new ArrayList<>();;
        this.departamentos = new ArrayList<>();
        this.estadoEvento.add(new EstadoEvento(TipoEstadoEvento.PENDIENTE, LocalDateTime.now(), "Recien agregado"));
    }

    public Evento() {
        this.invitados = new ArrayList<>();
        this.inscriptos = new ArrayList<>();
        this.departamentos = new ArrayList<>();
        this.estadoEvento = new ArrayList<>();
        this.estadoEvento.add(new EstadoEvento(TipoEstadoEvento.PENDIENTE, LocalDateTime.now(), "Recien agregado"));
    }

    public Evento(String nombre, String descripcion, LocalDate fechaComienzo, LocalDate fechaFin, TipoModalidad modalidad, Ubicacion ubicacion, List<Departamento> departamentos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaComienzo = fechaComienzo;
        this.fechaFin = fechaFin;
        this.modalidad = modalidad;
        this.ubicacion = ubicacion;
        this.invitados = new ArrayList<>();
        this.inscriptos = new ArrayList<>();
        this.invitados.addAll(departamentos.stream().flatMap(departamento ->  departamento.getSociosSuscritos().stream()).toList());
        this.departamentos = new ArrayList<>();
        this.estadoEvento = new ArrayList<>();
        this.estadoEvento.add(new EstadoEvento(TipoEstadoEvento.PENDIENTE, LocalDateTime.now(), "Recien agregado"));
    }

    public Evento(String nombre, String descripcion, LocalDate fechaComienzo, LocalDate fechaFin, TipoModalidad modalidad) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaComienzo = fechaComienzo;
        this.fechaFin = fechaFin;
        this.modalidad = modalidad;
        this.invitados = new ArrayList<>();
        this.inscriptos = new ArrayList<>();
        this.estadoEvento = new ArrayList<>();
        this.departamentos = new ArrayList<>();
        this.estadoEvento.add(new EstadoEvento(TipoEstadoEvento.PENDIENTE, LocalDateTime.now(), "Recien agregado"));

    }

    public Evento(String nombre, String descripcion, LocalDate fechaComienzo, LocalDate fechaFin, TipoModalidad modalidad, Ubicacion ubicacion, List<Socio> socios, List<Departamento> departamentos) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaComienzo = fechaComienzo;
        this.fechaFin = fechaFin;
        this.modalidad = modalidad;
        this.ubicacion = ubicacion;
        this.invitados = new ArrayList<>();
        this.inscriptos = new ArrayList<>();
        this.estadoEvento = new ArrayList<>();
        this.departamentos = new ArrayList<>();
        this.invitados.addAll(departamentos.stream().flatMap(departamento ->  departamento.getSociosSuscritos().stream()).toList());
        this.estadoEvento.add(new EstadoEvento(TipoEstadoEvento.PENDIENTE, LocalDateTime.now(), "Recien agregado"));
    }

    public void finalizar() {
    }

    public void cancelar() {
    }

    public void confirmar(Socio socio) {
    }

    public void invitar(Socio socio) {
    }

    public EstadoEvento estadoActual(){
        return this.estadoEvento.get(this.estadoEvento.size()-1);
    }

    public void addDepartamento(Departamento departamento){
        getDepartamentos().add(departamento);
        getInvitados().addAll(departamento.getSociosSuscritos());
    }
    public void addDepartamentos(List<Departamento> departamentos){
        getDepartamentos().addAll(departamentos);
        getInvitados().addAll(departamentos.stream().flatMap(departamento ->  departamento.getSociosSuscritos().stream()).toList());
    }
    //Esta función solamente esta para el SEED
    public void agregarEstado(EstadoEvento estadoEvento){
        getEstadoEvento().add(estadoEvento);
    }
    //Esta función solamente esta para el SEED
    public void agregarInscripto(Inscripto inscripto){
        getInscriptos().add(inscripto);
    }
}

