package ar.utn.aceleradora.gestion.socios.modelos.departamento;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Etiqueta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idDepartamento")
    private Departamento departamentoPerteneciente;
    @Column
    private String nombreEtiqueta;

    @ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    @JoinTable(
            name = "Etiqueta_X_Socio",
            joinColumns = @JoinColumn(name = "idEtiqueta"),
            inverseJoinColumns = @JoinColumn(name = "idSocio")
    )
    private List<Socio> socios;


    public Etiqueta(Departamento departamento, String nombreEtiqueta){
        this.departamentoPerteneciente = departamento;
        this.nombreEtiqueta = nombreEtiqueta;
    }
}
