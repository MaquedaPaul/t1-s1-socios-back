package ar.utn.aceleradora.gestion.socios.error.socios;

public class SocioNotFoundException extends RuntimeException{
    public SocioNotFoundException(String message) {
        super(message);
    }
}
