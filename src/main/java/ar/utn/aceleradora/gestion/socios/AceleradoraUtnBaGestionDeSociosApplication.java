package ar.utn.aceleradora.gestion.socios;


import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import ar.utn.aceleradora.gestion.socios.servicios.SocioService;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AceleradoraUtnBaGestionDeSociosApplication {
	public static void main(String[] args) {
		SpringApplication.run(AceleradoraUtnBaGestionDeSociosApplication.class, args);

/*
		private SocioRepository socioRepository;
		private SocioService socioService;

  		public Main(SocioRepository socioRepository, SocioService socioService) {
			this.socioRepository = socioRepository;
			this.socioService = socioService;
  		}



		public static void main(String[] args) {
			SpringApplication.run(AceleradoraUtnBaGestionDeSociosApplication.class, args);
		}

		@Bean
		public CommandLineRunner dataInicial(CategoriaRepository categoriaRepo, ProveedorRepository proveedorRepo) {
			return args -> {
				String[] categorias = {
						"Herramientas manuales",
						"Sin categoría"
				};
				for (String nombre : categorias) {
					if (!categoriaRepo.existsById(nombre)) {
						Categoria cat = new Categoria();
						cat.setName(nombre);
						categoriaRepo.save(cat);
					}

*/
	}


}
