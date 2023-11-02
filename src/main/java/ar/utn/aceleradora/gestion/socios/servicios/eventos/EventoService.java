package ar.utn.aceleradora.gestion.socios.servicios.eventos;


import ar.utn.aceleradora.gestion.socios.dto.eventos.EventoLimitadoDTO;
import ar.utn.aceleradora.gestion.socios.dto.eventos.EventoCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.eventos.EventoUpdateDTO;
import ar.utn.aceleradora.gestion.socios.dto.eventos.ListaEventoDTO;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.Evento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoEstadoEvento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoModalidad;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.TipoEstadoInscripto;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventoService {

    void crearEvento(EventoCreateDTO evento) throws Exception;

    Boolean editarEvento(EventoUpdateDTO evento, Integer id) throws Exception;

    List<ListaEventoDTO> listarEventos()throws Exception;

    EventoLimitadoDTO listarEvento(Integer id) throws Exception;

    void invitar(Evento evento, Socio socio) throws Exception;

    void confirmar(Evento evento, Socio socio) throws Exception;

    void cancelar(Evento evento) throws Exception;

    void finalizar(Evento evento) throws Exception;

    Evento obtenerEventoPorId(Integer eventoId) throws Exception;

    List<TipoModalidad> listasModalidades();

    List<TipoEstadoEvento> listarEstadosEventos();

    List<TipoEstadoInscripto> listarEstadosInscriptos();
}
