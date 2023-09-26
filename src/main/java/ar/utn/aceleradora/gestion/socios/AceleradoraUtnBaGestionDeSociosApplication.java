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
import ar.utn.aceleradora.gestion.socios.repositorios.UbicacionRepository;
import ar.utn.aceleradora.gestion.socios.servicios.CategoriaService;
import ar.utn.aceleradora.gestion.socios.servicios.SocioService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class AceleradoraUtnBaGestionDeSociosApplication {
	public static void main(String[] args) {
		SpringApplication.run(AceleradoraUtnBaGestionDeSociosApplication.class, args);

	}

	@Bean
	public CommandLineRunner dataInicial(CategoriaRepository categoriaRepo, CategoriaService categoriaService,
																			 DepartamentoRepository departamentoRepo,
																			 SocioRepository socioRepo,SocioService socioService,
										 									 UbicacionRepository ubicacionRepo) {
		return args -> {

			Random random = new Random();

			String[] nombres = {"Carri Corp", "AlphaTech", "BravoSoft", "Charlie Systems", "Delta Devs"};
			TipoSocio[] tipos = TipoSocio.values();
			String[] mails = {"example1@domain.com", "example2@domain.com", "example3@domain.com", "example4@domain.com"};

			Departamento departamento1 = new Departamento("Departamento 1", null);
			Departamento departamento2 = new Departamento("Departamento 2", null);
			Departamento departamento3 = new Departamento("Departamento 3", null);

			departamentoRepo.saveAll(Arrays.asList(
					departamento1, departamento2, departamento3
			));
			Categoria[] categorias = {
					new Categoria(departamento1, "Normativa"),
					new Categoria(departamento1, "RRII"),
					new Categoria(departamento2, "Ambiente"),
					new Categoria(departamento2, "Comité Ejecutivo"),
					new Categoria(departamento3, "Comisión Directiva"),
					new Categoria(departamento3, "Empresas"),
					new Categoria(departamento3, "Cámaras"),
					new Categoria(departamento3, "Presidentes"),
					new Categoria(departamento3, "Gerentes"),
					new Categoria(departamento3, "Comex"),
					new Categoria(departamento3, "Pyme"),
					new Categoria(departamento3, "Fiscal"),
					new Categoria(departamento3, "Laborales"),
					new Categoria(departamento3, "Legales"),
					new Categoria(departamento3, "Envases")
			};
			categoriaRepo.saveAll(Arrays.asList(categorias));

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

				Socio socio = new Socio(
						nombreRandom,
						tipoRandom,
						telefonoRandom,
						mailRandom,
						ubicacion
				);
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
