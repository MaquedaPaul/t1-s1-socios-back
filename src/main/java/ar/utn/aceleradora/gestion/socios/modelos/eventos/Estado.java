package ar.utn.aceleradora.gestion.socios.modelos.eventos;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoEvento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "estados")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "tipoEvento")
    private TipoEvento tipoEvento;

    @Column(name = "fecha")
    private Date fecha;

    @Column(name = "motivo")
    private String motivo;

    public Estado() {
    }

    public Estado(Integer id, TipoEvento tipoEvento, Date fecha, String motivo) {
        this.id = id;
        this.tipoEvento = tipoEvento;
        this.fecha = fecha;
        this.motivo = motivo;
    }
}