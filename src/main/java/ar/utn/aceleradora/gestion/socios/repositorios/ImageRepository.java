package ar.utn.aceleradora.gestion.socios.repositorios;


import ar.utn.aceleradora.gestion.socios.modelos.imagen.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
