package ar.utn.aceleradora.gestion.socios.modelos.departamento;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.evento.Evento;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotNull
    @NotBlank(message = "El nombreCategoria no puede estar vacío")
    private String nombre;

    //@ManyToMany(mappedBy = "categorias")
    //private List<Socio> socios;


    //@ManyToOne
    //@JoinColumn(name = "idDepartamento")
    //private Departamento departamentoPerteneciente;

    public Categoria() {
    }
    public Categoria( String nombre){
        this.nombre = nombre;
    }
}
