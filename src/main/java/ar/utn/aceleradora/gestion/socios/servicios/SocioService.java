package ar.utn.aceleradora.gestion.socios.servicios;


import ar.utn.aceleradora.gestion.socios.dto.ResumenSocioDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioEmpresaDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioPlenarioDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioPostDTO;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioEmpresa;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioPlenario;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SocioService {
  private final SocioRepository socioRepository;
  private final ModelMapper modelMapper;
  @Autowired
  public SocioService(SocioRepository socioRepository, ModelMapper modelMapper) {
    this.socioRepository = socioRepository;
    this.modelMapper = modelMapper;
  }
  public SocioDTO guardarSocio(SocioPostDTO socioPostDTO) {
    Socio socio = modelMapper.map(socioPostDTO, Socio.class);
    Socio savedSocio = socioRepository.save(socio);
    return modelMapper.map(savedSocio, SocioDTO.class);
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
    List<Socio> socios = socioRepository.findAll();
    List<ResumenSocioDTO> resumenSocios = new ArrayList<>();
    LocalDate fechaActual = LocalDate.now();

    for (Socio socio : socios) {
      // Filtrar por categoría si se proporciona
      if (categoriaOptional.isPresent() && !socio.getCategoria().equals(categoriaOptional.get())) {
        continue; // Saltar a la siguiente iteración si la categoría no coincide
      }

      LocalDate fechaInicioMembresia = socio.getMembresia().getFechaInicio();
      LocalDate fechaVencimientoMembresia = socio.getMembresia().getFechaVto();

      // Calcula el período entre la fecha de inicio y la fecha actual
      Period periodo = Period.between(fechaInicioMembresia, fechaActual);
      int aniosDeActividad = periodo.getYears();

      // Aplica el filtro de años activos si se proporciona
      if (!aniosActivosOptional.isPresent() || aniosDeActividad >= aniosActivosOptional.get()) {
        ResumenSocioDTO resumenSocioDTO = new ResumenSocioDTO(
                socio.getNombre(),
                socio.getActivo(),
                socio.getTipoSocio(),
                socio.getUbicacion(),
                aniosDeActividad // Agrega el número de años de actividad al DTO
        );
        resumenSocios.add(resumenSocioDTO);
      }
    }

    // Aplica la paginación solo a los socios que cumplen con el filtro
    int desde = pagina * tamanio;
    int hasta = Math.min(desde + tamanio, resumenSocios.size());
    List<ResumenSocioDTO> sociosPaginados = resumenSocios.subList(desde, hasta);

    return new PageImpl<>(sociosPaginados, PageRequest.of(pagina, tamanio), resumenSocios.size());
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
