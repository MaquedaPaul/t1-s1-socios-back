package ar.utn.aceleradora.gestion.socios.modelos.registros;

//import ar.utn.aceleradora.gestion.socios.modelos.Socio;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import jakarta.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name="evento")
@Entity
@Getter@Setter
public class Registro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String evento;

    
    @ManyToMany( fetch = FetchType.LAZY)
    @JoinTable(name = "Socio_x_evento",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id")
    )
    private List<Socio> socio;
    @Column
    private String participacion;


public Registro(String eventoR, Socio socioR, String participacionr){
    this.evento=eventoR;
    this.participacion = participacionr;
    this.socio = (List<Socio>) socioR;
}

}
