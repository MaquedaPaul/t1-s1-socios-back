package ar.utn.aceleradora.gestion.socios.repositorios;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.DepartamentoAutoridad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartamentoAutoridadRepository extends JpaRepository<DepartamentoAutoridad, Integer>{
    void deleteById_departamentoAndId_autoridad(
            @Param("id_departamento") int idDepto,
            @Param("id_autoridad") int idAutoridad);
}
