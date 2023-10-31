package ar.utn.aceleradora.gestion.socios.modelos.eventos;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "estados")
public class EstadoEvento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipoEvento")
    @Enumerated(EnumType.STRING)
    private TipoEvento tipoEvento;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "motivo")
    private String motivo;

    public EstadoEvento() {
    }

    public EstadoEvento(TipoEvento tipoEvento, LocalDate fecha, String motivo) {
        this.tipoEvento = tipoEvento;
        this.fecha = fecha;
        this.motivo = motivo;
    }

    public EstadoEvento(TipoEvento tipoEvento, LocalDateTime now, String recienInscripto) {
    }
}