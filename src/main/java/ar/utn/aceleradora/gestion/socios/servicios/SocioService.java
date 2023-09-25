package ar.utn.aceleradora.gestion.socios.servicios;


import ar.utn.aceleradora.gestion.socios.dto.ResumenSocioDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioPostDTO;
import ar.utn.aceleradora.gestion.socios.modelos.departamento.Categoria;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
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
  }
  public SocioDTO guardarSocio(SocioPostDTO socioPostDTO) {
    System.out.println("Antes del mapeo:");
    System.out.println("Nombre: " + socioPostDTO.getNombre());
    // Agrega más impresiones para otras propiedades que desees verificar

    Socio socio = modelMapper.map(socioPostDTO, Socio.class);
    System.out.println("Después del mapeo a Socio:");
    System.out.println("Nombre: " + socio.getNombre());
    // Agrega más impresiones para las propiedades mapeadas en Socio

    Socio savedSocio = socioRepository.save(socio);
    System.out.println("Después de guardar en la base de datos:");
    System.out.println("ID del Socio: " + savedSocio.getId());
    // Agrega más impresiones para otras propiedades del Socio guardado

    SocioDTO socioDTO = modelMapper.map(savedSocio, SocioDTO.class);
    System.out.println("Después del mapeo a SocioDTO:");
    System.out.println("Nombre: " + socioDTO.getNombre());
    // Agrega más impresiones para las propiedades mapeadas en SocioDTO

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
  public List<String> obtenerNombres() {
    List<Socio> socios = socioRepository.findAll();
    return socios.stream().map(Socio::getNombre).collect(Collectors.toList());
  }

  public Page<ResumenSocioDTO> obtenerResumenSociosPaginados(int pagina, int tamanio, Optional<String> categoriaOptional, Optional<Integer> aniosActivosOptional) {
    LocalDate fechaActual = LocalDate.now();
    LocalDate fechaInicioMembresia;

    Pageable pageable = PageRequest.of(pagina, tamanio);

    List<Socio> sociosFiltrados;

    if (categoriaOptional.isPresent() && aniosActivosOptional.isPresent()) {
      List <Categoria> categorias = categoriaService.obtenerCategoriaPorNombre(categoriaOptional.get());
      fechaInicioMembresia = fechaActual.minusYears(aniosActivosOptional.get());
      sociosFiltrados = socioRepository.findByCategoriasAndMembresiaFechaInicioBeforeIn(categorias, fechaInicioMembresia, pageable);
    } else if (categoriaOptional.isPresent()) {
      //categoriaOptional.forEach(categoria -> socioRepository.findByCategoria(categoria, pageable));
      List <Categoria> categorias = categoriaService.obtenerCategoriaPorNombre(categoriaOptional.get());
      sociosFiltrados = socioRepository.findByCategoriasIn(categorias, pageable);
    } else if (aniosActivosOptional.isPresent()) {
      fechaInicioMembresia = fechaActual.minusYears(aniosActivosOptional.get());
      sociosFiltrados = socioRepository.findByMembresiaFechaInicioBefore(fechaInicioMembresia, pageable);
    } else {
      sociosFiltrados = socioRepository.findAll(pageable).getContent();
    }

    List<ResumenSocioDTO> resumenSocios = sociosFiltrados.stream().map(socio -> {
      ResumenSocioDTO dto = modelMapper.map(socio, ResumenSocioDTO.class);
      Period periodo = Period.between(socio.getMembresia().getFechaInicio(), fechaActual);
      dto.setAniosDeAntiguedad(periodo.getYears());
      //TODO: FALTA CASO PARA CUANDO TIENE NOMBRE PRESIDENTE, A CONTEMPLAR
      return dto;
    }).collect(Collectors.toList());

    return new PageImpl<>(resumenSocios, pageable, sociosFiltrados.size());
  }



  public SocioDTO eliminarSocio(Integer id) {
    Optional<Socio> existingSocioOpt = socioRepository.findById(id);
    if (existingSocioOpt.isPresent()) {
      Socio existingSocio = existingSocioOpt.get();
      existingSocio.setActivo(false);
      Socio updatedSocio = socioRepository.save(existingSocio);
      return modelMapper.map(updatedSocio, SocioDTO.class); // Convertir el socio inactivo a DTO y devolverlo
    } else {
      return null;
    }
  }
  public SocioDTO actualizarSocio(Integer id, SocioDTO socioDTO) {
    Optional<Socio> existingSocioOpt = socioRepository.findById(id);
    if (existingSocioOpt.isPresent()) {
      Socio existingSocio = existingSocioOpt.get();
      modelMapper.map(socioDTO, existingSocio);
      Socio updatedSocio = socioRepository.save(existingSocio);
      return modelMapper.map(updatedSocio, SocioDTO.class);
    } else {
      return null;
    }
  }
}
