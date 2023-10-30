package ar.utn.aceleradora.gestion.socios.servicios.eventos;

import ar.utn.aceleradora.gestion.socios.dto.eventos.InscriptoCreateDTO;

public interface InscriptoService {
    void createInscripto(InscriptoCreateDTO inscripto) throws Exception;
}
