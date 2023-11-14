package ar.utn.aceleradora.gestion.socios.error.reservas;

public class ReservaNotFoundException extends RuntimeException{
    public ReservaNotFoundException(String message){
        super(message);
    }
}
