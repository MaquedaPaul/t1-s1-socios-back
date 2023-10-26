package ar.utn.aceleradora.gestion.socios.servicios;

import ar.utn.aceleradora.gestion.socios.dto.EventoCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.EventoUpdateDTO;
import ar.utn.aceleradora.gestion.socios.modelos.evento.Evento;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventoService {

    Boolean crearEvento(EventoCreateDTO evento) throws Exception;

    Boolean editarEvento(EventoUpdateDTO evento, Integer id) throws Exception;

    public List<Evento> listarEventos()throws Exception;
}
