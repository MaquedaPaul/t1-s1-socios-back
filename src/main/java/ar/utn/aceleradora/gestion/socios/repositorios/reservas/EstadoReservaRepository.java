package ar.utn.aceleradora.gestion.socios.repositorios.reservas;

import ar.utn.aceleradora.gestion.socios.modelos.reservas.EstadoReserva;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.Recurso;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstadoReservaRepository extends JpaRepository<EstadoReserva, Integer> {
}
