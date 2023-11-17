package ar.utn.aceleradora.gestion.socios.repositorios.reservas;

import ar.utn.aceleradora.gestion.socios.modelos.reservas.EspacioFisico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspacioFisicoRepository extends JpaRepository<EspacioFisico, Integer> {

}
