package ar.utn.aceleradora.gestion.socios.repositorios.socios;

import ar.utn.aceleradora.gestion.socios.modelos.socios.membresia.Membresia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembresiaRepository extends JpaRepository<Membresia, Integer> {
}
