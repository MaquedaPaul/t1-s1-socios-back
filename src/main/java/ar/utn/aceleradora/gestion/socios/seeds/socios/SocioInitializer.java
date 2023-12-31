package ar.utn.aceleradora.gestion.socios.seeds.socios;

import ar.utn.aceleradora.gestion.socios.repositorios.socios.CategoriaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.socios.MembresiaParticularRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.socios.MembresiaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.socios.SocioRepository;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;



@Component
public class SocioInitializer implements CommandLineRunner {
    private final SocioRepository socioRepository;
    private final CategoriaRepository categoriaRepository;
    private final MembresiaRepository membresiaRepository;
    private final MembresiaParticularRepository membresiaParticularRepository;
    @Autowired
    public SocioInitializer(SocioRepository repositorioEjemplo, CategoriaRepository categoriaRepository, MembresiaRepository membresiaRepository, MembresiaParticularRepository membresiaParticularRepository) {
        this.socioRepository = repositorioEjemplo;
        this.categoriaRepository = categoriaRepository;
        this.membresiaRepository = membresiaRepository;
        this.membresiaParticularRepository =  membresiaParticularRepository;
    }
    public void run() {
            SocioDataSocios dataSocios = new SocioDataSocios();
            SocioDataMembresias dataMembresias = new SocioDataMembresias();
            SocioDataCategorias dataCategorias = new SocioDataCategorias();
            dataCategorias.cargarCategorias(this.categoriaRepository);
            dataMembresias.cargarMembresias(membresiaParticularRepository, membresiaRepository);
            dataSocios.cargarSocios(socioRepository, membresiaParticularRepository, categoriaRepository,dataMembresias);
        }

    @Override
    public void run(String... args){

    }
}
