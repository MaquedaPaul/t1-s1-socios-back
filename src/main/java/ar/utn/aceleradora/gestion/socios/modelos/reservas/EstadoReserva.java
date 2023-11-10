package ar.utn.aceleradora.gestion.socios.modelos.reservas;


import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "estadosReservas")
@Getter
public class EstadoReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
