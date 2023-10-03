package ar.utn.aceleradora.gestion.socios.controladores;


import ar.utn.aceleradora.gestion.socios.servicios.georef.ServicioGeoref;
import ar.utn.aceleradora.gestion.socios.servicios.georef.entities.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.utn.aceleradora.gestion.socios.servicios.georef.entities.Provincia;

import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/provincia")
@RestController
public class UbicacionController {

    @Autowired
    private ServicioGeoref servicioGeoref;

    public UbicacionController(ServicioGeoref servicioGeoref) {
        this.servicioGeoref = servicioGeoref.instancia();
    }


    @GetMapping("/api/provincia")
    public ResponseEntity<List<String>> listadoProvincias() throws IOException {


        List<Provincia> provincias = servicioGeoref.listadoDeProvincias().provincias;
        List<String> nombresProvincias = provincias.stream()
                .map(Provincia::getNombre)
                .sorted()
                .collect(Collectors.toList());
        return new ResponseEntity<>(nombresProvincias, HttpStatus.OK);

    }

    @GetMapping("/municipios")
    public ResponseEntity<List<String>> listadoMunicipios(@RequestBody String nombre) throws IOException {

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


    @GetMapping("/municipios2")
    public ResponseEntity<List<String>> listadoMunicipios2(@RequestBody String nombre) throws IOException {

        ListadoDeProvincias listadoDeProvincias = null;
        Optional<Provincia> provincia = listadoDeProvincias.provinciaDeNombre(nombre);



        Provincia provinciaSeleccionada = provincia.get();
        ListadoDeMunicipios municipiosDeLaProvincia = servicioGeoref.listadoDeMunicipiosDeProvincia(provinciaSeleccionada);

        List<Municipio> municipios = municipiosDeLaProvincia.municipios;
        List<String> nombresMunicipios = municipios.stream()
                .map(Municipio::getNombre)
                .sorted()
                .collect(Collectors.toList());
        return new ResponseEntity<>(nombresMunicipios, HttpStatus.OK);


    }
    @GetMapping("/provincias")
    public ResponseEntity<ListadoDeProvincias> obtenerProvincias() throws IOException {
        ListadoDeProvincias provincias = servicioGeoref.listadoDeProvincias();
        return new ResponseEntity<>(provincias, HttpStatus.OK);
    }

    @GetMapping("/municipios3")
    public ResponseEntity<ListadoDeMunicipios> obtenerMunicipios(@RequestBody Provincia provincia) throws IOException {

        ListadoDeProvincias provincias = servicioGeoref.listadoDeProvincias();

        Optional<Provincia> provinciaEncontrada = provincias.provinciaDeId(provincia.getId());

        if(provinciaEncontrada.isPresent())
        {
            Provincia provinciaSeleccionada = provinciaEncontrada.get();
            ListadoDeMunicipios municipios = servicioGeoref.listadoDeMunicipiosDeProvincia(provinciaSeleccionada);
            return new ResponseEntity<>(municipios, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping("/{id}/municipios")
    public ResponseEntity<ListadoDeMunicipios> obtenerMunicipiosDeProvincia(@PathVariable Integer id) throws IOException {
        ListadoDeProvincias provincias = servicioGeoref.listadoDeProvincias();

        Optional<Provincia> provinciaEncontrada = provincias.provinciaDeId(id);

        if (provinciaEncontrada.isPresent()) {
            Provincia provinciaSeleccionada = provinciaEncontrada.get();
            ListadoDeMunicipios municipios = servicioGeoref.listadoDeMunicipiosDeProvincia(provinciaSeleccionada);
            return new ResponseEntity<>(municipios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/nombresMunicipio")
    public ResponseEntity<List<String>> obtenerNombresDeProvincias(@RequestParam("nombre") String nombre) throws IOException {
        ListadoDeProvincias provincias = servicioGeoref.listadoDeProvincias();

        List<String> nombresDeMunicipios = new ArrayList<>();

        for (Provincia provincia : provincias.getProvincias()) {
            if (provincia.getNombre().equalsIgnoreCase(nombre)) {
                ListadoDeMunicipios municipios = servicioGeoref.listadoDeMunicipiosDeProvincia(provincia);
                for (Municipio municipio : municipios.getMunicipios()) {
                    nombresDeMunicipios.add(municipio.getNombre());
                }
                break; // Terminar la búsqueda después de encontrar la provincia
            }
        }

        if (!nombresDeMunicipios.isEmpty()) {
            return new ResponseEntity<>(nombresDeMunicipios, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}





