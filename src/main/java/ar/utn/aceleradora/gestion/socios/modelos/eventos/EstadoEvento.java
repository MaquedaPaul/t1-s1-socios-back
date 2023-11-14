package ar.utn.aceleradora.gestion.socios.modelos.eventos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Setter
@Getter
@Entity
@Table(name = "estados")
public class EstadoEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipo_estado_evento")
    @Enumerated(EnumType.STRING)
    private TipoEstadoEvento tipoEstadoEvento;

    @Column(name = "fecha")
    private LocalDateTime fechaYHora;

    @Column(name = "motivo")
    private String motivo;

    public EstadoEvento() {
    }

    public EstadoEvento(TipoEstadoEvento tipoEstadoEvento, LocalDateTime fechaYHora, String motivo) {
        this.tipoEstadoEvento = tipoEstadoEvento;
        this.fechaYHora = fechaYHora;
        this.motivo = motivo;
    }


    public EstadoEvento(TipoEstadoEvento tipoEstadoEvento, LocalDateTime fechaYHora, String motivo, LocalTime horaAleatoria) {
    }
}