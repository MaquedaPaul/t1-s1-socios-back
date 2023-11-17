package ar.utn.aceleradora.gestion.socios.modelos.reservas;

import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "espaciosFisicos")
@Getter
public class EspacioFisico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Setter
    @OneToOne
    @JoinColumn(name = "id_ubicacion")
    private Ubicacion ubicacion;

    @ManyToMany
    private List<Recurso> recursosTotales;

    public EspacioFisico(){
        this.recursosTotales = new ArrayList<>();
    }

    public EspacioFisico(String nombre, String descripcion) {
    }
}
