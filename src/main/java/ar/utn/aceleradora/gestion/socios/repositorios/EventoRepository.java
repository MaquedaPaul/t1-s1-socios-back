package ar.utn.aceleradora.gestion.socios.repositorios;

import ar.utn.aceleradora.gestion.socios.modelos.eventos.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

//@Repository


public interface EventoRepository extends JpaRepository<Evento, Integer> {
    Optional<Evento> findById(Integer id);
}
