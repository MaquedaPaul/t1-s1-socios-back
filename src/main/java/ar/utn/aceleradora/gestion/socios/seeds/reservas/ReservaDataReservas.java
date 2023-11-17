package ar.utn.aceleradora.gestion.socios.seeds.reservas;

import ar.utn.aceleradora.gestion.socios.modelos.reservas.Reserva;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.ReservaRepository;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class ReservaDataReservas {
    Reserva reserva1 = new Reserva("departamento 1", "hotel 1", "descripcion de la reserva 1", LocalDate.of(2023, 11, 1), LocalTime.of(10, 0), LocalTime.of(12, 0), "nombre reservante 1", "mail reservante 1", "telefono reservante 1","");

    Reserva reserva2 = new Reserva("Departamento 2", "Hotel 2", "Descripción de la reserva 2", LocalDate.of(2023, 11, 2), LocalTime.of(11, 0), LocalTime.of(13, 0), "Nombre Reservante 2", "mail2@example.com", "987654321","");

    Reserva reserva3 = new Reserva("Departamento 3", "Hotel 3", "Descripción de la reserva 3", LocalDate.of(2023, 11, 3), LocalTime.of(12, 0), LocalTime.of(14, 0), "Nombre Reservante 3", "mail3@example.com", "111223344","");

    Reserva reserva4 = new Reserva("Departamento 4", "Hotel 4", "Descripción de la reserva 4", LocalDate.of(2023, 11, 4), LocalTime.of(13, 0), LocalTime.of(15, 0), "Nombre Reservante 4", "mail4@example.com", "998877665","");

    Reserva reserva5 = new Reserva("Departamento 5", "Hotel 5", "Descripción de la reserva 5", LocalDate.of(2023, 11, 5), LocalTime.of(14, 0), LocalTime.of(16, 0), "Nombre Reservante 5", "mail5@example.com", "223344556","");

    Reserva reserva6 = new Reserva("Departamento 6", "Hotel 6", "Descripción de la reserva 6", LocalDate.of(2023, 11, 6), LocalTime.of(15, 0), LocalTime.of(17, 0), "Nombre Reservante 6", "mail6@example.com", "556677889","");

    Reserva reserva7 = new Reserva("Departamento 7", "Hotel 7", "Descripción de la reserva 7", LocalDate.of(2023, 11, 7), LocalTime.of(16, 0), LocalTime.of(18, 0), "Nombre Reservante 7", "mail7@example.com", "112233445","");

    Reserva reserva8 = new Reserva("Departamento 8", "Hotel 8", "Descripción de la reserva 8", LocalDate.of(2023, 12, 7), LocalTime.of(16, 0), LocalTime.of(18, 0), "Nombre Reservante 8", "mail8@example.com", "112233445","");


    @Setter
    @Getter
    public List<Reserva> reservas = Arrays.asList(reserva1,reserva2,reserva3,reserva4,reserva5,reserva6,reserva7,reserva8);
    public void cargarReservas(ReservaRepository reservaRepository) {
        cargarCodigos();
        reservaRepository.saveAll(reservas);
    }

    public void cargarCodigos(){
        for(int i=0; i<8; i++)
            reservas.get(i).generarCodigoSeguimiento();
    }
}
