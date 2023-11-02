package ar.utn.aceleradora.gestion.socios.servicios.eventos;

import ar.utn.aceleradora.gestion.socios.dto.eventos.InscriptoCreateDTO;
import ar.utn.aceleradora.gestion.socios.dto.eventos.InscriptoUpdateDTO;

public interface InscriptoService {
    void createInscripto(InscriptoCreateDTO inscripto, Integer idEvento) throws Exception;
    Boolean updateInscripto(InscriptoUpdateDTO inscripto, Integer id) throws Exception;
}
