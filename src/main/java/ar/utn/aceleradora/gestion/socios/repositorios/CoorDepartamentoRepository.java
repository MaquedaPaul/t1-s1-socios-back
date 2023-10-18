package ar.utn.aceleradora.gestion.socios.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoorDepartamentoRepository extends JpaRepository<CoorDepartamento, Integer>{
    
}
