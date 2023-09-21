package ar.utn.aceleradora.gestion.socios.modelos.membresia;



import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioEmpresa;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.util.Date;

@Setter
@Getter
@Entity
@Table
public class Membresia {
    @Id
    @GeneratedValue
    private Integer id;
    @OneToOne
    @JoinColumn(name = "id")
    private SocioEmpresa empresa;
    @Column
    private LocalDate fechaInicio;
    @Column
    private LocalDate fechaVto;
    @Column
    private int cuota;

    //private List<Factura> facturas;
    @Column
    private boolean cuotaPagada;

    public Membresia(SocioEmpresa empresa, LocalDate fechaInicio, LocalDate fechaVto, int cuota) {
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
