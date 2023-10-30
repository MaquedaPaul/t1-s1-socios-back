package ar.utn.aceleradora.gestion.socios.controladores;
import ar.utn.aceleradora.gestion.socios.dto.EventoCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.EventoUpdateDTO;
import ar.utn.aceleradora.gestion.socios.dto.ResponseDTO;
import ar.utn.aceleradora.gestion.socios.servicios.eventos.EventoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.utn.aceleradora.gestion.socios.servicios.eventos.EventoServiceImpl;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.Evento;

import java.util.List;


@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    private EventoService eventoService;

    private final EventoServiceImpl  eventoService;

    @Autowired
    public EventoController(EventoServiceImpl eventoService) {
        this.eventoService = eventoService;
    }

    @PostMapping({"", "/"})
    public Boolean crearEvento(@RequestBody EventoCreateDTO evento) {
        try {
         eventoService.crearEvento(evento);
            return ResponseEntity.ok(new ResponseDTO("Evento creado satisfactoriamente", "CREATE", 200)).hasBody();
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage(), "SECCESS", 500), HttpStatus.INTERNAL_SERVER_ERROR).hasBody();
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

    @GetMapping({"", "/"})
    public List<Evento> listarEventos() {//Creo que falta parametro en listar
        try {
        eventoService.listarEventos();
            return (List<Evento>) ResponseEntity.ok();
        } catch (Exception e) {
            return (List<Evento>) ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}