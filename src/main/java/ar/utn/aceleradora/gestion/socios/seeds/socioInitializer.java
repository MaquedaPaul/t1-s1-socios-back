package ar.utn.aceleradora.gestion.socios.seeds;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.Categoria;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import ar.utn.aceleradora.gestion.socios.modelos.membresia.Membresia;
import ar.utn.aceleradora.gestion.socios.modelos.membresia.MembresiaParticular;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.repositorios.CategoriaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.MembresiaParticularRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.MembresiaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Component
public class socioInitializer implements CommandLineRunner {
    private final SocioRepository socioRepository;
    private final CategoriaRepository categoriaRepository;
    private final MembresiaRepository membresiaRepository;
    private final MembresiaParticularRepository membresiaParticularRepository;
    @Autowired
    public socioInitializer(SocioRepository repositorioEjemplo, CategoriaRepository categoriaRepository, MembresiaRepository membresiaRepository, MembresiaParticularRepository membresiaParticularRepository) {
        this.socioRepository = repositorioEjemplo;
        this.categoriaRepository = categoriaRepository;
        this.membresiaRepository = membresiaRepository;
        this.membresiaParticularRepository =  membresiaParticularRepository;
    }
    public void run() throws Exception {
        List<Socio> sociosAGuardar = new ArrayList<>();
            socioDataSocios dataSocios = new socioDataSocios();
            socioDataMembresias dataMembresias = new socioDataMembresias();
            socioDataCategorias dataCategorias = new socioDataCategorias();
            dataCategorias.cargarCategorias(this.categoriaRepository);
            dataMembresias.cargarMembresias(membresiaParticularRepository);
            dataSocios.cargarSocios(socioRepository, membresiaParticularRepository, categoriaRepository,dataMembresias);
        }

    @Override
    public void run(String... args) throws Exception {

    }
}
