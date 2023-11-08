package ar.utn.aceleradora.gestion.socios.repositorios.departamentos;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Coordinacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoorDepartamentoRepository extends JpaRepository<Coordinacion, Integer>{
    
}
