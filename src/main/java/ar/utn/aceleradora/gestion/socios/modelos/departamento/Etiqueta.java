package ar.utn.aceleradora.gestion.socios.modelos.departamento;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    private Departamento departamentoPerteneciente;
    @Column
    private String nombreEtiqueta;

    public Etiqueta(Departamento departamento, String nombreEtiqueta){
        this.departamentoPerteneciente = departamento;
        this.nombreEtiqueta = nombreEtiqueta;
    }
}
