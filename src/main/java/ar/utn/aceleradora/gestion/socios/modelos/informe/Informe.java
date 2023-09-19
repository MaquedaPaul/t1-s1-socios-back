package ar.utn.aceleradora.gestion.socios.modelos.informe;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioEmpresa;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioPlenario;
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
    private SocioEmpresa socioEmpresa;

    @ManyToOne(cascade = CascadeType.ALL, fetch =  FetchType.LAZY)
    private SocioPlenario socioPlenario;




    public Informe(Membresia membresiaI, TipoSocio categoriaI, SocioEmpresa socioEmpresa,SocioPlenario socioPlenario){
        this.membresia = membresiaI;
        this.categoria = categoriaI;
        this.socioEmpresa = socioEmpresa;
        this.socioPlenario = socioPlenario;
    }
}