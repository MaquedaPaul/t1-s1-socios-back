package ar.utn.aceleradora.gestion.socios.serializers;


import ar.utn.aceleradora.gestion.socios.modelos.eventos.Evento;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class SocioLimitadoSerializer extends JsonSerializer<Socio> {
    @Override
    public void serialize(Socio socio, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("id",socio.getId());
        jsonGenerator.writeStringField("nombre",socio.getNombre());
        jsonGenerator.writeStringField("mail",socio.getMail());
        jsonGenerator.writeEndObject();

    }
}
