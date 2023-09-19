package ar.utn.aceleradora.gestion.socios.modelos.informe;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import ar.utn.aceleradora.gestion.socios.modelos.membresia.Membresia;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table

public class Informe {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    private Membresia membresia;

    @Enumerated(EnumType.STRING)
    private TipoSocio categoria;

    @ManyToOne(cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    private Socio socio;



    public Informe(Membresia membresiaI, TipoSocio categoriaI, Socio socioI){
        this.membresia = membresiaI;
        this.categoria = categoriaI;
        this.socio = socioI;
    }
}