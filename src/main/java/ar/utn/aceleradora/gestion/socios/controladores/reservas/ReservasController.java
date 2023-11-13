package ar.utn.aceleradora.gestion.socios.controladores.reservas;


import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaLimitadoDTO;
import ar.utn.aceleradora.gestion.socios.servicios.reservas.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/")
    public ResponseEntity<List<ReservaLimitadoDTO>> listarReservas() {
            List<ReservaLimitadoDTO> reservas = reservaService.listarReservas();
            return new ResponseEntity<>(reservas, HttpStatus.OK);
    }
}
