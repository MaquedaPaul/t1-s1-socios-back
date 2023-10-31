package ar.utn.aceleradora.gestion.socios.seeds.eventos;

import ar.utn.aceleradora.gestion.socios.modelos.eventos.EstadoEvento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoEstadoEvento;

import lombok.Getter;

import java.time.LocalDate;

import java.util.Arrays;
import java.util.List;

public class EventoDataEstadosEventos {
    TipoEstadoEvento tipoEvento1 = TipoEstadoEvento.PENDIENTE;
    TipoEstadoEvento tipoEvento2 = TipoEstadoEvento.CONFIRMADO;
    TipoEstadoEvento tipoEvento3 = TipoEstadoEvento.FINALIZADO;
    TipoEstadoEvento tipoEvento4 = TipoEstadoEvento.CANCELADO;
    String motivo1 = "Nueva creación de evento";
    String motivo2 = "Revisión de evento";
    String motivo3 = "Se realizará el evento";
    String motivo7 = "Se finalizó satisfactoriamente";
    String motivo4 = "Falta de participantes";
    String motivo5 = "Falta de coordinadores";
    String motivo6 = "Se pospone a una fecha posterior por situación externa a COPAL";



    EstadoEvento estadoEvento1 = new EstadoEvento(tipoEvento1, LocalDate.now().minusDays(425), motivo1);
    EstadoEvento estadoEvento2 = new EstadoEvento(tipoEvento1, LocalDate.now().minusDays(200), motivo1);
    EstadoEvento estadoEvento3 = new EstadoEvento(tipoEvento1, LocalDate.now().minusDays(600), motivo1);
    EstadoEvento estadoEvento4 = new EstadoEvento(tipoEvento1, LocalDate.now().minusDays(300), motivo1);

    EstadoEvento estadoEvento5 = new EstadoEvento(tipoEvento1, LocalDate.now().minusDays(135), motivo2);
    EstadoEvento estadoEvento6 = new EstadoEvento(tipoEvento1, LocalDate.now().minusDays(280), motivo2);
    EstadoEvento estadoEvento7 = new EstadoEvento(tipoEvento1, LocalDate.now().minusDays(50), motivo2);
    EstadoEvento estadoEvento8 = new EstadoEvento(tipoEvento1, LocalDate.now().minusDays(180), motivo2);

    EstadoEvento estadoEvento9 = new EstadoEvento(tipoEvento2, LocalDate.now().minusDays(180), motivo3);
    EstadoEvento estadoEvento10 = new EstadoEvento(tipoEvento2, LocalDate.now().minusDays(90), motivo3);
    EstadoEvento estadoEvento11 = new EstadoEvento(tipoEvento2, LocalDate.now().minusDays(300), motivo3);
    EstadoEvento estadoEvento12 = new EstadoEvento(tipoEvento2, LocalDate.now().minusDays(150), motivo3);

    EstadoEvento estadoEvento13 = new EstadoEvento(tipoEvento3, LocalDate.now().minusDays(200), motivo7);
    EstadoEvento estadoEvento14 = new EstadoEvento(tipoEvento3, LocalDate.now().minusDays(180), motivo7);
    EstadoEvento estadoEvento15 = new EstadoEvento(tipoEvento3, LocalDate.now().minusDays(250), motivo7);
    EstadoEvento estadoEvento16 = new EstadoEvento(tipoEvento3, LocalDate.now().minusDays(300), motivo7);

    EstadoEvento estadoEvento17 = new EstadoEvento(tipoEvento4, LocalDate.now().minusDays(180), motivo4);
    EstadoEvento estadoEvento18 = new EstadoEvento(tipoEvento4, LocalDate.now().minusDays(210), motivo5);
    EstadoEvento estadoEvento19 = new EstadoEvento(tipoEvento4, LocalDate.now().minusDays(240), motivo6);
    EstadoEvento estadoEvento20 = new EstadoEvento(tipoEvento4, LocalDate.now().minusDays(270), motivo4);
    EstadoEvento estadoEvento21 = new EstadoEvento(tipoEvento4, LocalDate.now().minusDays(300), motivo5);
    EstadoEvento estadoEvento22 = new EstadoEvento(tipoEvento4, LocalDate.now().minusDays(330), motivo6);
    EstadoEvento estadoEvento23 = new EstadoEvento(tipoEvento4, LocalDate.now().minusDays(360), motivo4);
    EstadoEvento estadoEvento24 = new EstadoEvento(tipoEvento4, LocalDate.now().minusDays(390), motivo5);

    @Getter
    List<EstadoEvento> pendientes = Arrays.asList(estadoEvento1,estadoEvento2,estadoEvento3,estadoEvento4);
    @Getter
    List<EstadoEvento> pendientesRevision = Arrays.asList(estadoEvento5,estadoEvento6,estadoEvento7,estadoEvento8);
    @Getter
    List<EstadoEvento> confirmados = Arrays.asList(estadoEvento9,estadoEvento10,estadoEvento11,estadoEvento12);
    @Getter
    List<EstadoEvento> finalizados = Arrays.asList(estadoEvento13,estadoEvento14,estadoEvento15,estadoEvento16);
    @Getter
    List<EstadoEvento> cancelados = Arrays.asList(estadoEvento17,estadoEvento18,estadoEvento19,estadoEvento20,estadoEvento21,estadoEvento22,estadoEvento23,estadoEvento24);


}
