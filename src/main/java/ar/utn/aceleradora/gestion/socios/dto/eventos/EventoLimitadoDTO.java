package ar.utn.aceleradora.gestion.socios.dto.eventos;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.EstadoEvento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.Evento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoModalidad;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.EstadoInscripto;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.Inscripto;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Categoria;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.socios.TipoSocio;
import ar.utn.aceleradora.gestion.socios.modelos.socios.membresia.MembresiaParticular;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.serializers.CoordinacionJsonSerializer;
import ar.utn.aceleradora.gestion.socios.serializers.InscriptoSerializer;
import ar.utn.aceleradora.gestion.socios.serializers.SocioLimitadoSerializer;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class EventoLimitadoDTO {
    @JsonIgnoreProperties(value = {"invitados","inscriptos","departamentos"})
    private Evento evento;
    @JsonIgnoreProperties(value = {"nombrePresidente","cuit","tipoSocio","telefono","categorias","ubicacion","membresias"})
    private List<Socio> invitados;
    private List<Inscripto> inscriptos;
    @JsonIgnoreProperties(value = {"autoridades", "sociosSuscritos","fechaBaja"})
    private List<Departamento> departamentos;



}
