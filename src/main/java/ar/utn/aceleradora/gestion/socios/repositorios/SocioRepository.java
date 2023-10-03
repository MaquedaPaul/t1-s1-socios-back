package ar.utn.aceleradora.gestion.socios.repositorios;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Categoria;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
    List<Socio> findByTipoSocioAndNombreContaining(TipoSocio tipoSocio, String nombre, Pageable pageable);
    List<Socio> findByActivo(Boolean activo ,Pageable pageable);
    List<Socio> findByTipoSocioAndActivo(TipoSocio tipoSocio, Boolean activo, Pageable pageable);
    List<Socio> findByCategoriasInAndActivo(List<Categoria> categorias, Boolean activo, Pageable pageable);
    Optional<Socio> findByNombre(String nombre);
    Long countByCategoriasIn(List<Categoria> categorias);
    Long countByCategoriasInAndMembresia_FechaInicioBefore(List<Categoria> categorias, LocalDate fechaInicioMembresia);
    Long countByMembresia_FechaInicioBefore(LocalDate fecha);
    Long countByTipoSocioAndCategoriasInAndMembresia_FechaInicioBefore(TipoSocio tipoSocio, List<Categoria> categorias, LocalDate fechaInicioMembresia);
    Long countByTipoSocio(TipoSocio tipoSocio);
    Long countByTipoSocioAndMembresia_FechaInicioBefore(TipoSocio tipoSocio, LocalDate fechaInicioMembresia);
    Long countByTipoSocioAndCategoriasIn(TipoSocio tipoSocio, List<Categoria> categorias);
    Long countByNombreContaining(String nombre);
    Long countByTipoSocioAndNombreContaining(TipoSocio tipoSocio, String nombre);
    Long countByActivo(Boolean activo);
    Long countByTipoSocioAndActivo(TipoSocio tipoSocio, Boolean activo);
    Long countByCategoriasInAndActivo(List<Categoria> categorias, Boolean activo);
}
