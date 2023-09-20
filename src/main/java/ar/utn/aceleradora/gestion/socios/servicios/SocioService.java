package ar.utn.aceleradora.gestion.socios.servicios;


import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioEmpresa;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioPlenario;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioEmpresaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioPlenarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SocioService {


//  @Autowired
  private final SocioEmpresaRepository socioEmpresaRepository;

//  @Autowired
  private final SocioPlenarioRepository socioPlenarioRepository;

  @Autowired
  public SocioService(SocioEmpresaRepository socioEmpresaRepository, SocioPlenarioRepository socioPlenarioRepository) {
    this.socioEmpresaRepository = socioEmpresaRepository;
    this.socioPlenarioRepository = socioPlenarioRepository;
  }

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

  



}
