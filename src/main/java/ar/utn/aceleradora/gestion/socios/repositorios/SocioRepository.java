package ar.utn.aceleradora.gestion.socios.repositorios;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Categoria;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface SocioRepository extends JpaRepository<Socio, Integer> {
    List<Socio> findByCategoriasIn(List<Categoria> categorias, Pageable pageable);
    List<Socio> findByCategoriasInAndMembresia_FechaInicioBefore(List<Categoria> categorias, LocalDate fechaInicioMembresia, Pageable pageable);
    List<Socio> findByMembresia_FechaInicioBefore(LocalDate fecha, Pageable pageable);

    List<Socio> findByTipoSocioAndCategoriasInAndMembresia_FechaInicioBefore(TipoSocio tipoSocio ,List<Categoria> categorias, LocalDate fechaInicioMembresia, Pageable pageable);
    List<Socio> findByTipoSocio(TipoSocio tipoSocio, Pageable pageable);

    List<Socio> findByTipoSocioAndMembresia_FechaInicioBefore(TipoSocio tipoSocio, LocalDate fechaInicioMembresia, Pageable pageable);
    List<Socio> findByTipoSocioAndCategoriasIn(TipoSocio tipoSocio, List<Categoria> categoria, Pageable pageable);

    List<Socio> findByNombreContaining(String nombre, Pageable pageable);
}

