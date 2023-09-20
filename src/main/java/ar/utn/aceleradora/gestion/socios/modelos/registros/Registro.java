package ar.utn.aceleradora.gestion.socios.modelos.registros;

//import ar.utn.aceleradora.gestion.socios.modelos.Socio;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioEmpresa;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioPlenario;
import jakarta.persistence.*;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
    @JoinTable(name = "SocioPlenario_x_evento",
            joinColumns = @JoinColumn(name = "idRegistro"),
            inverseJoinColumns = @JoinColumn(name = "idPlenario")
    )
    private List<SocioPlenario> socioPlenario;

    @ManyToMany( fetch = FetchType.LAZY)
    @JoinTable(name = "SocioEmpresa_x_evento",
            joinColumns = @JoinColumn(name = "idRegistro"),
            inverseJoinColumns = @JoinColumn(name = "idEmpresa")
    )
    private List<SocioEmpresa> socioEmpresa;

    @Column
    private String participacion;


public Registro(String eventoR, List<SocioPlenario> socioP, List<SocioEmpresa> socioE, String participacionr){
    this.evento=eventoR;
    this.participacion = participacionr;
    this.socioPlenario = socioP;
    this.socioEmpresa = socioE;
}

}
