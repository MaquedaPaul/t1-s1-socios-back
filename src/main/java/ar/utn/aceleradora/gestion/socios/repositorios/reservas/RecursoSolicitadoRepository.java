package ar.utn.aceleradora.gestion.socios.repositorios.reservas;

import ar.utn.aceleradora.gestion.socios.modelos.reservas.RecursoSolicitado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecursoSolicitadoRepository extends JpaRepository<RecursoSolicitado, Integer> {
}
