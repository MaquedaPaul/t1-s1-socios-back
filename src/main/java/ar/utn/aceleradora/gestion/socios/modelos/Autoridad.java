package ar.utn.aceleradora.gestion.socios.modelos;

import ar.utn.aceleradora.gestion.socios.converters.LocalDateTimeAttributeConverter;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "autoridades")
public class Autoridad{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private Integer id;


    @Column(name = "fechaBaja")
    @Setter @Getter
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime fechaBaja;

    @Column(name = "nombre")
    @Setter @Getter
    private String nombre;

    @Column(name = "apellido")
    @Setter @Getter
    private String apellido;

    @Column(name = "fotoPerfil")
    @Setter @Getter
    private String fotoPerfil;

    @Column(name = "puesto")
    @Setter @Getter
    private String puesto;

    public Autoridad() {}

    public Autoridad(String nombre, String apellido, String fotoPerfil, String puesto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fotoPerfil = fotoPerfil;
        this.puesto = puesto;
    }
}