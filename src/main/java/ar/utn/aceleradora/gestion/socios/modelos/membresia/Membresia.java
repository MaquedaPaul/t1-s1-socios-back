package ar.utn.aceleradora.gestion.socios.modelos.membresia;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Setter @Getter
@Entity
@Table(name = "membresias")
public class Membresia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter @Setter
    private String nombre;

    @Getter @Setter
    @Column(name = "duracion_meses")
    private Integer duracionMeses;

    public Membresia(){
    }

    public Membresia(String nombre, Integer duracionMeses) {
        this.nombre = nombre;
        this.duracionMeses = duracionMeses;
    }
}
