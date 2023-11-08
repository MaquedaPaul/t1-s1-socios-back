package ar.utn.aceleradora.gestion.socios.error.reservas;

public class ReservaNotFoundException extends RuntimeException{
    ReservaNotFoundException(String message){
        super(message);
    }
}
