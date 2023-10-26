package ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos;

import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.EstadoInscripto;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;

import java.util.List;

public class Inscripto {
    private String nombre;
    private String apellido;
    private String trabajo;
    private Socio socioRepresentado;
    private List<EstadoInscripto> estados;
    private String mail;
}
