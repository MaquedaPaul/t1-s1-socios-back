package ar.utn.aceleradora.gestion.socios.controladores.reservas;

import ar.utn.aceleradora.gestion.socios.servicios.reservas.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/reservas")
@CrossOrigin(origins= "*")
@RestController
public class ReservasController {
    private final ReservaService reservaService;

    @Autowired
    public ReservasController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }
}
