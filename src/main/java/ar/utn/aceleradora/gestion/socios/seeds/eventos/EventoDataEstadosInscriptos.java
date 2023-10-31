package ar.utn.aceleradora.gestion.socios.seeds.eventos;

import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.EstadoInscripto;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.TipoEstadoInscripto;
import ar.utn.aceleradora.gestion.socios.seeds.socios.SocioDataSocios;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EventoDataEstadosInscriptos {
    private static final Logger logger = LoggerFactory.getLogger(SocioDataSocios.class);

    String motivo0 = "N/A";

    String motivo1 = "No estaré disponible para esa fecha";
    String motivo2 = "Surge un compromiso inesperado";
    String motivo3 = "Problemas de salud";
    String motivo4 = "Emergencia familiar";
    String motivo5 = "Falta de interés en el evento";
    String motivo6 = "Conflicto de programación con otro evento";
    String motivo7 = "Problemas de transporte";

    String motivo8 = "Cambio repentino en mis planes";
    String motivo9 = "Problemas financieros";
    String motivo10 = "Inclemencias del tiempo";
    String motivo11 = "Conflictos de trabajo";
    String motivo12 = "Necesidad de cuidar a un familiar";
    String motivo13 = "Problemas de transporte público";
    String motivo14 = "Necesidad de estudiar o trabajar en proyectos urgentes";
    String motivo15 = "Compromisos religiosos u espirituales inesperados";

    @Getter
    List<EstadoInscripto> estadosInscriptos = new ArrayList<>();
    public void cargarEstados() {
        Random random = new Random();


        for (int i = 0; i < 50; i++) {
            TipoEstadoInscripto tipoEstadoInscripto;
            if (i % 3 == 0) {
                tipoEstadoInscripto = TipoEstadoInscripto.CONFIRMADO;
            } else if (i % 3 == 1) {
                tipoEstadoInscripto = TipoEstadoInscripto.ASISTIO;
            } else {
                tipoEstadoInscripto = TipoEstadoInscripto.PENDIENTE;
            }

            LocalDateTime fechaAleatoria = LocalDateTime.now().minusDays(random.nextInt(100));
            EstadoInscripto estadoInscripto = new EstadoInscripto(tipoEstadoInscripto, fechaAleatoria, motivo0);
            estadosInscriptos.add(estadoInscripto);
        }



        for (int i = 1; i < 15; i++) {
            int numeroMotivo = random.nextInt(16) + 1;
            String nombreVariable = "motivo" + i;
            String motivo = null;
            try {

               motivo = (String) getClass().getDeclaredField(nombreVariable).get(this);
            }
            catch (NoSuchFieldException | IllegalAccessException e) {
                        logger.error("Error al cargar " + nombreVariable, e);
            }
            LocalDateTime fechaAleatoria = LocalDateTime.now().minusDays(random.nextInt(100));
            EstadoInscripto estadoInscripto = new EstadoInscripto(TipoEstadoInscripto.CANCELADO, fechaAleatoria, motivo);
            estadosInscriptos.add(estadoInscripto);
        }


    }


}
