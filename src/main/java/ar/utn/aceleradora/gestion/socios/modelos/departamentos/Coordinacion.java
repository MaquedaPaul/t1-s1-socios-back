package ar.utn.aceleradora.gestion.socios.modelos.departamentos;

import ar.utn.aceleradora.gestion.socios.converters.LocalDateTimeAttributeConverter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;


@Getter
@Entity
@Table(name = "coordinaciones")
public class Coordinacion{

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

    @Column(name = "descripcion", length = 1000)
    @Setter
    private String descripcion;

    @Column(name = "icono")
    @Setter
    private String icono;

    @Column(name = "jerarquia")
    @Setter
    private int jerarquia;

    @OneToOne
    @JoinColumn(name = "id_autoridad", referencedColumnName = "id")
    @Setter
    private Autoridad autoridad;

    @JsonManagedReference
    @OneToMany(mappedBy = "coordinacionDepartamental", cascade = CascadeType.ALL)
    @Setter
    private List<Departamento> departamentos;

    public Coordinacion() {}

    public Coordinacion(String nombre, String descripcion, String icono, int jerarquia, Autoridad autoridad) {
        //this.fechaBaja = fechaBaja;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icono = icono;
        this.jerarquia = jerarquia;
        this.autoridad = autoridad;
        this.departamentos = new ArrayList<>();
    }

    public void agregarDepartamento(Departamento departamento) {
        this.departamentos.add(departamento);
        departamento.setCoordinacionDepartamental(this);
    }
    public void eliminarDepartamento(Departamento departamento) {
        this.departamentos.remove(departamento);
        departamento.setCoordinacionDepartamental(null);
    }
}

