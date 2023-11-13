package ar.utn.aceleradora.gestion.socios.modelos.reservas;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "recursosSolicitados")
@Getter
@Setter
public class RecursoSolicitado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "id_recurso")
    private Recurso recurso;

    @Column(name = "cantidad")
    private int cantidad;

    @Column(name = "aprobado")
    private Boolean aprobado;

    public RecursoSolicitado(){
    }
}
