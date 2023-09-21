package ar.utn.aceleradora.gestion.socios.dto;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;

public record ResumenSocioDTO(String nombre,Boolean activo, TipoSocio categoria, Ubicacion ubicacion){
}