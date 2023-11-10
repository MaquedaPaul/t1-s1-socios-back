package ar.utn.aceleradora.gestion.socios.modelos.reservas;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "recursos")
@Getter
public class Recurso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
