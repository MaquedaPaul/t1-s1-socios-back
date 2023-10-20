package ar.utn.aceleradora.gestion.socios.repositorios;



import ar.utn.aceleradora.gestion.socios.modelos.Autoridad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoridadRepository extends JpaRepository<Autoridad, Integer>{
    
}
