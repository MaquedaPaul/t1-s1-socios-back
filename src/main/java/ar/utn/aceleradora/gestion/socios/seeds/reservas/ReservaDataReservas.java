package ar.utn.aceleradora.gestion.socios.seeds.reservas;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.EspacioFisico;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.RecursoSolicitado;
import ar.utn.aceleradora.gestion.socios.modelos.reservas.Reserva;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.EspacioFisicoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.RecursoSolicitadoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.ReservaRepository;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class ReservaDataReservas {
    Reserva reserva1 = new Reserva("Descripcion de la reserva 1", LocalDate.of(2023, 11, 1), LocalTime.of(10, 0), LocalTime.of(12, 0), "Nombre reservante 1", "mail1@example.com", "987654321");

    Reserva reserva2 = new Reserva("Descripción de la reserva 2", LocalDate.of(2023, 11, 2), LocalTime.of(11, 0), LocalTime.of(13, 0), "Nombre Reservante 2", "mail2@example.com", "987654321");

    Reserva reserva3 = new Reserva("Descripción de la reserva 3", LocalDate.of(2023, 11, 3), LocalTime.of(12, 0), LocalTime.of(14, 0), "Nombre Reservante 3", "mail3@example.com", "111223344");

    Reserva reserva4 = new Reserva("Descripción de la reserva 4", LocalDate.of(2023, 11, 4), LocalTime.of(13, 0), LocalTime.of(15, 0), "Nombre Reservante 4", "mail4@example.com", "998877665");

    Reserva reserva5 = new Reserva("Descripción de la reserva 5", LocalDate.of(2023, 11, 5), LocalTime.of(14, 0), LocalTime.of(16, 0), "Nombre Reservante 5", "mail5@example.com", "223344556");

    Reserva reserva6 = new Reserva("Descripción de la reserva 6", LocalDate.of(2023, 11, 6), LocalTime.of(15, 0), LocalTime.of(17, 0), "Nombre Reservante 6", "mail6@example.com", "556677889");

    Reserva reserva7 = new Reserva("Descripción de la reserva 7", LocalDate.of(2023, 11, 7), LocalTime.of(16, 0), LocalTime.of(18, 0), "Nombre Reservante 7", "mail7@example.com", "112233445");

    Reserva reserva8 = new Reserva("Descripción de la reserva 8", LocalDate.of(2023, 12, 7), LocalTime.of(16, 0), LocalTime.of(18, 0), "Nombre Reservante 8", "mail8@example.com", "112233445");


    @Setter
    @Getter
    public List<Reserva> reservas = Arrays.asList(reserva1,reserva2,reserva3,reserva4,reserva5,reserva6,reserva7,reserva8);
    public void cargarReservas(ReservaRepository reservaRepository, DepartamentoRepository departamentoRepository, EspacioFisicoRepository espacioFisicoRepository, ReservaDataRecursosSolicitados reservaDataRecursosSolicitados) {
        List<Departamento> departamentos = departamentoRepository.findAll();
        List<EspacioFisico> espacioFisicos = espacioFisicoRepository.findAll();
        List<RecursoSolicitado> recursosSolicitados = reservaDataRecursosSolicitados.getRecursoSolicitados();
        reserva1.setDepartamentoAsociado(departamentos.get(0));
        reserva2.setDepartamentoAsociado(departamentos.get(1));
        reserva3.setDepartamentoAsociado(departamentos.get(2));
        reserva4.setDepartamentoAsociado(departamentos.get(3));
        reserva5.setDepartamentoAsociado(departamentos.get(4));
        reserva6.setDepartamentoAsociado(departamentos.get(5));
        reserva7.setDepartamentoAsociado(departamentos.get(6));
        reserva8.setDepartamentoAsociado(departamentos.get(5));
        reserva1.setEspacioFisico(espacioFisicos.get(0));
        reserva2.setEspacioFisico(espacioFisicos.get(1));
        reserva3.setEspacioFisico(espacioFisicos.get(2));
        reserva4.setEspacioFisico(espacioFisicos.get(3));
        reserva5.setEspacioFisico(espacioFisicos.get(4));
        reserva6.setEspacioFisico(espacioFisicos.get(5));
        reserva7.setEspacioFisico(espacioFisicos.get(6));
        reserva8.setEspacioFisico(espacioFisicos.get(7));

        reserva1.setRecursosSolicitados(recursosSolicitados.subList(0,1));
        reserva2.setRecursosSolicitados(recursosSolicitados.subList(1,2));
        reserva3.setRecursosSolicitados(recursosSolicitados.subList(3,4));
        reserva4.setRecursosSolicitados(recursosSolicitados.subList(5,6));
        reserva5.setRecursosSolicitados(recursosSolicitados.subList(7,8));
        reserva6.setRecursosSolicitados(recursosSolicitados.subList(9,11));
        reserva7.setRecursosSolicitados(recursosSolicitados.subList(11,12));
        reserva8.setRecursosSolicitados(recursosSolicitados.subList(12,13));
        reservaRepository.saveAll(reservas);
        cargarCodigos();
        reservaRepository.saveAll(reservas);
    }

    public void cargarCodigos(){
        for(int i=0; i<8; i++)
            reservas.get(i).generarCodigoSeguimiento();
    }
}