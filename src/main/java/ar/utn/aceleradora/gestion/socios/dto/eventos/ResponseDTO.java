package ar.utn.aceleradora.gestion.socios.dto.eventos;

import lombok.Getter;

@Getter
public class ResponseDTO {
    private final String message;

    private final String status;

    private final Integer codeHttp;

    public ResponseDTO(String message, String status, Integer codeHttp) {
        this.message = message;
        this.status = status;
        this.codeHttp = codeHttp;
    }
}

