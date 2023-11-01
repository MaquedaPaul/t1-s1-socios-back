package ar.utn.aceleradora.gestion.socios.serializers;

import ar.utn.aceleradora.gestion.socios.modelos.eventos.inscriptos.Inscripto;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.io.IOException;

public class InscriptoSerializer extends JsonSerializer<Inscripto> {


    public void serialize(Inscripto inscripto, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumber(inscripto.getId());
        jsonGenerator.writeString(inscripto.getNombre());
        jsonGenerator.writeString(inscripto.getApellido());
        jsonGenerator.writeString(inscripto.getMail());
        jsonGenerator.writeString(inscripto.getTrabajo());
        jsonGenerator.writeObject(inscripto.getEstados());
        jsonGenerator.writeObject(inscripto.getSocioInvitante());

        jsonGenerator.writeEndObject();


    }

}
