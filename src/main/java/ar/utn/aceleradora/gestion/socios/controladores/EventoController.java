package ar.utn.aceleradora.gestion.socios.controladores;
import ar.utn.aceleradora.gestion.socios.dto.ResponseDTO;
import ar.utn.aceleradora.gestion.socios.dto.eventos.*;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoEstadoEvento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoModalidad;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.TipoEstadoInscripto;
import ar.utn.aceleradora.gestion.socios.servicios.eventos.EventoService;
import ar.utn.aceleradora.gestion.socios.servicios.eventos.InscriptoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@CrossOrigin(origins= "*")
@RequestMapping("/eventos")
public class EventoController {

    private final EventoService eventoService;
    private final InscriptoService inscriptoService;

    @Autowired
    public EventoController(EventoService eventoService, InscriptoService inscriptoService) {
        this.eventoService = eventoService;
        this.inscriptoService = inscriptoService;
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
    public ResponseEntity<EventoLimitadoDTO> listarEvento(@PathVariable UUID id) {
        try {
            EventoLimitadoDTO eventoLimitadoDTO = eventoService.listarEvento(id);
            return ResponseEntity.ok(eventoLimitadoDTO);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PostMapping("/{id}/inscriptos")
    public ResponseEntity<ResponseDTO> inscribirInscripto(@PathVariable Integer id, @RequestBody InscriptoCreateDTO inscripto) {
        try {
            inscriptoService.createInscripto(inscripto, id);
            return ResponseEntity.ok(new ResponseDTO("Inscripción exitosa", "CREATE", 200));
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage(), "INTERNAL_SERVER_ERROR", 500), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/{id}/inscriptos/{id_inscripto}")
    public ResponseEntity<ResponseDTO> editarInscripto(@PathVariable Integer id, @PathVariable Integer id_inscripto, @RequestBody InscriptoUpdateDTO inscripto) {
        try {
            inscriptoService.updateInscripto(inscripto, id_inscripto);
            return ResponseEntity.ok(new ResponseDTO("Inscripto editado satisfactoriamente", "SUCCESS", 200));
        } catch (Exception e) {
            return new ResponseEntity<>(new ResponseDTO(e.getMessage(), "INTERNAL_SERVER_ERROR", 500), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/modalidades")
    public ResponseEntity<List<TipoModalidad>> listarModalidades() {
        try {
            List<TipoModalidad> modalidades = eventoService.listasModalidades();
            return ResponseEntity.ok(modalidades);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/estadosEventos")
    public ResponseEntity<List<TipoEstadoEvento>> listarEstadosEventos() {
        try {
            List<TipoEstadoEvento> estadosEventos = eventoService.listarEstadosEventos();
            return ResponseEntity.ok(estadosEventos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/estadosInscriptos")
    public ResponseEntity<List<TipoEstadoInscripto>> listarEstadosInscriptos() {
        try {
            List<TipoEstadoInscripto> estadosInscriptos = eventoService.listarEstadosInscriptos();
            return ResponseEntity.ok(estadosInscriptos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}