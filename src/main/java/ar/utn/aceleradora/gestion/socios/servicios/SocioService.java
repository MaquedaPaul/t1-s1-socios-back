package ar.utn.aceleradora.gestion.socios.servicios;


import ar.utn.aceleradora.gestion.socios.dto.ResumenSocioDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioEmpresaDTO;
import ar.utn.aceleradora.gestion.socios.dto.SocioPlenarioDTO;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioEmpresa;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioPlenario;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SocioService {
  private final SocioRepository socioRepository;

  @Autowired
  public SocioService(SocioRepository socioRepository) {
    this.socioRepository = socioRepository;
  }

  private Socio convertirAEntidad(SocioDTO socioDTO) {
    if (socioDTO instanceof SocioPlenarioDTO) {
      SocioPlenario socioPlenario = new SocioPlenario();
      BeanUtils.copyProperties(socioDTO, socioPlenario);
      return socioPlenario;
    } else {
      SocioEmpresa socioEmpresa = new SocioEmpresa();
      BeanUtils.copyProperties(socioDTO, socioEmpresa);
      return socioEmpresa;
    }
  }

  private SocioDTO convertirADto(Socio socio) {
    if (socio instanceof SocioPlenario) {
      SocioPlenarioDTO socioPlenarioDTO = new SocioPlenarioDTO();
      BeanUtils.copyProperties(socio, socioPlenarioDTO);
      return socioPlenarioDTO;
    } else {
      SocioEmpresaDTO socioEmpresaDTO = new SocioEmpresaDTO();
      BeanUtils.copyProperties(socio, socioEmpresaDTO);
      return socioEmpresaDTO;
    }
  }

  public SocioDTO guardarSocio(SocioDTO socioDTO) {
    Socio socio = convertirAEntidad(socioDTO);
    Socio savedSocio = socioRepository.save(socio);
    return convertirADto(savedSocio);
  }

  public SocioDTO obtenerSocio(Integer id) {
    Socio socio = socioRepository.findById(id).orElse(null);
    if (socio != null) {
      SocioDTO dto = convertirADto(socio);
      return dto.convertirDTO(dto);  // Esto devolverá SocioEmpresaDTO o SocioPlenarioDTO
    }
    return null;
  }

  public List<String> obtenerNombres() {
    List<Socio> socios= socioRepository.findAll();
    return socios.stream().map(Socio::getNombre).collect(Collectors.toList());
  }

  public Page<ResumenSocioDTO> obtenerResumenSociosPaginados(int pagina,int tamanio){
    List<Socio> socios = socioRepository.findAll();
    List<ResumenSocioDTO> resumenSocios = new ArrayList<>();
    for (Socio socio : socios) {
      ResumenSocioDTO resumenSocioDTO = new ResumenSocioDTO(
          socio.getNombre(),
          socio.getActivo(),
          socio.getCategoria(),
          socio.getUbicacion()
      );
      resumenSocios.add(resumenSocioDTO);
    }

    return new PageImpl<>(resumenSocios, PageRequest.of(pagina, tamanio), resumenSocios.size());
  }

  public SocioDTO  eliminarSocio(Integer id) {
    Optional<Socio> existingSocioOpt = socioRepository.findById(id);
    if (existingSocioOpt.isPresent()) {
      Socio existingSocio = existingSocioOpt.get();
      existingSocio.setActivo(false);
      Socio updatedSocio = socioRepository.save(existingSocio);
      return convertirADto(updatedSocio); // Convertir el socio inactivo a DTO y devolverlo
    }
    else {
      return null;
    }
  }

  public SocioDTO actualizarSocio(Integer id,SocioDTO socioDTO) {
    Optional<Socio> existingSocioOpt = socioRepository.findById(id);
    if (existingSocioOpt.isPresent()) {
      Socio existingSocio = existingSocioOpt.get();
      BeanUtils.copyProperties(socioDTO, existingSocio);
      Socio updatedSocio = socioRepository.save(existingSocio);
      return convertirADto(updatedSocio);
    } else {
      return null;
    }
  }
}
