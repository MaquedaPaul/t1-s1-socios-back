package ar.utn.aceleradora.gestion.socios.servicios.eventos;

import ar.utn.aceleradora.gestion.socios.dto.EventoCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.EventoUpdateDTO;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.Evento;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventoService {

    Boolean crearEvento(EventoCreateDTO evento) throws Exception;

    Boolean editarEvento(EventoUpdateDTO evento, Integer id) throws Exception;

    List<Evento> listarEventos()throws Exception;

    void invitar(Evento evento, Socio socio) throws Exception;

    void confirmar(Evento evento, Socio socio) throws Exception;

    void cancelar(Evento evento) throws Exception;

    void finalizar(Evento evento) throws Exception;

    Evento obtenerEventoPorId(Integer eventoId) throws Exception;
}
