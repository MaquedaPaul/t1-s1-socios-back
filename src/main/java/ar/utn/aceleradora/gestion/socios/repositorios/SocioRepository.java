package ar.utn.aceleradora.gestion.socios.repositorios;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository

public interface SocioRepository extends JpaRepository<Socio, Integer>, JpaSpecificationExecutor<Socio> {
    Optional<Socio> findByNombre(String nombre);
}
