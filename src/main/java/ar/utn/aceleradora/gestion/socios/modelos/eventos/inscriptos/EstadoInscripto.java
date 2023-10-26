package ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@Entity
@Table(name = "estadosinscriptos")
public class EstadoInscripto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "estado")
    private TipoEstadoInscripto estado;

    @Column(name = "fechaYHora")
    private LocalDateTime fechaYHora;

    @Column(name = "motivo")
    private String motivo;
}
