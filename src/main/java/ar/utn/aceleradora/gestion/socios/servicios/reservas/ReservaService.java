package ar.utn.aceleradora.gestion.socios.servicios.reservas;

import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaUpdateDTO;
import ar.utn.aceleradora.gestion.socios.error.reservas.EstadoReservaNoValidoException;
import org.springframework.stereotype.Service;

@Service
public interface ReservaService {
    void editarReserva(ReservaUpdateDTO reservaUpdateDTO, Integer id) throws EstadoReservaNoValidoException;
}
