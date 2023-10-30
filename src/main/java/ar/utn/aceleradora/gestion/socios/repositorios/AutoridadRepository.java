package ar.utn.aceleradora.gestion.socios.repositorios;



import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Autoridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutoridadRepository extends JpaRepository<Autoridad, Integer>{
}
