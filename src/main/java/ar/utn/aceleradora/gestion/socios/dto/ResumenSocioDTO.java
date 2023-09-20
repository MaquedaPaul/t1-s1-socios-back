package ar.utn.aceleradora.gestion.socios.dto;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;

public record ResumenSocioDTO(String nombre, TipoSocio categoria) {
}