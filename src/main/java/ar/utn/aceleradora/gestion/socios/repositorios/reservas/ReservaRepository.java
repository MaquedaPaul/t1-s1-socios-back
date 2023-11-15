package ar.utn.aceleradora.gestion.socios.repositorios.reservas;

import ar.utn.aceleradora.gestion.socios.modelos.reservas.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Integer> {
    Reserva findByCodigoSeguimiento(String codigoSeguimiento);
}
