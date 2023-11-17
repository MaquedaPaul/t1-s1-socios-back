package ar.utn.aceleradora.gestion.socios.seeds.reservas;

import ar.utn.aceleradora.gestion.socios.modelos.reservas.Recurso;
import ar.utn.aceleradora.gestion.socios.repositorios.reservas.RecursoRepository;

public class ReservaDataRecursos {
    Recurso recurso1 = new Recurso("Notebook", "Dispositivo electrónico para tomar notas y colaborar.");
    Recurso recurso2 = new Recurso("Mesa", "Superficie plana para trabajar y colocar objetos.");
    Recurso recurso3 = new Recurso("Silla", "Asiento para una persona.");
    Recurso recurso4 = new Recurso("Marcadores", "Instrumentos de escritura para pizarrones.");
    Recurso recurso5 = new Recurso("Pizarrón", "Superficie para escribir con tiza o marcadores.");

    public void cargarRecursos(RecursoRepository recursoRepository){
        recursoRepository.save(recurso1);
        recursoRepository.save(recurso2);
        recursoRepository.save(recurso3);
        recursoRepository.save(recurso4);
        recursoRepository.save(recurso5);

    }



}
