package ar.utn.aceleradora.gestion.socios.error.departamentos;

public class DepartamentoNotFoundException extends  RuntimeException {
    public DepartamentoNotFoundException(String message) {
        super(message);
    }
}
