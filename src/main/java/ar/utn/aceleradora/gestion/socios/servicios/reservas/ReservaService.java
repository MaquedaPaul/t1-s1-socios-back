package ar.utn.aceleradora.gestion.socios.servicios.reservas;

import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaCreateDTO;
import org.springframework.stereotype.Service;

@Service
public interface ReservaService {
    void crearReserva(ReservaCreateDTO reservaCreateDTO);
}
