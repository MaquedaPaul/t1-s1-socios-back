package ar.utn.aceleradora.gestion.socios.repositorios.eventos;

import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.Inscripto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscriptoRepository extends JpaRepository<Inscripto, Integer> {
}
