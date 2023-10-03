package ar.utn.aceleradora.gestion.socios.servicios.georef.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Provincia{
    @Column(name = "Id_georef")
    public int id;
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    public long idp;
    @Column
    public String nombre;
}
