package ar.utn.aceleradora.gestion.socios.seeds.eventos;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.EstadoInscripto;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.Inscripto;
import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.TipoEstadoInscripto;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.eventos.InscriptoRepository;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EventoDataInscriptos {
    @Getter
    List<Inscripto> inscriptos = new ArrayList<>();
    public void cargarInscriptos(InscriptoRepository inscriptoRepository, DepartamentoRepository departamentoRepository, EventoDataEstadosInscriptos dataEstadosInscriptos) {
        generarInscriptosAleatorios();
        asignarSocioInvitante(departamentoRepository);
        asignarEstadosAleatorios(dataEstadosInscriptos);
        inscriptoRepository.saveAll(inscriptos);
    }




    private static String generarNombreAleatorio() {
        String[] nombres = {"Juan", "María", "Carlos", "Ana", "Luis", "Laura", "Pedro", "Carmen", "José", "Sofía",
                "Diego", "Valeria", "Javier", "Elena", "Fernando", "Isabel", "Miguel", "Rosa", "Ricardo", "Alicia"};
        return nombres[new Random().nextInt(nombres.length)];
    }

    private static String generarApellidoAleatorio() {
        String[] apellidos = {"García", "Martínez", "López", "Rodríguez", "Pérez", "Fernández", "González", "Díaz",
                "Hernández", "Torres", "Ruiz", "Cruz", "Sánchez", "Romero", "Jiménez", "Moreno", "Alvarez", "Luna", "Vargas", "Molina"};
        return apellidos[new Random().nextInt(apellidos.length)];
    }

    private static String generarTrabajoAleatorio() {
        String[] trabajos = {"Ingeniero", "Doctor", "Profesor", "Diseñador", "Estudiante", "Programador",
                "Médico", "Abogado", "Arquitecto", "Comerciante", "Enfermero", "Científico", "Actor", "Escritor"};
        return trabajos[new Random().nextInt(trabajos.length)];
    }

    private static String generarCorreoAleatorio(String nombre, String apellido) {
        String[] dominios = {"gmail.com", "yahoo.com", "hotmail.com", "outlook.com", "example.com"};
        return nombre.toLowerCase() + "." + apellido.toLowerCase() + "@" + dominios[new Random().nextInt(dominios.length)];
    }
    private void asignarSocioInvitante(DepartamentoRepository departamentoRepository){
        List <Departamento> departamentos = departamentoRepository.findAll();
        int indiceDepartamento = 0;
        int indiceSocio = 0;

        for (Inscripto inscripto : inscriptos) {
            Socio socioInvitante = departamentos.get(indiceDepartamento).getSociosSuscritos().get(indiceSocio);

            inscripto.setSocioInvitante(socioInvitante);

            indiceSocio++;

            // Si se acaban los socios en el departamento actual, pasamos al siguiente departamento
            if (indiceSocio >= 5 || indiceSocio >= departamentos.get(indiceDepartamento).getSociosSuscritos().size()) {
                indiceSocio = 0;
                indiceDepartamento++;

                // Si se acaban los departamentos, volvemos al primer departamento
                if (indiceDepartamento >= departamentos.size()) {
                    indiceDepartamento = 0;
                }
            }
        }
    }
    private void generarInscriptosAleatorios() {
        Random random = new Random();
        for (int i = 0; i < 50; i++) {
            String nombre = generarNombreAleatorio();
            String apellido = generarApellidoAleatorio();
            String trabajo = generarTrabajoAleatorio();
            String mail = generarCorreoAleatorio(nombre, apellido);
            Inscripto inscripto = new Inscripto(nombre, apellido, trabajo, mail);
            inscriptos.add(inscripto);
        }
    }
    private void asignarEstadosAleatorios(EventoDataEstadosInscriptos dataEstadosInscriptos) {
        List<EstadoInscripto> estadosInscriptos = dataEstadosInscriptos.estadosInscriptos;

        // Asignar estados PENDIENTE a todos los inscriptos
        for (Inscripto inscripto : inscriptos) {
            EstadoInscripto estadoPendiente = obtenerEstadoPorTipo(estadosInscriptos, TipoEstadoInscripto.PENDIENTE);
            inscripto.agregarEstado(estadoPendiente);
        }

        // Seleccionar aleatoriamente algunos inscriptos para tener estados diferentes a PENDIENTE
        Random random = new Random();
        for (Inscripto inscripto : inscriptos) {
            if (random.nextBoolean()) {
                TipoEstadoInscripto tipoEstado = obtenerTipoEstadoAleatorioExceptoPendiente();
                EstadoInscripto estado = obtenerEstadoPorTipo(estadosInscriptos, tipoEstado);
                inscripto.agregarEstado(estado);
            }
        }
    }
    private static TipoEstadoInscripto obtenerTipoEstadoAleatorioExceptoPendiente() {
        TipoEstadoInscripto[] tiposEstados = {TipoEstadoInscripto.CONFIRMADO, TipoEstadoInscripto.ASISTIO, TipoEstadoInscripto.CANCELADO};
        Random random = new Random();
        return tiposEstados[random.nextInt(tiposEstados.length)];
    }

    private static EstadoInscripto obtenerEstadoPorTipo(List<EstadoInscripto> estados, TipoEstadoInscripto tipo) {
        Random random = new Random();

        EstadoInscripto estadoSeleccionado;
        do {
            estadoSeleccionado = estados.get(random.nextInt(estados.size()));
        } while (estadoSeleccionado.getEstado() != tipo);
        return estadoSeleccionado;

    }
}
