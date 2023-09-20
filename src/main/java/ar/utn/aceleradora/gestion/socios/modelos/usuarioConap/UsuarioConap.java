package ar.utn.aceleradora.gestion.socios.modelos.usuarioConap;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioEmpresa;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioPlenario;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import ar.utn.aceleradora.gestion.socios.modelos.informe.Informe;
import ar.utn.aceleradora.gestion.socios.modelos.membresia.Membresia;
import ar.utn.aceleradora.gestion.socios.modelos.registros.Registro;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table
public class UsuarioConap {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String nombre;
    @Column
    private String apellido;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private List<Socio> socios;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idUsuario")
    private List<Departamento> departamentos;

     @OneToMany(cascade = CascadeType.ALL)
     @JoinColumn(name = "idUsuario")
    private List <Informe> informes;

    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "idUsuario")
    //private List<Registro> registros;


public UsuarioConap(String nombre,String apellido, List<Socio> socios, List<Departamento> departamentos,List <Informe> informes/*,List<Registro> registros*/){

    this.nombre = nombre;
    this.apellido = apellido;
    this.socios = socios;
    this.departamentos = departamentos;
    this.informes = informes;
    //this.registros = registros;

      }
//funcion a llamar para hacer informes cuando llege info via json

public Informe GenerarInforme(Membresia membresia, TipoSocio categoria, Socio socio){
    return new Informe(membresia, categoria, socio);

}

/*
public void AgregarMiembroDpto(Socio socio, Departamento departamento){
    departamento.agregarSocio(socio);
}*/

}