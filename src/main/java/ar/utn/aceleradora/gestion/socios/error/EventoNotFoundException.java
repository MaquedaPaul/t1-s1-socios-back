package ar.utn.aceleradora.gestion.socios.error;

public class EventoNotFoundException extends  RuntimeException {
    public EventoNotFoundException(String message) {
        super(message);
    }
}
