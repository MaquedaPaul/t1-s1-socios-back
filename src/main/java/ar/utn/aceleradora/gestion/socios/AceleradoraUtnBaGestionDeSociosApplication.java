package ar.utn.aceleradora.gestion.socios;



import ar.utn.aceleradora.gestion.socios.repositorios.*;
import ar.utn.aceleradora.gestion.socios.seeds.socios.SocioInitializer;
import ar.utn.aceleradora.gestion.socios.seeds.departamentos.DepartamentoInitializer;
import ar.utn.aceleradora.gestion.socios.seeds.test.initializer.TestDepartamentoInitializer;
import ar.utn.aceleradora.gestion.socios.seeds.test.initializer.TestSocioInitializer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AceleradoraUtnBaGestionDeSociosApplication {
	public static void main(String[] args) {
		SpringApplication.run(AceleradoraUtnBaGestionDeSociosApplication.class, args);
	}


	@Bean
	public CommandLineRunner dataInicial(SocioRepository socioRepository, MembresiaRepository membresiaRepository, MembresiaParticularRepository membresiaParticularRepository, CategoriaRepository categoriaRepository, DepartamentoRepository departamentoRepository, AutoridadRepository autoridadRepository, CoorDepartamentoRepository coorDepartamentoRepository )  {
		Boolean quieroDataInicial = false;
		if(quieroDataInicial){
			TestSocioInitializer testSocioInitializer = new TestSocioInitializer(socioRepository,categoriaRepository,membresiaRepository,membresiaParticularRepository);
			testSocioInitializer.run();
			TestDepartamentoInitializer testDepartamentoInitializer = new TestDepartamentoInitializer(departamentoRepository, autoridadRepository, coorDepartamentoRepository);
			testDepartamentoInitializer.run();

		}
		return null;
    }

	/*@Bean
	public CommandLineRunner dataDePruebaInitialize(SocioRepository socioRepository, MembresiaRepository membresiaRepository, MembresiaParticularRepository membresiaParticularRepository, CategoriaRepository categoriaRepository, DepartamentoRepository departamentoRepository, AutoridadRepository autoridadRepository, CoorDepartamentoRepository coorDepartamentoRepository )  {
		Boolean quieroDataInicial = true;
		if(quieroDataInicial){
			TestSocioInitializer testSocioInitializer = new TestSocioInitializer(socioRepository,categoriaRepository,membresiaRepository,membresiaParticularRepository);
			testSocioInitializer.run();
			TestDepartamentoInitializer testDepartamentoInitializer = new TestDepartamentoInitializer(departamentoRepository, autoridadRepository, coorDepartamentoRepository);
			testDepartamentoInitializer.run();
		}
		return null;
	}*/
}
