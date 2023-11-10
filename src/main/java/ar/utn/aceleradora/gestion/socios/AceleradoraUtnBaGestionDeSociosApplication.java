package ar.utn.aceleradora.gestion.socios;



import ar.utn.aceleradora.gestion.socios.repositorios.*;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.AutoridadRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.CoorDepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.eventos.EventoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.eventos.InscriptoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.socios.CategoriaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.socios.MembresiaParticularRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.socios.MembresiaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.socios.SocioRepository;
import ar.utn.aceleradora.gestion.socios.seeds.eventos.EventoInitializer;
import ar.utn.aceleradora.gestion.socios.seeds.socios.SocioInitializer;
import ar.utn.aceleradora.gestion.socios.seeds.departamentos.DepartamentoInitializer;
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
	public CommandLineRunner dataInicial(
			SocioRepository socioRepository, MembresiaRepository membresiaRepository, MembresiaParticularRepository membresiaParticularRepository,
			CategoriaRepository categoriaRepository, DepartamentoRepository departamentoRepository, AutoridadRepository autoridadRepository,
			CoorDepartamentoRepository coorDepartamentoRepository, EventoRepository eventoRepository, InscriptoRepository inscriptoRepository,
			UbicacionRepository ubicacionRepository) throws NoSuchFieldException, IllegalAccessException {
		Boolean quieroDataInicial = false;
		if(quieroDataInicial){
			SocioInitializer socioInitializer = new SocioInitializer(socioRepository,categoriaRepository,membresiaRepository,membresiaParticularRepository);
			socioInitializer.run();
			DepartamentoInitializer departamentoInitializer = new DepartamentoInitializer(socioRepository, autoridadRepository, coorDepartamentoRepository);
			departamentoInitializer.run();
			EventoInitializer eventoInitializer = new EventoInitializer(eventoRepository, inscriptoRepository, departamentoRepository, ubicacionRepository);
			eventoInitializer.run();
		}
		return null;
    }
}
