package ar.utn.aceleradora.gestion.socios.modelos.reservas;

import java.security.SecureRandom;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_reserva")
    private List<RecursoSolicitado> recursosSolicitados;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_reserva")
    private List<EstadoReserva> estadosReserva;

    @Setter(AccessLevel.NONE)
    @Column(name = "codigo_seguimiento")
    private String codigoDeSeguimiento;

    public Reserva(){
        this.recursosSolicitados = new ArrayList<>();
        this.estadosReserva = new ArrayList<>();
        estadosReserva.add(new EstadoReserva(TipoEstadoReserva.PENDIENTE, LocalDateTime.now(),"Pendiente de aprobación"));
    }

    public Reserva(String descripcion,
                   LocalDate fecha, LocalTime horaInicio, LocalTime horaFin, String nombreReservante, String mailReservante, String telefonoReservante) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.nombreReservante = nombreReservante;
        this.mailReservante = mailReservante;
        this.telefonoReservante = telefonoReservante;
        this.estadosReserva = new ArrayList<>();
        this.agregarNuevoEstado(new EstadoReserva(TipoEstadoReserva.PENDIENTE, LocalDateTime.now(), "Pendiente de aprobación"));
    }

    public void generarCodigoSeguimiento(){
        Integer id = this.getId();
        String idString = id.toString();
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        SecureRandom random = new SecureRandom();
        StringBuilder codigo = new StringBuilder();

        for (int i = 0; i < 11; i++) {
            int indice = random.nextInt(caracteres.length());
            codigo.append(caracteres.charAt(indice));
        }
        codigo.append(idString);
        this.codigoDeSeguimiento = codigo.toString();
    }

    public void agregarNuevoEstado(EstadoReserva nuevoEstado) {
        this.estadosReserva.add(nuevoEstado);
    }
}