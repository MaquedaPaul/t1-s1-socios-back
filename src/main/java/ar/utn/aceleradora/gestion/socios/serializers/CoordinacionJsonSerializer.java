package ar.utn.aceleradora.gestion.socios.serializers;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Coordinacion;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class CoordinacionJsonSerializer extends JsonSerializer<Coordinacion> {

    @Override
    public void serialize(Coordinacion coordinacion, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
            throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("idCoordinacion", coordinacion.getId());
        jsonGenerator.writeObjectField("autoridad", coordinacion.getAutoridad());
        jsonGenerator.writeStringField("icono", coordinacion.getIcono());
        jsonGenerator.writeStringField("nombre", coordinacion.getNombre());
        jsonGenerator.writeNumberField("jerarquia", coordinacion.getJerarquia());
        jsonGenerator.writeObjectField("fechaBaja", coordinacion.getFechaBaja());
        jsonGenerator.writeStringField("descripcion", coordinacion.getDescripcion());
        jsonGenerator.writeEndObject();
    }
}