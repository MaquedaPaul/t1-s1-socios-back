package ar.utn.aceleradora.gestion.socios;


import ar.utn.aceleradora.gestion.socios.dto.SocioDTO;
import ar.utn.aceleradora.gestion.socios.modelos.departamento.Categoria;
import ar.utn.aceleradora.gestion.socios.modelos.departamento.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.repositorios.CategoriaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.DepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import ar.utn.aceleradora.gestion.socios.servicios.SocioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class AceleradoraUtnBaGestionDeSociosApplication {
	public static void main(String[] args) {
		SpringApplication.run(AceleradoraUtnBaGestionDeSociosApplication.class, args);
	}



	@Bean
	public CommandLineRunner dataInicial(CategoriaRepository categoriaRepo,
										 DepartamentoRepository departamentoRepo,
										 SocioRepository socioRepo,SocioService socioService) {
		return args -> {

			Random random = new Random();
			String[] nombres = {"AxiomTech",
					"QuantumLeap",
					"NexaWave",
					"PrimeVertex",
					"DynaCore",
					"ZenithLink",
					"AlphaStream",
					"OrionPulse",
					"MysticNode",
					"GalacticNest",
					"HelixSpiral",
					"EchoStar",
					"VortexMatrix",
					"NimbusCloud",
					"CelestialBurst"
			};

			TipoSocio[] tipos = TipoSocio.values();
			String[] mails = {"example1@domain.com", "example2@domain.com", "example3@domain.com", "example4@domain.com"};

			Departamento departamento1 = new Departamento("Departamento 1");
			Departamento departamento2 = new Departamento("Departamento 2");
			Departamento departamento3 = new Departamento("Departamento 3");

			departamentoRepo.saveAll(Arrays.asList(
					departamento1, departamento2, departamento3
			));
			Categoria[] categorias = {
					new Categoria( "Normativa"),
					new Categoria( "RRII"),
					new Categoria( "Ambiente"),
					new Categoria( "Comité Ejecutivo"),
					new Categoria( "Comisión Directiva"),
					new Categoria( "Empresas"),
					new Categoria( "Cámaras"),
					new Categoria( "Presidentes"),
					new Categoria( "Gerentes"),
					new Categoria( "Comex"),
					new Categoria( "Pyme"),
					new Categoria( "Fiscal"),
					new Categoria( "Laborales"),
					new Categoria( "Legales"),
					new Categoria( "Envases")
			};
			categoriaRepo.saveAll(Arrays.asList(categorias));

			List<Categoria> categoriasDisponibles = categoriaRepo.findAll();

			// Tipos de socios disponibles
			TipoSocio[] tiposSocios = TipoSocio.values();

			for (int i = 0; i < 15; i++) {
				// Selecciona un tipo de socio aleatorio
				TipoSocio tipoSocio = tiposSocios[random.nextInt(tiposSocios.length)];

				// Crea una ubicación ficticia
				Ubicacion ubicacion = new Ubicacion(
						"Calle Ficticia " + (i + 1),
						"Piso " + (i + 1),
						"Depto " + (i + 1),
						"Ciudad Ficticia",
						"Provincia Ficticia",
						"País Ficticio"
				);

				// Crea un socio con datos de prueba
				Socio socio = new Socio(
						"Socio de Prueba " + (i + 1),
						tipoSocio,
						"123456789", // Número de teléfono ficticio
						"socio" + (i + 1) + "@ejemplo.com", // Correo electrónico ficticio
						ubicacion // Asigna la ubicación ficticia al socio
				);

				//TODO: BORRAR, lo puso Mati para probar
				if (socio.getNombre().contains("3") || socio.getNombre().contains("6") || socio.getNombre().contains("9")){
					socio.setActivo(false);
				}
				//*******************************************************

				// Agrega un subconjunto aleatorio de categorías
				List<Categoria> subconjuntoCategorias = new ArrayList<>();
				int numCategorias = random.nextInt(categoriasDisponibles.size());
				for (int j = 0; j < numCategorias; j++) {
					Categoria categoria = categoriasDisponibles.get(j);
					subconjuntoCategorias.add(categoria);
				}
				socio.setCategorias(subconjuntoCategorias);

				// Guarda el socio en la base de datos
				socioRepo.save(socio);
			}

			SocioDTO socioDTO = socioService.obtenerSocio(1);

			if (socioDTO != null) {
				List<String> nombresCategorias = Arrays.asList("Normativa", "RRII");

				// Asigna las categorías al socio TODO: la verdad me gustaria revisar esto, no me gusta que se haga asi
				//porque es rarisimo asignar por un string, pero bueno, es lo que hay
				socioService.agregarCategoriasASocio(socioDTO.getId(), nombresCategorias);
				System.out.println("Categorías agregadas al socio con ID: " + socioDTO.getId());
			} else {
				System.out.println("Socio no encontrado.");
			}

		};


	}



}
