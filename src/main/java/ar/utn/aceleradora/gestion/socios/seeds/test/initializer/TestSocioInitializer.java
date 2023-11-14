package ar.utn.aceleradora.gestion.socios.seeds.test.initializer;

import ar.utn.aceleradora.gestion.socios.repositorios.CategoriaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.MembresiaParticularRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.MembresiaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import ar.utn.aceleradora.gestion.socios.seeds.test.testData.TestDataSocios;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;



@Component
public class TestSocioInitializer implements CommandLineRunner {
    private final SocioRepository socioRepository;
    private final CategoriaRepository categoriaRepository;
    private final MembresiaRepository membresiaRepository;
    private final MembresiaParticularRepository membresiaParticularRepository;

    @Autowired
    public TestSocioInitializer(SocioRepository socioRepository, CategoriaRepository categoriaRepository, MembresiaRepository membresiaRepository, MembresiaParticularRepository membresiaParticularRepository) {
        this.socioRepository = socioRepository;
        this.categoriaRepository = categoriaRepository;
        this.membresiaRepository = membresiaRepository;
        this.membresiaParticularRepository =  membresiaParticularRepository;
    }


    public void run(){
        TestDataSocios dataSocios = new TestDataSocios();

        dataSocios.cargarCategorias(this.categoriaRepository);
        dataSocios.cargarMembresias(this.membresiaRepository);
        dataSocios.cargarSociosyMembresias(this.socioRepository,this.membresiaParticularRepository);

    }

    @Override
    public void run(String... args){

    }
}
