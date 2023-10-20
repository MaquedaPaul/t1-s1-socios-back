package ar.utn.aceleradora.gestion.socios.modelos.empresa;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "categorias")
@Getter
@Setter
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @NotNull
//    @NotBlank(message = "El nombreCategoria no puede estar vacío")
    @Column(name = "nombre")
    private String nombre;

    public Categoria() {
    }
    public Categoria( String nombre){
        this.nombre = nombre;
    }
}
