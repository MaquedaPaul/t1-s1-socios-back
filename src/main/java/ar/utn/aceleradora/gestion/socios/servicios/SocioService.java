package ar.utn.aceleradora.gestion.socios.servicios;


import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioEmpresa;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioPlenario;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioEmpresaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioPlenarioRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SocioService {

  private final SocioRepository socioRepository;

  @Autowired
  public SocioService(SocioRepository socioRepository) {
    this.socioRepository = socioRepository;
  }

  public Socio guardarSocio(Socio socio) {
    return socioRepository.save(socio);
  }

  public Socio getSocio(Integer id) {
    Socio socio = socioRepository.findById(id).orElse(null);
    if( socio != null ) {return socio;}
    else {return null;}
  }

  public void eliminarSocio(Integer id) {
    socioRepository.deleteById(id);
  }

  public Socio actualizarSocio(Socio socio) {
    if (socio.getId() != null) {
      return socioRepository.save(socio);
    }
    return null; // El socio no tiene un ID válido
  }



  /*
  public Optional<Socio> obtenerSocio(Integer id){
    Optional<SocioEmpresa> socioEmpresa = socioEmpresaRepository.findById(id);
    Optional<SocioPlenario> socioPlenario = socioPlenarioRepository.findById(id);
    if( socioEmpresa.isPresent() ){
      return Optional.of(socioEmpresa.get());
    }else if( socioPlenario.isPresent() ){
      return Optional.of(socioPlenario.get());
    }else{
      return Optional.empty();
    }
  }

  public SocioPlenario guardarSocioPlenario(SocioPlenario socio) {
    return socioPlenarioRepository.save(socio);
  }

  public SocioEmpresa guardarSocioEmpresa(SocioEmpresa socio) {
    return socioEmpresaRepository.save(socio);
  }

  public SocioPlenario getSocioPlenarioPorId(Integer id) {
    SocioPlenario socioPlenario = socioPlenarioRepository.findById(id).orElse(null);
    if( socioPlenario != null ) {return socioPlenario;}
    else {return null;}
    }

  public SocioEmpresa getSocioEmpresaPorId(Integer id) {
    SocioEmpresa socioEmpresa = socioEmpresaRepository.findById(id).orElse(null);
    if( socioEmpresa != null ) {return socioEmpresa;}
    else{return null;}
  }

  public void eliminarSocioPlenario(Integer id) {
    socioPlenarioRepository.deleteById(id);
  }

  public void eliminarSocioEmpresa(Integer id) {
    socioEmpresaRepository.deleteById(id);
  }

  public SocioPlenario actualizarSocioPlenario(SocioPlenario socio) {
    if (socio.getIdPlenario() != null) {
      return socioPlenarioRepository.save(socio);
    }
    return null; // El socio no tiene un ID válido
  }

  public SocioEmpresa actualizarSocioEmpresa(SocioEmpresa socio) {
    if (socio.getIdEmpresa() != null) {
      return socioEmpresaRepository.save(socio);
    }
    return null; // El socio no tiene un ID válido
  }

   public List<NombresDTO> obtenerNombres() {
    List<SocioEmpresa> listaSocios = socioEmpresaRepository.findAll();
    List<SocioPlenario> listaSocios2 = socioPlenarioRepository.findAll();

    List<NombresDTO> nombresDTOList = new ArrayList<>();

    nombresDTOList.addAll(listaSocios.stream()
            .map(socio -> new NombresDTO(socio.getNombreEmpresa()))
            .collect(Collectors.toList()));

    nombresDTOList.addAll(listaSocios2.stream()
            .map(socio -> new NombresDTO(socio.getNombreEmpresa()))
            .collect(Collectors.toList()));

    return nombresDTOList;
  }
/*
  public busquedaSegunIdDTO busquedaSegunId(int id) {   ACA FALTA: QUE PASA CON EL DTO SI ES UN PLENARIO O UNA EMPRESA AHORA Q SOCIO ES UN ABSTRACT? COMO MANEJO LA EXCEPCION?
    Optional<SocioPlenario> socioPlenarioOptional = socioPlenarioRepository.findById(id);

    if (socioPlenarioOptional.isPresent()) {
      SocioPlenario socioPlenario = socioPlenarioOptional.get();
      busquedaSegunIdDTO dto = new busquedaSegunIdDTO(socioPlenario.getIdPlenario(),socioPlenario.getNombreEmpresa(),socioPlenario.getNombrePresidente(),socioPlenario.getCategoria(),socioPlenario.getEtiquetas(),socioPlenario.getMail(),socioPlenario.getTelefono(),
      true, new Membresia.getFechainicio, new Membresia.getFechavto, socioPlenario.getUbicacion());
      return dto;
    } else {
      throw new Exception("SocioPlenario not found with ID: " + id);
      return null;
    }
  }*/
*/

}
