package ar.utn.aceleradora.gestion.socios.modelos.empresa;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Categoria;
import ar.utn.aceleradora.gestion.socios.modelos.evento.Evento;
import ar.utn.aceleradora.gestion.socios.modelos.membresia.Membresia;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
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

    @NotNull(message = "El nombre no puede ser nulo")
    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    private String nombrePresidente;

    @Column(length = 13)
    @NotBlank(message = "El cuit no puede estar vacío")
    @Pattern(regexp = "^[0-9\\-]+$", message = "El CUIT debe contener solo números y guiones.")
    @Size(min = 13, max = 13, message = "Error en la cantidad de caracteres del CUIT.")
    private String cuit;


    @Enumerated(EnumType.STRING)
    private TipoSocio tipoSocio;


    private Boolean activo;

    @NotNull(message = "El telefono no puede ser nulo")
    @NotBlank(message = "El telefono no puede estar vacío")
    private String telefono;//Puede ser string

    @NotBlank(message = "El mail no puede estar vacío")
    @Email(message = "El mail es inválido ")
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

    public Socio(String nombre, String cuit,  TipoSocio tipoSocio, String telefono, String mail ,Ubicacion ubicacion) {
        this.nombre = nombre;
        this.cuit = cuit;
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
