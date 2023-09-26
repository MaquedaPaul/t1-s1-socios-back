package ar.utn.aceleradora.gestion.socios.modelos.departamento;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.evento.Evento;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "idDepartamento")
    private Departamento departamentoPerteneciente;
    @Column
    private String nombre;
    //@ManyToMany(mappedBy = "categorias")
    //private List<Socio> socios;

    public Categoria() {
    }
    public Categoria(Departamento departamento, String nombre){
        this.departamentoPerteneciente = departamento;
        this.nombre = nombre;
    }
}
