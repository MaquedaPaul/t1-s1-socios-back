package ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "estados_de_inscriptos")

public class EstadoInscripto {
    @Id
    @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "estado")
    @Enumerated(EnumType.STRING)
    @Getter
    private TipoEstadoInscripto estado;

    @Column(name = "fecha_y_hora", columnDefinition = "TIMESTAMP")
    @Getter @Setter
    private LocalDateTime fechaYHora;

    @Column(name = "motivo")
    @Getter @Setter
    private String motivo;

    public EstadoInscripto(TipoEstadoInscripto estado, LocalDateTime fechaYHora, String motivo){
        this.estado = estado;
        this.fechaYHora = fechaYHora;
        this.motivo = motivo;
    }

    public EstadoInscripto(){
    }
}
