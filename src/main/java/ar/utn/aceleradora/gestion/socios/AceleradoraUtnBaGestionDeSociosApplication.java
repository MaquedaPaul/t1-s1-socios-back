package ar.utn.aceleradora.gestion.socios;


import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.repositorios.CategoriaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.UbicacionRepository;
import ar.utn.aceleradora.gestion.socios.servicios.SocioService;
import com.sun.tools.javac.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Random;

@SpringBootApplication
public class AceleradoraUtnBaGestionDeSociosApplication {
	public static void main(String[] args) {
		SpringApplication.run(AceleradoraUtnBaGestionDeSociosApplication.class, args);

	}

/*
	@Bean
	public CommandLineRunner dataInicial(CategoriaRepository categoriaRepo,
										 SocioRepository socioRepo,
										 UbicacionRepository ubicacionRepo) {
		return args -> {

			Random random = new Random();

			String[] nombres = {"Carri Corp", "AlphaTech", "BravoSoft", "Charlie Systems", "Delta Devs"};
			TipoSocio[] tipos = TipoSocio.values();
			String[] mails = {"example1@domain.com", "example2@domain.com", "example3@domain.com", "example4@domain.com"};

			for (int i = 0; i < 15; i++) {
				String nombreRandom = nombres[random.nextInt(nombres.length)];
				TipoSocio tipoRandom = tipos[random.nextInt(tipos.length)];
				int telefonoRandom = 100000000 + random.nextInt(900000000);
				String mailRandom = "random" + random.nextInt(1000) + "@domain.com";

				Ubicacion ubicacion = new Ubicacion(
						"Dirección " + random.nextInt(100),
						"Piso " + random.nextInt(10),
						"Dpto " + (char) (65 + random.nextInt(26)),
						"Localidad " + random.nextInt(100),
						"Provincia " + random.nextInt(5),
						"País " + random.nextInt(3)
				);
				ubicacionRepo.save(ubicacion);

				Socio socio = new Socio(
						nombreRandom,
						tipoRandom,
						telefonoRandom,
						mailRandom,
						ubicacion
				);
				socioRepo.save(socio);
			}
		};


	}
 */



}
