package ar.utn.aceleradora.gestion.socios.modelos.ubicacion;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name="ubicacion")
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String direccion;
    @Column
    private String piso;
    @Column
    private String departamento;
    @Column
    private String localidad;
    @Column
    private String provincia;
    @Column
    private String pais;

    public Ubicacion(String direccion,String piso,String departamento,String localidad,String provincia,String pais){

        this.direccion = direccion;
        this.piso=piso;
        this.departamento = departamento;
        this.localidad = localidad;
        this.provincia = provincia;
        this.pais = pais;
    }
}
