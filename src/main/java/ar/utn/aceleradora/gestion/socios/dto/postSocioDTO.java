package ar.utn.aceleradora.gestion.socios.dto;
import ar.utn.aceleradora.gestion.socios.modelos.departamento.Etiqueta;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;

import java.util.Date;
import java.util.List;

public record  postSocioDTO(String nombre,String apellidoPresidente,TipoSocio tipoSocio, List<Etiqueta> categoria,String mail, String telefono,Ubicacion ubicacion){
}
