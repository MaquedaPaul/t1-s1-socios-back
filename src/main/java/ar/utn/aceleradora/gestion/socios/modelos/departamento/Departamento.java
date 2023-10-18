package ar.utn.aceleradora.gestion.socios.modelos.departamento;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;

@Getter@Setter
public class Departamento {

    private Integer id;

    private String nombre;

    public Departamento() {
    }

    public Departamento(String nombreDepto){
        this.nombre = nombreDepto;

    }
}
