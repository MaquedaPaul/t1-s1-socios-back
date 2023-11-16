package ar.utn.aceleradora.gestion.socios.seeds.reservas;

import ar.utn.aceleradora.gestion.socios.modelos.reservas.EstadoReserva;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.Reserva;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.TipoEstadoReserva;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.EstadoReservaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.ReservaRepository;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReservaDataEstadoReservas {
    EstadoReserva estadoReserva1 = new EstadoReserva(TipoEstadoReserva.PENDIENTE, LocalDateTime.of(2023, 11, 1, 14, 15), "motivo 1");
    EstadoReserva estadoReserva2 = new EstadoReserva(TipoEstadoReserva.PENDIENTE, LocalDateTime.of(2023, 11, 2, 16, 15), "motivo 2");
    EstadoReserva estadoReserva3 = new EstadoReserva(TipoEstadoReserva.PENDIENTE, LocalDateTime.of(2023, 11, 3, 15, 15), "motivo 3");
    EstadoReserva estadoReserva4 = new EstadoReserva(TipoEstadoReserva.PENDIENTE, LocalDateTime.of(2023, 11, 4, 18, 15), "motivo 4");
    EstadoReserva estadoReserva5 = new EstadoReserva(TipoEstadoReserva.PENDIENTE, LocalDateTime.of(2023, 11, 5, 17, 15), "motivo 5");
    EstadoReserva estadoReserva6 = new EstadoReserva(TipoEstadoReserva.PENDIENTE, LocalDateTime.of(2023, 11, 6, 11, 15), "motivo 6");
    EstadoReserva estadoReserva7 = new EstadoReserva(TipoEstadoReserva.PENDIENTE, LocalDateTime.of(2023, 11, 7, 13, 15), "motivo 7");
    EstadoReserva estadoReserva8 = new EstadoReserva(TipoEstadoReserva.PENDIENTE, LocalDateTime.of(2023, 11, 8, 12, 15), "motivo 8");

    @Setter
    @Getter
    public List<EstadoReserva> estadoReservas = new ArrayList<>(Arrays.asList(estadoReserva1, estadoReserva2, estadoReserva3, estadoReserva4, estadoReserva5, estadoReserva6, estadoReserva7, estadoReserva8));


    public void cargarEstadosReservas(EstadoReservaRepository estadoReservaRepository){
        estadoReservaRepository.saveAll(estadoReservas);
    }
}
