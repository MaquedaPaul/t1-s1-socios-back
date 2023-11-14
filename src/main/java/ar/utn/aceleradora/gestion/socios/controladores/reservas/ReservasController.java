package ar.utn.aceleradora.gestion.socios.controladores.reservas;

import ar.utn.aceleradora.gestion.socios.dto.ResponseDTO;
import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaUpdateDTO;
import ar.utn.aceleradora.gestion.socios.error.reservas.EstadoReservaNoValidoException;

import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaLimitadoDTO;
import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaCreateDTO;
import ar.utn.aceleradora.gestion.socios.servicios.reservas.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/reservas")
@CrossOrigin(origins= "*")
@RestController
public class ReservasController {
    private final ReservaService reservaService;

    @Autowired
    public ReservasController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PatchMapping({"{id}"})
    public ResponseEntity<ResponseDTO> editarReserva(@RequestBody ReservaUpdateDTO reservaUpdateDTO, @PathVariable Integer id) throws EstadoReservaNoValidoException {
            reservaService.editarReserva(reservaUpdateDTO, id);
            return new ResponseEntity<>(new ResponseDTO("Reserva editada satisfactoriamente", "SUCCESS", 200),HttpStatus.NO_CONTENT);
    }


    @GetMapping({"", "/"})
    public ResponseEntity<List<ReservaLimitadoDTO>> listarReservas() {
            List<ReservaLimitadoDTO> reservas = reservaService.listarReservas();
            return new ResponseEntity<>(reservas, HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<ResponseDTO> crearReserva(@RequestBody ReservaCreateDTO reservaCreateDTO) {
            reservaService.crearReserva(reservaCreateDTO);
            return new ResponseEntity<>(new ResponseDTO("Reserva creada satisfactoriamente", "CREATE", 201),HttpStatus.CREATED);
    }


}
