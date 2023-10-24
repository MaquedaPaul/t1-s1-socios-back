package ar.utn.aceleradora.gestion.socios.modelos.departamentos;

import ar.utn.aceleradora.gestion.socios.converters.LocalDateTimeAttributeConverter;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "departamento")
public class Departamento{

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

    @Column(name = "descripcion", length =  2000)
    @Setter @Getter
    private String descripcion;

    @Column(name = "icono")
    @Setter @Getter
    private String icono;

    @Setter @Getter
    private Integer jerarquia;//El IDE me tira waring con el Integer en OneToOne

    @ManyToMany
    @Setter @Getter
    private List<Autoridad> autoridades;

    @ManyToMany
    @Setter @Getter
    private List<Socio> sociosSuscritos;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "id_coordinacion")
    @Setter @Getter
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
