package ar.utn.aceleradora.gestion.socios.error;
import ar.utn.aceleradora.gestion.socios.error.departamentos.*;
import ar.utn.aceleradora.gestion.socios.error.eventos.EventoNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.reservas.EstadoReservaNoValidoException;
import ar.utn.aceleradora.gestion.socios.error.reservas.ReservaNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.reservas.EspacioFisicoNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.reservas.RecursoNotFoundException;
import ar.utn.aceleradora.gestion.socios.error.reservas.ReservaNotCreatedException;
import ar.utn.aceleradora.gestion.socios.error.socios.CategoriaNotCreatedException;
import ar.utn.aceleradora.gestion.socios.error.socios.SocioNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//El GlobalExceptionHandler maneja todas las excepciones nuestras para que se pueda comprender los mensajes de error mejor al usuario.
@ControllerAdvice
public class GlobalExceptionHandler {

    //Autoridad
    @ExceptionHandler({AutoridadNotFoundException.class})
    public ResponseEntity<Object> handleAutoridadNotFoundException(AutoridadNotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    //Coordinacion
    @ExceptionHandler({CoordinacionNotFoundException.class})
    public ResponseEntity<Object> handleCoordinacionNotFoundException(CoordinacionNotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    //Departamento
    @ExceptionHandler({DepartamentoNotFoundException.class})
    public ResponseEntity<Object> handleDepartamentoNotFoundException(DepartamentoNotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
    @ExceptionHandler({DepartamentoNotCreatedException.class})
    public ResponseEntity<Object> handleDepartamentoNotCreatedException(DepartamentoNotCreatedException exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
    @ExceptionHandler({DepartamentoNotSavedException.class})
    public ResponseEntity<Object> handleDepartamentoNotSavedException(DepartamentoNotSavedException exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    //Socio
    @ExceptionHandler({SocioNotFoundException.class})
    public ResponseEntity<Object> handleSocioNotFoundException(SocioNotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    //Categoria
    @ExceptionHandler({CategoriaNotCreatedException.class})
    public ResponseEntity<Object> handleCategoriaNotCreatedException(CategoriaNotCreatedException exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    //EVENTO
    @ExceptionHandler({EventoNotFoundException.class})
    public ResponseEntity<Object> handleEventoNotFoundException(EventoNotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
    @ExceptionHandler({ReservaNotFoundException.class})
    public ResponseEntity<Object> handleReservaNotFoundException(ReservaNotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
    @ExceptionHandler({ReservaNotCreatedException.class})
    public ResponseEntity<Object> handleReservaNotCreatedException(ReservaNotCreatedException exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
    @ExceptionHandler({EspacioFisicoNotFoundException.class})
    public ResponseEntity<Object> handleEspacioFisicoNotFoundException(EspacioFisicoNotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
    @ExceptionHandler({RecursoNotFoundException.class})
    public ResponseEntity<Object> handleRecursoNotFoundException(RecursoNotFoundException exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }


    @ExceptionHandler({EstadoReservaNoValidoException.class})
    public ResponseEntity<Object> handleEventoNotFoundException(EstadoReservaNoValidoException exception){
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }



}
