package ar.utn.aceleradora.gestion.socios.error;

public class DepartamentoNotFoundException extends  RuntimeException {
    public DepartamentoNotFoundException(String message) {
        super(message);
    }
}
