package ar.utn.aceleradora.gestion.socios.modelos;

import ar.utn.aceleradora.gestion.socios.converters.LocalDateTimeAttributeConverter;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
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
@Table(name = "departamento")
public class Departamento{

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


    @Setter @Getter
    private Integer jerarquia;//El IDE me tira waring con el Integer en OneToOne

    @ManyToMany
    @JoinTable(
            name = "departamento_autoridad",
            joinColumns = @JoinColumn(name = "departamento_id"),
            inverseJoinColumns = @JoinColumn(name = "autoridad_id")
    )
    @Setter @Getter
    private List<Autoridad> autoridades;

    @ManyToMany
    @JoinTable(
            name = "departamento_socio",
            joinColumns = @JoinColumn(name = "departamento_id"),
            inverseJoinColumns = @JoinColumn(name = "socio_id")
    )
    @Setter @Getter
    private List<Socio> sociosSuscritos;

    @ManyToOne
    @JoinColumn(name = "id_cordinacion", referencedColumnName = "id")
    @Setter @Getter
    private Coordinacion CoordinacionDepartamental;


    public Departamento(){
        this.sociosSuscritos = new ArrayList<>();
        this.autoridades = new ArrayList<>();
    }
    public Departamento(String id, String nombre, String descripcion, String icono, Integer jerarquia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icono = icono;
        this.jerarquia = jerarquia;
    }

    public void suscribirSocio(Socio unSocio) {
        /*sociosSuscritos.add(unSocio);
        unSocio.getDepartamentosSuscritos().add(this);*/
    }

    public void desuscribirSocio(Socio unSocio) {
        /*sociosSuscritos.remove(unSocio);
        unSocio.getDepartamentosSuscritos().remove(this);*/
    }

    public void agregarAutoridades(Autoridad autoridad){
        this.autoridades.add(autoridad);
    }
    public void agregarAutoridades(List<Autoridad> autoridades){
        this.autoridades.addAll(autoridades);

    }
}
