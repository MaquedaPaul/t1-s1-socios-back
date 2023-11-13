package ar.utn.aceleradora.gestion.socios.modelos.reservas;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reservas")
@Getter
@Setter
public class Reserva {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_departamento_asociado")
    private Departamento departamentoAsociado;

    @ManyToOne
    @JoinColumn(name = "id_espacio_fisico")
    private EspacioFisico espacioFisico;

    @Column(name = "descripcion")
    private String descripcion;


    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "hora_inicio")
    private LocalTime horaInicio;

    @Column(name = "hora_fin")
    private LocalTime horaFin;

    @Column(name = "nombre_reservante")
    private String nombreReservante;

    @Column(name = "apellido_reservante")
    private String apellidoReservante;

    @Column(name = "mail_reservante")
    private String mailReservante;

    @Column(name = "telefono_reservante")
    private String telefonoReservante;

    @OneToMany
    @JoinColumn(name = "id_reserva")
    private List<RecursoSolicitado> recursosSolicitados;

    @OneToMany
    @JoinColumn(name = "id_reserva")
    private List<EstadoReserva> estadosReserva;

    @Setter(AccessLevel.NONE)
    @Column(name = "codigo_seguimiento")
    private String codigoDeSeguimiento;

    public Reserva(){
        this.recursosSolicitados = new ArrayList<>();
        this.estadosReserva = new ArrayList<>();
    }
}
