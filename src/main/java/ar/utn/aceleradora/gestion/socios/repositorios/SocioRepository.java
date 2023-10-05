package ar.utn.aceleradora.gestion.socios.repositorios;

import ar.utn.aceleradora.gestion.socios.modelos.departamento.Categoria;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository

public interface SocioRepository extends JpaRepository<Socio, Integer> {
    List<Socio> findByCategoriasIn(List<Categoria> categorias);
    List<Socio> findByCategoriasInAndMembresia_FechaInicioBefore(List<Categoria> categorias, LocalDate fechaInicioMembresia);
    List<Socio> findByMembresia_FechaInicioBefore(LocalDate fecha);
    List<Socio> findByTipoSocioAndCategoriasInAndMembresia_FechaInicioBefore(TipoSocio tipoSocio ,List<Categoria> categorias, LocalDate fechaInicioMembresia);
    List<Socio> findByTipoSocio(TipoSocio tipoSocio);
    List<Socio> findByTipoSocioAndMembresia_FechaInicioBefore(TipoSocio tipoSocio, LocalDate fechaInicioMembresia);
    List<Socio> findByTipoSocioAndCategoriasIn(TipoSocio tipoSocio, List<Categoria> categoria);
    List<Socio> findByNombreContaining(String nombre);
    List<Socio> findByTipoSocioAndNombreContaining(TipoSocio tipoSocio, String nombre);
    List<Socio> findByActivo(Boolean activo);
    List<Socio> findByTipoSocioAndActivo(TipoSocio tipoSocio, Boolean activo);
    List<Socio> findByCategoriasInAndActivo(List<Categoria> categorias, Boolean activo);
    Optional<Socio> findByNombre(String nombre);
}
