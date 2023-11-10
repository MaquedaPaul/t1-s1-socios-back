package ar.utn.aceleradora.gestion.socios.error.departamentos;

public class DepartamentoNotSavedException extends RuntimeException{
    public DepartamentoNotSavedException(String message) {
        super(message);
    }
}
