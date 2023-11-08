package ar.utn.aceleradora.gestion.socios.modelos.socios;

import ar.utn.aceleradora.gestion.socios.modelos.imagen.Imagen;
import ar.utn.aceleradora.gestion.socios.modelos.socios.membresia.MembresiaParticular;
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
    @JoinTable(
            name = "socios_categorias",
            joinColumns = @JoinColumn(name = "socio_id"),
            inverseJoinColumns = @JoinColumn(name = "categorias_id")
    )
    private List<Categoria> categorias;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_ubicacion", referencedColumnName = "id")
    private Ubicacion ubicacion;

    @JsonManagedReference
    @OneToMany(mappedBy = "socio", cascade = {CascadeType.REMOVE, CascadeType.REFRESH})
    private List<MembresiaParticular> membresias;

    @OneToOne
    @JoinColumn(name = "id_imagen", referencedColumnName = "id")
    private Imagen imagen;

    public Socio() {
        this.categorias = new ArrayList<>();
    }

    public Socio(String nombre, String nombrePresidente, String cuit, TipoSocio tipoSocio, String telefono, String mail, Imagen imagen) {
        this.nombre = nombre;
        this.nombrePresidente = nombrePresidente;
        this.cuit = cuit;
        this.tipoSocio = tipoSocio;
        this.telefono = telefono;
        this.mail = mail;
        this.imagen = imagen;
        this.categorias = new ArrayList<>();
        this.membresias = new ArrayList<>();
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
