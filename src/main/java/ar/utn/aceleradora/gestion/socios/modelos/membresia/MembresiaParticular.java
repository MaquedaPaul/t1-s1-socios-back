package ar.utn.aceleradora.gestion.socios.modelos.membresia;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "membresias_particulares")
public class MembresiaParticular {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @ManyToOne
    @JoinColumn(name = "id_membresia")
    @Getter @Setter
    private Membresia membresia;

    @Column(name = "fecha_inicio")
    @Getter @Setter
    private LocalDate fechaInicio;

    @Column(name = "value")
    @Getter @Setter
    private Double valor;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_socio")
    @Getter @Setter
    private Socio socio;

    boolean estaActiva(){
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.isAfter(fechaInicio) && fechaActual.isBefore(this.fechaFin());
    }

    public MembresiaParticular() {
    }

    LocalDate fechaFin(){
        return fechaInicio.plusMonths(this.membresia.getDuracionMeses());
    }

    public MembresiaParticular(Membresia membresia, LocalDate fechaInicio, Double valor) {
        this.membresia = membresia;
        this.fechaInicio = fechaInicio;
        this.valor = valor;
    }
}
