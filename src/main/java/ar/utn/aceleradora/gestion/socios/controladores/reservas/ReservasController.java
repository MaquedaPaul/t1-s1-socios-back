package ar.utn.aceleradora.gestion.socios.controladores.reservas;

import ar.utn.aceleradora.gestion.socios.dto.ResponseDTO;
import ar.utn.aceleradora.gestion.socios.dto.eventos.EventoCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaCreateDTO;
import ar.utn.aceleradora.gestion.socios.servicios.reservas.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/reservas")
@CrossOrigin(origins= "*")
@RestController
public class ReservasController {
    private final ReservaService reservaService;

    @Autowired
    public ReservasController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping({"", "/"})
    public ResponseEntity<ResponseDTO> crearReserva(@RequestBody ReservaCreateDTO reservaCreateDTO) {
            reservaService.crearReserva(reservaCreateDTO);
            return new ResponseEntity<>(new ResponseDTO("Reserva creada satisfactoriamente", "CREATE", 201),HttpStatus.CREATED);
    }


}
