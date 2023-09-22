package ar.utn.aceleradora.gestion.socios;

//import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import ar.utn.aceleradora.gestion.socios.servicios.SocioService;
import ar.utn.aceleradora.gestion.socios.servicios.UbicacionService;

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

	@Autowired
	private UbicacionService ubicacionService;


	@Test
	public void testGuardarUbicacion(){
		Ubicacion ubicacion = new Ubicacion("Ejemplazo","Ejemplo","Ejemplo","Ejemplo","Ejemplo","Ejemplo");

		Ubicacion ubicacionGuardada = ubicacionService.agregarUbicacion(ubicacion);
	}

	@Test
	public void testObtenerUbicacion(){
		Ubicacion ubicacionRecuperada = ubicacionService.obtenerUbicacion(1);

		assertThat(ubicacionRecuperada).isNotNull();
		assertThat(ubicacionRecuperada.getDireccion()).isEqualTo("Ejemplazo");
		assertThat(ubicacionRecuperada.getPais()).isEqualTo("Ejemplo");
		assertThat(ubicacionRecuperada.getPiso()).isEqualTo("Ejemplo");
		assertThat(ubicacionRecuperada.getDepartamento()).isEqualTo("Ejemplo");
		assertThat(ubicacionRecuperada.getLocalidad()).isEqualTo("Ejemplo");
		assertThat(ubicacionRecuperada.getProvincia()).isEqualTo("Ejemplo");
	}




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
