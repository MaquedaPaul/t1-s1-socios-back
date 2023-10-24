package ar.utn.aceleradora.gestion.socios.modelos.eventos;


import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter@Setter
public class Evento {

    private Integer id;

    private String nombre;

    private List <Socio> socios;

    public Evento() {
    }

    public Evento(String nombre, List<Socio> socios) {
        this.nombre = nombre;
        this.socios = socios;
    }

}
