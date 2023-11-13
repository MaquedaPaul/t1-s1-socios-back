package ar.utn.aceleradora.gestion.socios.servicios.reservas;


import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaLimitadoDTO;
import ar.utn.aceleradora.gestion.socios.dto.reservas.ReservaCreateDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReservaService {
    List<ReservaLimitadoDTO> listarReservas();
    void crearReserva(ReservaCreateDTO reservaCreateDTO);
}
