package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.modelos.membresia.Membresia;

import java.util.List;

public interface MembresiaService {
    List<Membresia> findAllMembresias();

    List<Membresia> guardarMembresia(Membresia membresia);
}
