package ar.utn.aceleradora.gestion.socios.repositorios;

import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SocioRepository extends JpaRepository<Socio, Integer> {
    Page<Socio> findAll(Pageable pageable);

}
