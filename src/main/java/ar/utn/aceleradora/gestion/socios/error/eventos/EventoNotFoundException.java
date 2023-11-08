package ar.utn.aceleradora.gestion.socios.error.eventos;

public class EventoNotFoundException extends  RuntimeException {
    public EventoNotFoundException(String message) {
        super(message);
    }
}
