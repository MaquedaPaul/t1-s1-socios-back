package ar.utn.aceleradora.gestion.socios.modelos.membresia;



import ar.utn.aceleradora.gestion.socios.modelos.Socio;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Date;

@Setter
@Getter
@Entity
@Table
public class Membresia {
    @Id
    @GeneratedValue
    @OneToOne
    private Socio empresa;
    @Column
    private Date fechaInicio;
    @Column
    private Date fechaVto;
    @Column
    private int cuota;

    //private List<Factura> facturas;
    @Column
    private boolean cuotaPagada;

    public Membresia(Socio empresa, Date fechaInicio, Date fechaVto, int cuota) {
        this.empresa = empresa;
        this.fechaInicio = fechaInicio;
        this.fechaVto = fechaVto;
        this.cuota = cuota;
        this.cuotaPagada = false; // Suponemos que al dar de alta, la cuota aún no se ha pagado
    }

    public void pagarCuota() {
        this.cuotaPagada = true;
    }
}
