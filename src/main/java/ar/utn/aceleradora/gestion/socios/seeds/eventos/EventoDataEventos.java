package ar.utn.aceleradora.gestion.socios.seeds.eventos;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.EstadoEvento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.Evento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.TipoModalidad;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.Inscripto;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.eventos.EventoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.UbicacionRepository;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EventoDataEventos {

    Evento evento1 = new Evento("Evento 1", "Descripción del evento 1", LocalDate.of(2023, 11, 1), LocalDate.of(2023, 11, 3), TipoModalidad.HIBRIDO, LocalTime.of(10, 0));
    Evento evento2 = new Evento("Evento 2", "Descripción del evento 2", LocalDate.of(2023, 12, 5), LocalDate.of(2023, 12, 7), TipoModalidad.VIRTUAL, LocalTime.of(11, 30));
    Evento evento3 = new Evento("Evento 3", "Descripción del evento 3", LocalDate.of(2023, 10, 15), LocalDate.of(2023, 10, 17), TipoModalidad.PRESENCIAL, LocalTime.of(9, 0));
    Evento evento4 = new Evento("Evento 4", "Descripción del evento 4", LocalDate.of(2023, 9, 20), LocalDate.of(2023, 9, 22), TipoModalidad.HIBRIDO, LocalTime.of(5, 15));

    Evento evento5 = new Evento("Evento 5", "Descripción del evento 5", LocalDate.of(2023, 8, 10), LocalDate.of(2023, 8, 12), TipoModalidad.HIBRIDO, LocalTime.of(12, 20));
    Evento evento6 = new Evento("Evento 6", "Descripción del evento 6", LocalDate.of(2023, 7, 5), LocalDate.of(2023, 7, 7), TipoModalidad.VIRTUAL, LocalTime.of(10, 0));
    Evento evento7 = new Evento("Evento 7", "Descripción del evento 7", LocalDate.of(2023, 6, 15), LocalDate.of(2023, 6, 17), TipoModalidad.PRESENCIAL, LocalTime.of(16, 0));
    Evento evento8 = new Evento("Evento 8", "Descripción del evento 8", LocalDate.of(2023, 5, 20), LocalDate.of(2023, 5, 22), TipoModalidad.HIBRIDO, LocalTime.of(10, 8));

    @Setter
    @Getter
    public List<Evento> eventos = Arrays.asList(evento1,evento2,evento3,evento4,evento5,evento6,evento7,evento8);
    public void cargarEventos(EventoDataInscriptos dataInscriptos, DepartamentoRepository departamentoRepository, EventoDataEstadosEventos dataEstadoEventos, EventoRepository eventoRepository, UbicacionRepository ubicacionRepository) throws NoSuchFieldException, IllegalAccessException {
        List<Departamento> departamentos = departamentoRepository.findAll();
        List<Ubicacion> ubicaciones = ubicacionRepository.findAll();
        for(int i=0; i<8; i++)
            eventos.get(i).setUbicacion(ubicaciones.get(i));

        evento1.setDepartamentos(departamentos);
        //evento2 no tendrá departamentos
        evento3.addDepartamento(departamentos.get(1)); // evento 3 solo tendrá 1 departamento
        evento4.setDepartamentos(departamentos);
        //evento5 no tendrá departamentos
        evento6.addDepartamento(departamentos.get(5)); // evento 6 solo tendrá 1 departamento
        evento7.setDepartamentos(departamentos);
        //evento8 no tendrá departamentos

        //Todos tendrán pendientes
        List<EstadoEvento> pendientes =  dataEstadoEventos.getPendientes();
        List<EstadoEvento> confirmados = dataEstadoEventos.getConfirmados();
        List<EstadoEvento> cancelados = dataEstadoEventos.getCancelados();
        List<EstadoEvento> finalizados = dataEstadoEventos.getFinalizados();
        List<EstadoEvento> pendientesRevision = dataEstadoEventos.getPendientesRevision();
        for (int i = 1; i <= 8; i++) {
            // Obtén el nombre de la variable del socio usando reflexión
            String nombreVariable = "evento" + i;
            Evento evento;
                evento = (Evento) getClass().getDeclaredField(nombreVariable).get(this);
            Random random = new Random();
            int indiceAleatorio = random.nextInt(pendientes.size());
            EstadoEvento estadoAleatorio = dataEstadoEventos.removerElementoPendientes(indiceAleatorio);
            evento.agregarEstado(estadoAleatorio);
        }
        //evento1.agregarEstado(); solo tendrá pendiente
        evento2.agregarEstado(confirmados.get(0)); //solo tendrá confirmado
        evento3.agregarEstado(cancelados.get(0)); //solo tendrá cancelado
        evento4.agregarEstado(finalizados.get(0)); //solo tendrá finalizado
        evento5.agregarEstado(pendientesRevision.get(0)); //solo tendrá pendiente con motivo en revisión
        //Evento 6 tendrá todos los tipos de estados
        evento6.agregarEstado(pendientesRevision.get(1));
        evento6.agregarEstado(confirmados.get(1));
        evento6.agregarEstado(finalizados.get(1));
        evento6.agregarEstado(cancelados.get(1));
        //evento 7 tendrá repetido confirmado
        evento7.agregarEstado(confirmados.get(2));
        evento7.agregarEstado(pendientesRevision.get(2));
        evento7.agregarEstado(confirmados.get(3));
        //evento 8 solo tendrá pendiente
        List<Inscripto>inscriptos= dataInscriptos.getInscriptos();


        for (int i = 1; i <= 8; i++) {
            Random random = new Random();
            // Obtén el nombre de la variable del evento usando reflexión
            String nombreVariable = "evento" + i;
            Evento evento = (Evento) getClass().getDeclaredField(nombreVariable).get(this);

            // Genera un número aleatorio entre 1 y 15
            int cantidadInscriptos = random.nextInt(4) + 1;

            // Agrega entre 1 y 15 inscriptos aleatorios al evento
            for (int j = 0; j < cantidadInscriptos; j++) {
                int indiceAleatorio = random.nextInt(inscriptos.size());
                Inscripto inscriptoAleatorio = inscriptos.remove(indiceAleatorio);
                evento.agregarInscripto(inscriptoAleatorio);
            }
        }
        eventoRepository.saveAll(eventos);
    }
}
