package ar.utn.aceleradora.gestion.socios.modelos.empresa;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Categoria;
import ar.utn.aceleradora.gestion.socios.modelos.evento.Evento;
import ar.utn.aceleradora.gestion.socios.modelos.membresia.Membresia;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio.SOCIO_ADHERENTE;

@Entity
@Getter@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo")
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull@NotBlank
    private String nombre;

    private String nombrePresidente;

    @Enumerated(EnumType.STRING)
    private TipoSocio tipoSocio;


    private Boolean activo;

    @NotNull@NotBlank
    private String telefono;//Puede ser string

    @NotNull@Email
    private String mail;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "socio_categorias",
        joinColumns = @JoinColumn(name = "socio_id"),
        inverseJoinColumns = @JoinColumn(name = "categoria_id")
    )
    private List<Categoria> categorias;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JoinColumn(name = "idSocio")
    private Ubicacion ubicacion;

    @ManyToMany(mappedBy = "socios")
    private List<Evento> eventoPendiente;

    @OneToOne()
   // @JoinColumn(name = "idSocio")
    private Membresia membresia;

    public Socio() {

        this.categorias = new ArrayList<>();
        this.activo = true;
    }

    public Socio(String nombre, TipoSocio tipoSocio, String telefono, String mail ,Ubicacion ubicacion) {
        this.nombre = nombre;
        this.tipoSocio = tipoSocio;
        this.activo = true; // Suponemos que al dar de alta, el socio está activo por defecto
        this.categorias = new ArrayList<>();
        this.telefono = telefono;
        this.mail = mail;
        this.ubicacion = ubicacion;
    }

    public boolean isActivo() {
        return activo;
    }


}
