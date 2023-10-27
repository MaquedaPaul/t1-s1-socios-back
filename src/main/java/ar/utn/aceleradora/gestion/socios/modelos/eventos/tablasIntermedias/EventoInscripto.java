package ar.utn.aceleradora.gestion.socios.modelos.eventos.tablasIntermedias;

import ar.utn.aceleradora.gestion.socios.modelos.eventos.Evento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.Inscripto;
import jakarta.persistence.*;

@Entity
@Table(name = "evento_inscripto")
public class EventoInscripto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "evento_id")
    private Evento evento;

    @ManyToOne
    @JoinColumn(name = "inscripto_id")
    private Inscripto inscripto;
}
