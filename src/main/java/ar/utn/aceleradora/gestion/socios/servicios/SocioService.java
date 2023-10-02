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
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
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



    //modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT); // Configura la estrategia de coincidencia

    //TypeMap<Socio, SocioDTO> typeMap = modelMapper.createTypeMap(Socio.class, SocioDTO.class);

    //typeMap.addMapping(Socio::getCategorias, SocioDTO::setCategoria);
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

  public List<String> obtenerNombres() {
    List<Socio> socios = socioRepository.findAll();
    return socios.stream().map(Socio::getNombre).collect(Collectors.toList());
  }

  public Page<ResumenSocioDTO> obtenerResumenSociosPaginados(int pagina, int tamanio, Optional<List<String>> categoriaOptional, Optional<Integer> aniosActivosOptional, Optional<String> tipoSocioOptional, Optional<String> nombreOptional, Optional<Boolean> activoOptional) {
    LocalDate fechaActual = LocalDate.now();
    Pageable pageable = PageRequest.of(pagina, tamanio);
    List<Socio> sociosFiltrados;

    List<Categoria> categorias = categoriaOptional.isPresent() ? categoriaService.obtenerCategoriasPorNombres(categoriaOptional.get()) : null;
    LocalDate fechaInicioMembresia = aniosActivosOptional.isPresent() ? fechaActual.minusYears(aniosActivosOptional.get()) : null;
    TipoSocio tipoSocio = tipoSocioOptional.isPresent() ? TipoSocio.valueOf(tipoSocioOptional.get()) : null;
    String nombre = nombreOptional.isPresent() ? nombreOptional.get() : null;
    Boolean activo = activoOptional.isPresent() ? activoOptional.get() : null;

    if (categorias != null && fechaInicioMembresia != null && tipoSocio != null) {
      sociosFiltrados = socioRepository.findByTipoSocioAndCategoriasInAndMembresia_FechaInicioBefore(tipoSocio, categorias, fechaInicioMembresia, pageable);
    } else if (categorias != null && tipoSocio != null) {
      sociosFiltrados = socioRepository.findByTipoSocioAndCategoriasIn(tipoSocio, categorias, pageable);
    } else if (categorias != null && fechaInicioMembresia != null) {
      sociosFiltrados = socioRepository.findByCategoriasInAndMembresia_FechaInicioBefore(categorias, fechaInicioMembresia, pageable);
    } else if (tipoSocio != null && fechaInicioMembresia != null) {
      sociosFiltrados = socioRepository.findByTipoSocioAndMembresia_FechaInicioBefore(tipoSocio, fechaInicioMembresia, pageable);
    } else if (tipoSocio != null && nombre !=null){
        sociosFiltrados = socioRepository.findByTipoSocioAndNombreContaining(tipoSocio, nombre, pageable);
    } else if (tipoSocio != null && activo != null){
      sociosFiltrados = socioRepository.findByTipoSocioAndActivo(tipoSocio, activo, pageable);
    } else if (categorias != null && activo != null){
      sociosFiltrados = socioRepository.findByCategoriasInAndActivo(categorias, activo, pageable);
    } else if (tipoSocio != null) {
      sociosFiltrados = socioRepository.findByTipoSocio(tipoSocio, pageable);
    } else if (categorias != null) {
      sociosFiltrados = socioRepository.findByCategoriasIn(categorias, pageable);
    } else if (fechaInicioMembresia != null) {
      sociosFiltrados = socioRepository.findByMembresia_FechaInicioBefore(fechaInicioMembresia, pageable);
    } else if (nombre != null) {
      sociosFiltrados = socioRepository.findByNombreContaining(nombre, pageable);
    } else if (activo != null){
        sociosFiltrados = socioRepository.findByActivo(activo, pageable);
    } else {
      sociosFiltrados = socioRepository.findAll(pageable).getContent();
    }



    List<ResumenSocioDTO> resumenSocios = sociosFiltrados.stream()
        .map(socio -> convertirResumenSocioDTO(socio, fechaActual))
        .collect(Collectors.toList());

    return new PageImpl<>(resumenSocios, pageable, sociosFiltrados.size());
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
      return null;
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
      if(socioDTO.getActivo() == null) {
        socioDTO.setActivo(existingSocio.getActivo());
      }
      modelMapper.map(socioDTO, existingSocio);
      Socio updatedSocio = socioRepository.save(existingSocio);
      return modelMapper.map(updatedSocio, SocioDTO.class);
    } else {
      return null;
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

  public List<String> getAllTipoSocio(){
    return List.of(TipoSocio.values()).stream().map(TipoSocio::name).collect(Collectors.toList());
  }

}
