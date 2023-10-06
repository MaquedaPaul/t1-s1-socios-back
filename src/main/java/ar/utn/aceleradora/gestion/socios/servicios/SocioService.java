package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.dto.ResumenSocioDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioPostDTO;
import ar.utn.aceleradora.gestion.socios.modelos.departamento.Categoria;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SocioService {
  private final SocioRepository socioRepository;
  private final ModelMapper modelMapper;
  private final CategoriaService categoriaService;
  @Autowired
  public SocioService(SocioRepository socioRepository, ModelMapper modelMapper, CategoriaService categoriaService) {
    this.socioRepository = socioRepository;
    this.modelMapper = modelMapper;
    this.categoriaService = categoriaService;
  }

  public SocioDTO guardarSocio(SocioPostDTO socioPostDTO) {

    Socio socio = modelMapper.map(socioPostDTO, Socio.class);

    Socio savedSocio = socioRepository.save(socio);

    SocioDTO socioDTO = modelMapper.map(savedSocio, SocioDTO.class);

    return socioDTO;
  }



  public SocioDTO obtenerSocio(Integer id) {
    Optional<Socio> socioOptional = socioRepository.findById(id);

    if (socioOptional.isPresent()) {
      Socio socio = socioOptional.get();
      SocioDTO dto = modelMapper.map(socio, SocioDTO.class);
      return dto;
    } else {
      throw new EntityNotFoundException("Socio no encontrado con ID: " + id);
    }
  }

  public SocioDTO obtenerSocio(String nombre) {
    Optional<Socio> socioOptional = socioRepository.findByNombre(nombre);

    if (socioOptional.isPresent()) {
      Socio socio = socioOptional.get();
      SocioDTO dto = modelMapper.map(socio, SocioDTO.class);
      return dto;
    } else {
      throw new EntityNotFoundException("Socio no encontrado con NOMBRE: " + nombre);
    }
  }

  public List<String> obtenerNombres() {  //CAMBIO: SI LA LISTA ESTA VACIA AHORA TIRA EXCPECION ADVIRTIENDOLO, PERO NO DEVUELVE LA LISTA VACIA, QUIZA DEBERIA SIMPLEMENTE DEVOLVER LISTA VACIA
    List<Socio> socios = socioRepository.findAll();
    if (socios.isEmpty()) {
      throw new EntityNotFoundException("No hay socios cargados");
    }else{
      return socios.stream().map(Socio::getNombre).collect(Collectors.toList());
    }
  }

  public List<String> getTodosLosEstadoSocio() {
    return Arrays.stream(TipoSocio.values())
        .map(Enum::name)
        .collect(Collectors.toList());
  }

  private Pair<List<Socio>, Long> filtrarYContarSocios(Pageable pageable,
                                                       Optional<List<String>> categoriaOptional,
                                                       Optional<LocalDate> fechaInicioMembresia,
                                                       Optional<TipoSocio> tipoSocioOptional,
                                                       Optional<String> nombreOptional,
                                                       Optional<Boolean> activoOptional) {

    List<Socio> sociosFiltrados;

    TipoSocio tipoSocio = tipoSocioOptional.orElse(null);
    List<Categoria> categorias = null;
    if(categoriaOptional.isPresent()) {
      categorias = categoriaService.obtenerCategoriasPorNombres(categoriaOptional.get());
    }
    String nombre = nombreOptional.orElse(null);
    Boolean activo = activoOptional.orElse(null);
    LocalDate fechaInicio = fechaInicioMembresia.orElse(null);

    if (categorias != null && fechaInicio != null && tipoSocio != null) {
      sociosFiltrados = socioRepository.findByTipoSocioAndCategoriasInAndMembresia_FechaInicioBefore(tipoSocio, categorias, fechaInicio);
    } else if (categorias != null && tipoSocio != null) {
      sociosFiltrados = socioRepository.findByTipoSocioAndCategoriasIn(tipoSocio, categorias);
    } else if (categorias != null && fechaInicio != null) {
      sociosFiltrados = socioRepository.findByCategoriasInAndMembresia_FechaInicioBefore(categorias, fechaInicio);
    } else if (tipoSocio != null && fechaInicio != null) {
      sociosFiltrados = socioRepository.findByTipoSocioAndMembresia_FechaInicioBefore(tipoSocio, fechaInicio);
    } else if (tipoSocio != null && nombre !=null) {
      sociosFiltrados = socioRepository.findByTipoSocioAndNombreContaining(tipoSocio, nombre);
    } else if (tipoSocio != null && activo != null) {
      sociosFiltrados = socioRepository.findByTipoSocioAndActivo(tipoSocio, activo);
    } else if (categorias != null && activo != null) {
      sociosFiltrados = socioRepository.findByCategoriasInAndActivo(categorias, activo);
    } else if (tipoSocio != null) {
      sociosFiltrados = socioRepository.findByTipoSocio(tipoSocio);
    } else if (categorias != null) {
      sociosFiltrados = socioRepository.findByCategoriasIn(categorias);
    } else if (fechaInicio != null) {
      sociosFiltrados = socioRepository.findByMembresia_FechaInicioBefore(fechaInicio);
    } else if (nombre != null) {
      sociosFiltrados = socioRepository.findByNombreContaining(nombre);
    } else if (activo != null) {
      sociosFiltrados = socioRepository.findByActivo(activo);
    } else {
      sociosFiltrados = socioRepository.findAll();
    }

    Long totalSocios = (long) sociosFiltrados.size();
    sociosFiltrados = sociosFiltrados.stream()
        .skip(pageable.getOffset())
        .limit(pageable.getPageSize())
        .collect(Collectors.toList());

    return Pair.of(sociosFiltrados, totalSocios);
  }

  public Page<ResumenSocioDTO> obtenerResumenSociosPaginados(int pagina, int tamanio,
                                                             Optional<List<String>> categoriaOptional,
                                                             Optional<Integer> aniosActivosOptional,
                                                             Optional<TipoSocio> tipoSocioOptional,
                                                             Optional<String> nombreOptional,
                                                             Optional<Boolean> activoOptional) {

    LocalDate fechaActual = LocalDate.now();
    Pageable pageable = PageRequest.of(pagina, tamanio);

    Optional<LocalDate> fechaInicioMembresiaOptional = aniosActivosOptional.map(anios -> fechaActual.minusYears(anios));

    Pair<List<Socio>, Long> result = filtrarYContarSocios(
        pageable,
        categoriaOptional,
        fechaInicioMembresiaOptional,
        tipoSocioOptional,
        nombreOptional,
        activoOptional);

    List<Socio> sociosFiltrados = result.getKey();
    Long totalSocios = result.getValue();

    if (sociosFiltrados.isEmpty()) {
      return new PageImpl<>(Collections.emptyList(), pageable, 0L);
    }

    List<ResumenSocioDTO> resumenSocios = sociosFiltrados.stream()
        .map(socio -> convertirResumenSocioDTO(socio, fechaActual))
        .collect(Collectors.toList());

    return new PageImpl<>(resumenSocios, pageable, totalSocios);
  }

  private ResumenSocioDTO convertirResumenSocioDTO(Socio socio, LocalDate fechaActual) {
    ResumenSocioDTO resumenSocioDTO = modelMapper.map(socio, ResumenSocioDTO.class);
    if (socio.isActivo() && socio.getMembresia() != null) {

      Period periodo = Period.between(socio.getMembresia().getFechaInicio(), fechaActual);
      resumenSocioDTO.setAniosDeAntiguedad(periodo.getYears());
      // TODO: Considerar otros casos aquí, como cuando el socio tiene un nombre de presidente
    } else {
      // Establezco valores predeterminados en casos limites, ejemplo este que el socio no tiene membresia
      resumenSocioDTO.setAniosDeAntiguedad(0);
    }
    return resumenSocioDTO;
  }

  public SocioDTO eliminarSocio(Integer id) {
    Optional<Socio> existingSocioOpt = socioRepository.findById(id);
    if (existingSocioOpt.isPresent()) {
      Socio existingSocio = existingSocioOpt.get();
      existingSocio.setActivo(false);
      Socio updatedSocio = socioRepository.save(existingSocio);
      return modelMapper.map(updatedSocio, SocioDTO.class);
    } else {
      throw new EntityNotFoundException("no se econtro un socio con id: " + id+ " para borrar");

    }
  }
  public SocioDTO darAltaSocio(Integer id) {
    Optional<Socio> existingSocioOpt = socioRepository.findById(id);
    if (existingSocioOpt.isPresent()) {
      Socio existingSocio = existingSocioOpt.get();
      existingSocio.setActivo(true);
      Socio updatedSocio = socioRepository.save(existingSocio);
      return modelMapper.map(updatedSocio, SocioDTO.class);
    } else {
      return null;
    }
  }

  public SocioDTO actualizarSocio(Integer id, SocioDTO socioDTO) {
    Optional<Socio> existingSocioOpt = socioRepository.findById(id);
    if (existingSocioOpt.isPresent()) {
      Socio existingSocio = existingSocioOpt.get();
      socioDTO.setId(id);
      if(socioDTO.getActivo() == null) {
        socioDTO.setActivo(existingSocio.getActivo());
      }
      if (socioDTO.getUbicacion() != null
              && socioDTO.getUbicacion().getDireccion().equals(existingSocio.getUbicacion().getDireccion())
              && socioDTO.getUbicacion().getPiso().equals(existingSocio.getUbicacion().getPiso())
              && socioDTO.getUbicacion().getDepartamento().equals(existingSocio.getUbicacion().getDepartamento())
              && socioDTO.getUbicacion().getLocalidad().equals(existingSocio.getUbicacion().getLocalidad())
              && socioDTO.getUbicacion().getProvincia().equals(existingSocio.getUbicacion().getProvincia())
      ) {
        socioDTO.getUbicacion().setId(existingSocio.getUbicacion().getId());
      }
      modelMapper.map(socioDTO, existingSocio);
      Socio updatedSocio = socioRepository.save(existingSocio);
      return modelMapper.map(updatedSocio, SocioDTO.class);
    } else {
      throw new EntityNotFoundException("no se econtro un socio con id: " + id+ " para actualizar");
    }
  }

  public SocioDTO agregarCategoriasASocio(Integer idSocio, List<String> nombresCategorias) {
    Socio socio = socioRepository.findById(idSocio).orElseThrow(() -> new EntityNotFoundException("Socio no encontrado"));

    List<Categoria> categorias = categoriaService.obtenerCategoriasPorNombres(nombresCategorias);
    socio.getCategorias().addAll(categorias); // TODO: Agregarle la funcion a socio para que no rompa el paradigma de objetos

    Socio socioGuardado = socioRepository.save(socio);

    // Reutiliza el mapeo existente para convertir Socio a SocioDTO
    SocioDTO socioDTO = modelMapper.map(socioGuardado, SocioDTO.class);

    return socioDTO;
  }

  public List<String> obtenerCategoriasDeSocio(Integer idSocio) {
    Socio socio = socioRepository.findById(idSocio).orElseThrow(() -> new EntityNotFoundException("Socio no encontrado"));

    List<String> categorias = socio.getCategorias().stream()
        .map(Categoria::getNombre)
        .collect(Collectors.toList());

    return categorias;
  }

  public Void eliminarCategoriaDeSocio(Integer idSocio, String nombreCategoria) {
    Socio socio = socioRepository.findById(idSocio).orElseThrow(() -> new EntityNotFoundException("Socio no encontrado"));
    Categoria categoria = categoriaService.obtenerCategoriaPorNombre(nombreCategoria);
    socio.getCategorias().remove(categoria);
    socioRepository.save(socio);
    return null;
  }

  public Void actualizarCategoriasDeSocio(Integer idSocio, List<String> nombresCategorias) {
    Socio socio = socioRepository.findById(idSocio).orElseThrow(() -> new EntityNotFoundException("Socio no encontrado"));
    List<Categoria> categorias = categoriaService.obtenerCategoriasPorNombres(nombresCategorias);
    socio.setCategorias(categorias);
    socioRepository.save(socio);
    return null;
  }

  public List<String> getAllTipoSocio() {
    return List.of(TipoSocio.values()).stream()
        .map(TipoSocio::getDescripcion)
        .collect(Collectors.toList());
  }

}
