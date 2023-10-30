package ar.utn.aceleradora.gestion.socios.modelos.departamentos;

import ar.utn.aceleradora.gestion.socios.converters.LocalDateTimeAttributeConverter;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "autoridades")
public class Autoridad{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "fechaBaja")
    @Setter
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime fechaBaja;

    @Column(name = "nombre")
    @Setter
    private String nombre;

    @Column(name = "apellido")
    @Setter
    private String apellido;

    @Column(name = "fotoPerfil")
    @Setter
    private String fotoPerfil;

    @Column(name = "puesto")
    @Setter
    private String puesto;

    public Autoridad() {}

    public Autoridad(String nombre, String apellido, String fotoPerfil, String puesto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fotoPerfil = fotoPerfil;
        this.puesto = puesto;
    }
}