package ar.utn.aceleradora.gestion.socios.modelos;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.data.relational.core.sql.In;

@Entity
@Table(name = "departamento")
public class Departamento extends Persistence {
    @Temporal(TemporalType.DATE)
    @Column(name = "fechaBaja")
    @Setter @Getter
    private Date fechaBaja;

    @Column(name = "nombre")
    @Setter @Getter
    private String nombre;

    @Column(name = "descripcion")
    @Setter @Getter
    private String descripcion;

    @Column(name = "icono")
    @Setter @Getter
    private String icono;

    @OneToOne
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
    @Setter @Getter
    private Coordinacion CoordinacionDepartamental;

    public Departamento() { }

    public Departamento() {
        super();
    }

    public Departamento(){
        super();
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
}
