package ar.utn.aceleradora.gestion.socios.error;

public class SocioNotFoundException extends RuntimeException{
    public SocioNotFoundException(String message) {
        super(message);
    }
}
