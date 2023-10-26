package ar.utn.aceleradora.gestion.socios.servicios.socios;

import ar.utn.aceleradora.gestion.socios.modelos.socios.membresia.Membresia;

import java.util.List;

public interface MembresiaService {
    List<Membresia> findAllMembresias();

    List<Membresia> guardarMembresia(Membresia membresia);
}
