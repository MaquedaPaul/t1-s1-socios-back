package ar.utn.aceleradora.gestion.socios.modelos.reservas;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "recursosSolicitados")
@Getter
public class RecursoSolicitado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
