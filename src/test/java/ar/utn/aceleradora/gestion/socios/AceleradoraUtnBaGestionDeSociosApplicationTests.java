package ar.utn.aceleradora.gestion.socios;

//import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import ar.utn.aceleradora.gestion.socios.servicios.SocioService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AceleradoraUtnBaGestionDeSociosApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private SocioRepository socioRepository;

	@Autowired
	private SocioService socioService;
/*
	@Test
	public void testGuardarSocioPlenario() {
		// Crea un objeto Socioplenario
		SocioPlenario entidad = new Socio();
		entidad.setNombreEmpresa("Ejemplo");
		entidad.setNombrePresidente("Ejemplo");
		entidad.setTelefono(123456);
		entidad.setMail("Ejemplo");

		Socio socioGuardado = socioService.guardarSocio(entidad);


	}

	@Test
	public void testObtenerSocioPlenario() {
		SocioPlenario socioRecuperado = socioService.getSocioPlenarioPorId(1);

		// Verifica que el SocioPlenario se haya guardado y recuperado correctamente
		assertThat(socioRecuperado).isNotNull();
		assertThat(socioRecuperado.getNombreEmpresa()).isEqualTo("Ejemplo");
		assertThat(socioRecuperado.getNombrePresidente()).isEqualTo("Ejemplo");
		assertThat(socioRecuperado.getTelefono()).isEqualTo(123456);
		assertThat(socioRecuperado.getMail()).isEqualTo("Ejemplo");
	}
*/


}
