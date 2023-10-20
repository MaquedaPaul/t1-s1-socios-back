package ar.utn.aceleradora.gestion.socios.modelos.empresa;

import ar.utn.aceleradora.gestion.socios.modelos.imagen.Imagen;
import ar.utn.aceleradora.gestion.socios.modelos.membresia.MembresiaParticular;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "socios")
@Getter @Setter
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "nombre_presidente")
    private String nombrePresidente;

    @Column(length = 11, name = "cuit")
//    @NotBlank(message = "El cuit no puede estar vacío")
//    @Pattern(regexp = "^[0-9\\-]+$", message = "El CUIT debe contener solo números y guiones.")
//    @Size(min =11, max = 11, message = "Error en la cantidad de caracteres del CUIT.")
    private String cuit;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_socio")
    private TipoSocio tipoSocio;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "mail")
    @Email(message = "El mail es inválido ")
    private String mail;

    @ManyToMany(cascade = CascadeType.MERGE)
    @Setter @Getter
    private List<Categoria> categorias;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ubicacion", referencedColumnName = "id")
    private Ubicacion ubicacion;

    @JsonManagedReference
    @OneToMany(mappedBy = "socio", cascade = CascadeType.REMOVE)
    private List<MembresiaParticular> membresias;

//    @OneToOne
//    @JoinColumn(name = "id_imagen", referencedColumnName = "id")
//    private Imagen imagen;

    public Socio() {
        this.categorias = new ArrayList<>();
    }

    public Socio(String nombre, String cuit,  TipoSocio tipoSocio, String telefono, String mail ,Ubicacion ubicacion) {
        this.nombre = nombre;
        this.cuit = cuit;
        this.tipoSocio = tipoSocio;
        this.categorias = new ArrayList<>();
        this.telefono = telefono;
        this.mail = mail;
        this.ubicacion = ubicacion;
        this.membresias = new ArrayList<>();
    }
    public Socio(String nombre, String nombrePresidente, String cuit, TipoSocio tipoSocio, String telefono, String mail) {
        this.nombre = nombre;
        this.nombrePresidente = nombrePresidente;
        this.cuit = cuit;
        this.tipoSocio = tipoSocio;
        this.telefono = telefono;
        this.mail = mail;
//        this.imagen = imagen;
        this.categorias = new ArrayList<>();
        this.membresias = new ArrayList<>();
        this.ubicacion = ubicacion;
    }

    public Socio(String nombre, String nombrePresidente, String cuit, TipoSocio tipoSocio, String telefono, String mail, Ubicacion ubicacion) {
        this.nombre = nombre;
        this.nombrePresidente = nombrePresidente;
        this.cuit = cuit;
        this.tipoSocio = tipoSocio;
        this.telefono = telefono;
        this.mail = mail;
//        this.imagen = imagen;
        this.categorias = new ArrayList<>();
        this.membresias = new ArrayList<>();
        this.ubicacion = ubicacion;
    }

    public void agregarMembresia(MembresiaParticular membresiaParticular) {
        membresiaParticular.setSocio(this);
        membresias.add(membresiaParticular);
    }
    public void agregarCategoria(Categoria categoria) {
        categorias.add(categoria);
    }
    public void agregarCategoria(List<Categoria> categoria) {
        categorias.addAll(categoria);
    }
}
