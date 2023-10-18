package ar.utn.aceleradora.gestion.socios.dto;

import lombok.Getter;

public class ResponseDTO {
    @Getter
    private String message;

    @Getter
    private String status;

    @Getter
    private Integer codeHttp;

    public ResponseDTO(String message, String status, Integer codeHttp) {
        this.message = message;
        this.status = status;
        this.codeHttp = codeHttp;
    }
}

