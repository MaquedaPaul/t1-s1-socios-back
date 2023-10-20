package ar.utn.aceleradora.gestion.socios;

//import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.dto.SocioDTO;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import ar.utn.aceleradora.gestion.socios.servicios.SocioServiceImpl;
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
	private SocioServiceImpl socioService;

	@Autowired
	private UbicacionService ubicacionService;


	@Test
	public void testGuardarUbicacion(){
		Ubicacion ubicacion = new Ubicacion("Ejemplo","Ejemplo","Ejemplo","Ejemplo","Ejemplo");

		Ubicacion ubicacionGuardada = ubicacionService.agregarUbicacion(ubicacion);
	}

	@Test
	public void testObtenerUbicacion(){
		Ubicacion ubicacionRecuperada = ubicacionService.obtenerUbicacion(1);

		assertThat(ubicacionRecuperada).isNotNull();
		assertThat(ubicacionRecuperada.getDireccion()).isEqualTo("Argentina");

		assertThat(ubicacionRecuperada.getPiso()).isEqualTo("Ejemplo");
		assertThat(ubicacionRecuperada.getDepartamento()).isEqualTo("Ejemplo");
		assertThat(ubicacionRecuperada.getLocalidad()).isEqualTo("Ejemplo");
		assertThat(ubicacionRecuperada.getProvincia()).isEqualTo("Ejemplo");
	}

	@Test
	public void testActualizarUbicacion(){
		Ubicacion ubicacion = new Ubicacion("Ejemplo","Ejemplo","Ejemplo","Ejemplo","Ejemplo");
		ubicacion.setId(1);

		Ubicacion ubicacionActualizada = ubicacionService.actualizarUbicacion(ubicacion);

		assertThat(ubicacionActualizada).isNotNull();
		assertThat(ubicacionActualizada.getDireccion()).isEqualTo("Ejemplon");

		assertThat(ubicacionActualizada.getPiso()).isEqualTo("Ejemplo");
		assertThat(ubicacionActualizada.getDepartamento()).isEqualTo("Ejemplo");
		assertThat(ubicacionActualizada.getLocalidad()).isEqualTo("Ejemplo");
		assertThat(ubicacionActualizada.getProvincia()).isEqualTo("Ejemplo");
	}

	@Test
	public void testEliminarUbicacion(){
		ubicacionService.eliminarUbicacion(1);
	}


	/*
	@Test
	public void testGuardarSocio(){
		SocioAdherente socio = new SocioAdherente();
		socio.setNombre("Ejemplo");
		socio.setTipoSocio(TipoSocio.SOCIO_ADHERENTE);
		socio.setTelefono("123456");
		socio.setMail("Ejemplo");
		//socio.setNombrePresidente("Ejemplo");
		socio.setUbicacion(ubicacionService.obtenerUbicacion(1));

		Socio socioGuardado = socioRepository.save(socio);

		assertThat(socioGuardado).isNotNull();
		assertThat(socioGuardado.getNombre()).isEqualTo("Ejemplo");
		assertThat(socioGuardado.getTipoSocio()).isEqualTo(TipoSocio.SOCIO_ADHERENTE);
		assertThat(socioGuardado.getTelefono()).isEqualTo(123456);
		assertThat(socioGuardado.getMail()).isEqualTo("Ejemplo");
		//assertThat(socioGuardado.getNombrePresidente()).isEqualTo("Ejemplo");
		assertThat(socioGuardado.getUbicacion()).isEqualTo(ubicacionService.obtenerUbicacion(1));
	}*/


	@Test
	public void testObtenerSocio(){

		SocioDTO socio = socioService.obtenerSocio(1);

		assertThat(socio.getNombre()).isEqualTo("Ejemplo");
		assertThat(socio.getTelefono()).isEqualTo(123456);
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
