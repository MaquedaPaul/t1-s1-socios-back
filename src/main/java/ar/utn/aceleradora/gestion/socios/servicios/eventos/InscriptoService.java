package ar.utn.aceleradora.gestion.socios.servicios.eventos;

import ar.utn.aceleradora.gestion.socios.dto.eventos.InscriptoCreateDTO;

public interface InscriptoService {
    Boolean createInscripto(InscriptoCreateDTO inscripto) throws Exception;
}
