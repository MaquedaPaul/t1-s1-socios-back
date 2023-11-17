package ar.utn.aceleradora.gestion.socios.modelos.departamentos;

import ar.utn.aceleradora.gestion.socios.converters.LocalDateTimeAttributeConverter;
import com.fasterxml.jackson.annotation.*;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Table(name = "departamento")
public class Departamento{

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

    @Column(name = "descripcion", length =  2000)
    @Setter
    private String descripcion;

    @Column(name = "icono")
    @Setter
    private String icono;

    @Setter
    private Integer jerarquia;//El IDE me tira waring con el Integer en OneToOne

    @ManyToMany
    @Setter
    private List<Autoridad> autoridades;

    @ManyToMany(fetch = FetchType.EAGER)
    @Setter
    private List<Socio> sociosSuscritos;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_coordinacion")
    @Setter
    private Coordinacion coordinacionDepartamental;

    public Departamento(){
        this.sociosSuscritos = new ArrayList<>();
        this.autoridades = new ArrayList<>();
    }
    public Departamento(String nombre, String descripcion, String icono, Integer jerarquia) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.icono = icono;
        this.jerarquia = jerarquia;
        this.sociosSuscritos = new ArrayList<>();
        this.autoridades = new ArrayList<>();
    }

    public Departamento(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public void suscribirSocio(Socio unSocio) {
        sociosSuscritos.add(unSocio);
    }

    public void desuscribirSocio(Socio unSocio) {
        sociosSuscritos.remove(unSocio);
    }

    public void agregarAutoridades(Autoridad autoridad){
        this.autoridades.add(autoridad);
    }
    public void agregarAutoridades(List<Autoridad> autoridades){
        this.autoridades.addAll(autoridades);

    }

    public void removerAutoridades(Autoridad autoridad){
        this.autoridades.remove(autoridad);
    }

    public void removerSocio(Socio socio) {
        this.sociosSuscritos.remove(socio);
    }

    public void agregarSocios(List<Socio> socios) {
        this.sociosSuscritos.addAll(socios);
    }
}
