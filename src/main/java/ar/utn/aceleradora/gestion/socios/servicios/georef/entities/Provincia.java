package ar.utn.aceleradora.gestion.socios.servicios.georef.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Provincia{

    public int id;

    public String nombre;
}
