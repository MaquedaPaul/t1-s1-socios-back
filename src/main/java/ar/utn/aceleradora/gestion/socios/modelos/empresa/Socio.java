package ar.utn.aceleradora.gestion.socios.modelos.empresa;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter@Setter
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipoSocio")
public class Socio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
