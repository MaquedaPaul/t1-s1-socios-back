package ar.utn.aceleradora.gestion.socios.dto;
import ar.utn.aceleradora.gestion.socios.modelos.departamento.Categoria;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;

import java.util.Date;
import java.util.List;
public record busquedaSegunIdDTO(int id, String nombre, String apellidoPresidente, String cateforia, List<Categoria> etiquetas, String mail, String telefono, Boolean isActivo, Date ExpiracionMembresia, Date ultimaRenovacion,
                                 /*Eventos eventosPendientes, Eventos eventosAceptados,*/Ubicacion ubicacion) {
}
