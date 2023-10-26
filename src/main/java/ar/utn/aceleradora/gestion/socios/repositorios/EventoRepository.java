package ar.utn.aceleradora.gestion.socios.repositorios;

import ar.utn.aceleradora.gestion.socios.modelos.evento.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

//@Repository


public interface EventoRepository extends JpaRepository<Evento, Long> {

}
