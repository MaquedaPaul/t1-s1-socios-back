package ar.utn.aceleradora.gestion.socios.modelos;

import ar.utn.aceleradora.gestion.socios.converters.LocalDateTimeAttributeConverter;
import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "coordinaciones")
public class Coordinacion{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "fechaBaja")
    @Setter @Getter
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    private LocalDateTime fechaBaja;

    @Column(name = "nombre")
    @Setter @Getter
    private String nombre;

    @Column(name = "descripcion")
    @Setter @Getter
    private String descripcion;

    @Column(name = "icono")
    @Setter @Getter
    private String icono;

    @Column(name = "jerarquia")
    @Setter @Getter
    private int jerarquia;

    @OneToOne
    @JoinColumn(name = "id_autoridad", referencedColumnName = "id")
    @Setter @Getter
    private Autoridad autoridad;

    @JsonBackReference
    @OneToMany(mappedBy = "CoordinacionDepartamental", cascade = CascadeType.ALL)
    @Setter @Getter
    private List<Departamento> departamentos;

    public Coordinacion() {}

    public Coordinacion(LocalDateTime fechaBaja, String nombre, String descripcion, String icono, int jerarquia, Autoridad autoridad) {
        this.fechaBaja = fechaBaja;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icono = icono;
        this.jerarquia = jerarquia;
        this.autoridad = autoridad;
    }

    public Coordinacion(List<Departamento> departamentos) {
        this.departamentos = new ArrayList<>();
    }

    public void agregarDepartamento(Departamento departamento) {
       /* this.departamentos.add(departamento);
        departamento.setCoordinacion(this);*/
    }

    public void eliminarDepartamento(Departamento departamento) {
        /*this.departamentos.remove(departamento);
        departamento.setCoordinacion(null);*/
    }
}

