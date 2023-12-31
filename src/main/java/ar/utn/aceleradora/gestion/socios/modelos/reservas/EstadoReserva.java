package ar.utn.aceleradora.gestion.socios.modelos.reservas;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Table(name = "estadosReservas")
@Getter
public class EstadoReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "estado_reserva")
    @Enumerated(EnumType.STRING)
    private TipoEstadoReserva estadoReserva;

    @Column(name = "fecha_y_hora")
    private LocalDateTime fechaYHora;

    @Column(name = "motivo")
    private String motivo;
    //private Usuario usuario;

    public EstadoReserva(){
    }

    public EstadoReserva(TipoEstadoReserva tipoEstadoReserva, String motivo){
        this.estadoReserva=tipoEstadoReserva;
        this.motivo = motivo;
        this.fechaYHora= LocalDateTime.now();
    }
    public EstadoReserva(TipoEstadoReserva estadoReserva, LocalDateTime fechaYHora, String motivo){
        this.estadoReserva = estadoReserva;
        this.fechaYHora = fechaYHora;
        this.motivo = motivo;
    }
}
