package ar.utn.aceleradora.gestion.socios.repositorios.eventos;

import ar.utn.aceleradora.gestion.socios.modelos.eventos.Evento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EventoRepository extends JpaRepository<Evento, Integer> {
    Optional<Evento> findById(Integer id);
    Optional<Evento> findByUuid(UUID uuid);
}
