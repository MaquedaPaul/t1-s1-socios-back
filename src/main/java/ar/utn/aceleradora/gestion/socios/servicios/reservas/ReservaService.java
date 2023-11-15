package ar.utn.aceleradora.gestion.socios.servicios.reservas;

import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaUpdateDTO;
import ar.utn.aceleradora.gestion.socios.error.reservas.EstadoReservaNoValidoException;

import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaLimitadoDTO;
import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaCreateDTO;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.Reserva;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservaService {
    void editarReserva(ReservaUpdateDTO reservaUpdateDTO, Integer id) throws EstadoReservaNoValidoException;
    List<ReservaLimitadoDTO> listarReservas();
    void crearReserva(ReservaCreateDTO reservaCreateDTO);

    Reserva obtenerReservaPorCodigoDeSeguimiento(String codigoDeSeguimiento);
}
