package ar.utn.aceleradora.gestion.socios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.utn.aceleradora.gestion.socios.modelos.SocioPlenario;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioPlenarioRepository extends JpaRepository<SocioPlenario, Integer> {
}
