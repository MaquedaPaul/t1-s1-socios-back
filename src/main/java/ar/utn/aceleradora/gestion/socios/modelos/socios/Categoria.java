package ar.utn.aceleradora.gestion.socios.modelos.socios;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;


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
