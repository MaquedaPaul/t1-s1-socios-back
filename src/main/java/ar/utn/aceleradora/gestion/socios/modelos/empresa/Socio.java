package ar.utn.aceleradora.gestion.socios.modelos.empresa;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Etiqueta;
import ar.utn.aceleradora.gestion.socios.modelos.evento.Evento;
import ar.utn.aceleradora.gestion.socios.modelos.membresia.Membresia;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

import static ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio.SOCIO_EMPRESA;

@Entity
@Getter@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoSocio")
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String nombreEmpresa;

    private TipoSocio categoria;
    @Column
    private Boolean activo;
    @Column
    private Integer telefono;
    @Column
    private String mail;



    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name = "idSocio")
    private Ubicacion ubicacion;

    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "idSocio")
    private List<Etiqueta> etiquetas;

    @OneToMany(cascade = CascadeType.ALL)
    //@JoinColumn(name = "idSocio")
    private List<Evento> evento;

    @OneToOne(cascade = CascadeType.ALL)
   // @JoinColumn(name = "idSocio")
    private Membresia membresia;

    public Socio() {
    }

    public Socio(String nombreEmpresa, TipoSocio categoria, Integer telefono, String mail ,Ubicacion ubicacion) {
        this.nombreEmpresa = nombreEmpresa;
        this.categoria = categoria;
        this.activo = true; // Suponemos que al dar de alta, el socio está activo por defecto
        this.telefono = telefono;
        this.mail = mail;
        this.ubicacion = ubicacion;
    }
/*
    public void recibirEtiqueta(Etiqueta etiqueta){
        this.etiquetas.add(etiqueta);
    }
*/
}
