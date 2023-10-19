package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.converters.DateConverter;
import ar.utn.aceleradora.gestion.socios.dto.SocioCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioUpdateDTO;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import ar.utn.aceleradora.gestion.socios.modelos.imagen.Imagen;
import ar.utn.aceleradora.gestion.socios.modelos.membresia.Membresia;
import ar.utn.aceleradora.gestion.socios.modelos.membresia.MembresiaParticular;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class SocioServiceImpl implements SocioService {
  private final SocioRepository socioRepository;
  private final CategoriaRepository categoriaRepository;
  private final UbicacionRepository ubicacionRepository;
  private final MembresiaParticularRepository membresiaParticularRepository;
  private final MembresiaRepository membresiaRepository;

  @Autowired
  public SocioServiceImpl(SocioRepository socioRepository, CategoriaRepository categoriaRepository, UbicacionRepository ubicacionRepository, MembresiaParticularRepository membresiaParticularRepository, MembresiaRepository membresiaRepository) {
    this.socioRepository = socioRepository;
    this.categoriaRepository = categoriaRepository;
    this.ubicacionRepository = ubicacionRepository;
    this.membresiaParticularRepository = membresiaParticularRepository;
    this.membresiaRepository = membresiaRepository;
  }

  @Override
  public List<Socio> findAllSocios() throws Exception {
    try{
      return socioRepository.findAll();
    } catch (Exception e) {
      throw new Exception("Error al buscar socios");
    }
  }

  @Override
  public Page<Socio> findAllSociosPaginado(int page) throws Exception {
    //funcion que le pasa un numero y me devuelve una pagina
    Pageable pageable = PageRequest.of(page, 10);
    try{
      return socioRepository.findAll(pageable);
    } catch (Exception e) {
      throw new Exception("Error al buscar socios");
    }
  }

  @Override
  public Boolean deleteSocioById(Integer id) throws Exception{
    Optional<Socio> partner = socioRepository.findById(id);

    if (partner.isEmpty())
      return false;

    socioRepository.delete(partner.get());

    return true;
  }

  @Override
  public Boolean updateSocio(SocioUpdateDTO socioUpdate, Integer id) throws Exception {
    try {
      Optional<Socio> optionalSocio = socioRepository.findById(id);

      if (optionalSocio.isEmpty())
        return false;

      Socio existingSocio = optionalSocio.get();

      existingSocio.setNombre(socioUpdate.getNombre());
      existingSocio.setNombrePresidente(socioUpdate.getNombrePresidente());
      existingSocio.setCuit(socioUpdate.getCuit());
      existingSocio.setTelefono(socioUpdate.getTelefono());
      existingSocio.setMail(socioUpdate.getMail());
      existingSocio.getUbicacion().setDireccion(socioUpdate.getDireccion());
      existingSocio.getUbicacion().setPiso(socioUpdate.getPiso());
      existingSocio.getUbicacion().setDepartamento(socioUpdate.getDepartamento());
      existingSocio.getUbicacion().setLocalidad(socioUpdate.getLocalidad());
      existingSocio.getUbicacion().setProvincia(socioUpdate.getProvincia());
//      Imagen imagen = new Imagen(socioUpdate.getImagen().getRutaImagen());
//      existingSocio.setImagen(imagen);

      socioRepository.save(existingSocio);

      return true;
    } catch (Exception e) {
      throw new Exception("Error al editar el socio, por favor intentelo más tarde");
    }
  }

  @Override
  public Boolean createSocio(SocioCreateDTO socio) throws Exception {
    try {
      TipoSocio tipoSocio = ("0".equals(socio.getTipoSocio())) ? TipoSocio.SOCIO_PLENARIO : TipoSocio.SOCIO_ADHERENTE;
//      Imagen imagen = new Imagen(socio.getImagen().getRutaImagen());

      Socio nuevoSocio = new Socio(socio.getNombre(), socio.getNombrePresidente(), socio.getCuit(), tipoSocio, socio.getTelefono(), socio.getMail());

      Ubicacion ubicacion = new Ubicacion(socio.getDireccion(), socio.getPiso(), socio.getDepartamento(), socio.getLocalidad(), socio.getProvincia());
      ubicacionRepository.save(ubicacion);
      socioRepository.save(nuevoSocio);

      Optional<Membresia> membresiaSeleccionada = membresiaRepository.findById(socio.getMembresiaId());
      LocalDate fechaInicio = DateConverter.parse(socio.getFechaInicio());
      MembresiaParticular membresiaParticular = new MembresiaParticular(membresiaSeleccionada.get(), fechaInicio, socio.getValor());
      nuevoSocio.agregarMembresia(membresiaParticular);

      nuevoSocio.setUbicacion(ubicacion);
      nuevoSocio.setCategorias(categoriaRepository.findAllById(socio.getCategorias()));

      socioRepository.save(nuevoSocio);
      membresiaParticularRepository.save(membresiaParticular);

      return true;
    } catch (Exception e) {
      throw new Exception("Error al crear el socio, por favor inténtelo más tarde");
    }
  }
}
