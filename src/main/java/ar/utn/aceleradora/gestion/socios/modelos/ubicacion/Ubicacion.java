package ar.utn.aceleradora.gestion.socios.modelos.ubicacion;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "ubicaciones")
public class Ubicacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "piso")
    private String piso;

    @Column(name = "departamento")
    private String departamento;

    @Column(name = "localidad")
    private String localidad;

    @Column(name = "provincia")
    private String provincia;



    public Ubicacion() {
    }

    public Ubicacion(String direccion,String piso,String departamento,String localidad,String provincia){

        this.direccion = direccion;
        this.piso = piso;
        this.departamento = departamento;
        this.localidad = localidad;
        this.provincia = provincia;

    }
}
