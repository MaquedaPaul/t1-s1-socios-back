package ar.utn.aceleradora.gestion.socios.utilidades;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.Categoria;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import jakarta.persistence.criteria.Join;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;

public class SocioEspecificacion {
  public static Specification<Socio> tieneCategoria(List<Categoria> categorias) {
    return (socio, cq, cb) -> {
      if (categorias != null && !categorias.isEmpty()) {
        Join<Socio, Categoria> join = socio.join("categorias");
        return cb.isTrue(join.in(categorias));
      }
      return cb.conjunction();
    };
  }

  public static Specification<Socio> tieneFechaInicioAntesDe(LocalDate fechaInicio) {
    return (socio, cq, cb) -> fechaInicio != null ? cb.lessThanOrEqualTo(socio.get("membresia").get("fechaInicio"), fechaInicio) : null;
  }

  public static Specification<Socio> tieneTipoSocio(TipoSocio tipoSocio) {
    return (socio, cq, cb) -> tipoSocio != null ? cb.equal(socio.get("tipoSocio"), tipoSocio) : null;
  }

  public static Specification<Socio> tieneNombre(String nombre) {
    return (socio, cq, cb) -> nombre != null ? cb.like(socio.get("nombre"), "%" + nombre + "%") : null;
  }

  public static Specification<Socio> estaActivo(Boolean activo) {
    return (socio, cq, cb) -> activo != null ? cb.equal(socio.get("activo"), activo) : null;
  }
}
