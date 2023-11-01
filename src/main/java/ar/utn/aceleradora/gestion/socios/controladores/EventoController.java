package ar.utn.aceleradora.gestion.socios.controladores;
import ar.utn.aceleradora.gestion.socios.dto.eventos.EventoCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.eventos.EventoUpdateDTO;
import ar.utn.aceleradora.gestion.socios.dto.eventos.ResponseDTO;
import ar.utn.aceleradora.gestion.socios.dto.eventos.EventoLimitadoDTO;
import ar.utn.aceleradora.gestion.socios.dto.eventos.ListaEventoDTO;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.Evento;
import ar.utn.aceleradora.gestion.socios.servicios.eventos.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.utn.aceleradora.gestion.socios.servicios.eventos.EventoServiceImpl;

import java.util.List;


@RestController
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;

    @Autowired
    public EventoController(EventoService eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping({"", "/"})
    public Boolean crearEvento(@RequestBody EventoCreateDTO evento) {
        try {
         eventoService.crearEvento(evento);
            return ResponseEntity.ok(new ResponseDTO("Evento creado satisfactoriamente", "CREATE", 200)).hasBody();
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage(), "ERROR", 500), HttpStatus.INTERNAL_SERVER_ERROR).hasBody();
        }
    }

    @PatchMapping({"{id}"})
    public Boolean editarEvento(@RequestBody EventoUpdateDTO evento, @PathVariable Integer id) {
        try {
        eventoService.editarEvento(evento, id);
            return ResponseEntity.ok(new ResponseDTO("Evento editado satisfactoriamente", "SUCCESS", 200)).hasBody();
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage(), "INTERNAL_SERVER_ERROR", 500), HttpStatus.INTERNAL_SERVER_ERROR).hasBody();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<ListaEventoDTO>> listarEventos() {
        try {
            List<ListaEventoDTO> eventos = eventoService.listarEventos();
            return ResponseEntity.ok(eventos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<EventoLimitadoDTO> listarEvento(@PathVariable Integer id) {
        try {
            Evento evento = eventoService.listarEvento(id);
            EventoLimitadoDTO eventoLimitadoDTO = new EventoLimitadoDTO();
            eventoLimitadoDTO.setEvento(evento);
            eventoLimitadoDTO.setInvitados(evento.getInvitados());
            eventoLimitadoDTO.setDepartamentos(evento.getDepartamentos());
            eventoLimitadoDTO.setInscriptos(evento.getInscriptos());
            return ResponseEntity.ok(eventoLimitadoDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}