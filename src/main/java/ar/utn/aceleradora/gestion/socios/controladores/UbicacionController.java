package ar.utn.aceleradora.gestion.socios.controladores;

import ar.utn.aceleradora.gestion.socios.servicios.georef.ServicioGeoref;
import ar.utn.aceleradora.gestion.socios.servicios.georef.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.utn.aceleradora.gestion.socios.servicios.georef.entities.Provincia;

import java.io.IOException;

import java.util.List;
import java.util.Optional;

@RequestMapping("/api/provincia")
@RestController
public class UbicacionController {

    private final GeorefService georefService;

    @Autowired
    public UbicacionController(GeorefService georefService) {
        this.georefService = georefService;
    }

    @GetMapping("/api/provincia")
    public ResponseEntity<List<String>> listadoProvincias() throws IOException {
        ServicioGeoref servicioGeoref = ServicioGeoref.instancia();

        ListadoDeProvincias listadoDeProvinciasArgentinas = servicioGeoref.listadoDeProvincias();

        listadoDeProvinciasArgentinas.provincias.sort((p1, p2) -> p1.id >= p2.id ? 1 : -1);

        List<String> provinciasNombre = null;

        for (Provincia unaProvincia : listadoDeProvinciasArgentinas.provincias) {
            provinciasNombre.add(unaProvincia.nombre);
        }
        return (ResponseEntity<List<String>>) provinciasNombre;

    }

    @GetMapping("/api/{provincia}")
    public ResponseEntity<List<String>> listadoProvincias(@PathVariable String nombre) throws IOException {
        ServicioGeoref servicioGeoref = ServicioGeoref.instancia();

        ListadoDeProvincias listadoDeProvinciasArgentinas = servicioGeoref.listadoDeProvincias();
        List<String> municipioProvincias = null;

        Optional<Provincia> posibleProvincia = listadoDeProvinciasArgentinas.provinciaDeNombre(nombre);

        if (posibleProvincia.isPresent()) {
            Provincia provinciaSeleccionada = posibleProvincia.get();
            ListadoDeMunicipios municipiosDeLaProvincia = servicioGeoref.listadoDeMunicipiosDeProvincia(provinciaSeleccionada);



            for (Municipio unMunicipio : municipiosDeLaProvincia.municipios) {
                municipioProvincias.add(unMunicipio.nombre);
            }

        }

        return (ResponseEntity<List<String>>) municipioProvincias;
    }
}












