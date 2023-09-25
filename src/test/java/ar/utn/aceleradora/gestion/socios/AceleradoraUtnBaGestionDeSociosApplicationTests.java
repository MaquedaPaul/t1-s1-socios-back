package ar.utn.aceleradora.gestion.socios;

//import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.dto.SocioDTO;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.SocioAdherente;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
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
		Ubicacion ubicacion = new Ubicacion("Argentina","Ejemplo","Ejemplo","Ejemplo","Ejemplo","Ejemplo");

		Ubicacion ubicacionGuardada = ubicacionService.agregarUbicacion(ubicacion);
	}

	@Test
	public void testObtenerUbicacion(){
		Ubicacion ubicacionRecuperada = ubicacionService.obtenerUbicacion(1);

		assertThat(ubicacionRecuperada).isNotNull();
		assertThat(ubicacionRecuperada.getDireccion()).isEqualTo("Argentina");
		assertThat(ubicacionRecuperada.getPais()).isEqualTo("Ejemplo");
		assertThat(ubicacionRecuperada.getPiso()).isEqualTo("Ejemplo");
		assertThat(ubicacionRecuperada.getDepartamento()).isEqualTo("Ejemplo");
		assertThat(ubicacionRecuperada.getLocalidad()).isEqualTo("Ejemplo");
		assertThat(ubicacionRecuperada.getProvincia()).isEqualTo("Ejemplo");
	}

	@Test
	public void testActualizarUbicacion(){
		Ubicacion ubicacion = new Ubicacion("Ejemplon","Ejemplo","Ejemplo","Ejemplo","Ejemplo","Ejemplo");
		ubicacion.setId(1);

		Ubicacion ubicacionActualizada = ubicacionService.actualizarUbicacion(ubicacion);

		assertThat(ubicacionActualizada).isNotNull();
		assertThat(ubicacionActualizada.getDireccion()).isEqualTo("Ejemplon");
		assertThat(ubicacionActualizada.getPais()).isEqualTo("Ejemplo");
		assertThat(ubicacionActualizada.getPiso()).isEqualTo("Ejemplo");
		assertThat(ubicacionActualizada.getDepartamento()).isEqualTo("Ejemplo");
		assertThat(ubicacionActualizada.getLocalidad()).isEqualTo("Ejemplo");
		assertThat(ubicacionActualizada.getProvincia()).isEqualTo("Ejemplo");
	}

	@Test
	public void testEliminarUbicacion(){
		ubicacionService.eliminarUbicacion(1);
	}


	@Test
	public void testGuardarSocio(){
		SocioAdherente socio = new SocioAdherente();
		socio.setNombre("Ejemplo");
		socio.setTipoSocio(TipoSocio.SOCIO_ADHERENTE);
		socio.setTelefono(123456);
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
	}


	@Test
	public void testObtenerSocio(){

		SocioDTO socio = socioService.obtenerSocio(1);

		assertThat(socio.getNombre()).isEqualTo("Ejemplo");
		assertThat(socio.getTelefono()).isEqualTo(123456);
	}


	@Test
	public void testGuardarMuchosSocios(){
		SocioAdherente socio = new SocioAdherente();
		socio.setNombre("Ejemplo");
		socio.setTipoSocio(TipoSocio.SOCIO_ADHERENTE);
		socio.setTelefono(123456);
		socio.setMail("Ejemplo");
		//socio.setNombrePresidente("Ejemplo");
		socio.setUbicacion(ubicacionService.obtenerUbicacion(1));

		Socio socioGuardado = socioRepository.save(socio);

		SocioAdherente socio2 = new SocioAdherente();
		socio.setNombre("Hola");
		socio.setTipoSocio(TipoSocio.SOCIO_ADHERENTE);
		socio.setTelefono(123456);
		socio.setMail("Ejemplo");
		//socio.setNombrePresidente("Ejemplo");
		socio.setUbicacion(ubicacionService.obtenerUbicacion(1));

		Socio socioGuardado2 = socioRepository.save(socio2);

		SocioAdherente socio3 = new SocioAdherente();
		socio.setNombre("Ejemplo");
		socio.setTipoSocio(TipoSocio.SOCIO_ADHERENTE);
		socio.setTelefono(123456);
		socio.setMail("Ejemplo");
		//socio.setNombrePresidente("Ejemplo");
		socio.setUbicacion(ubicacionService.obtenerUbicacion(1));

		Socio socioGuardado3 = socioRepository.save(socio3);

		SocioAdherente socio4 = new SocioAdherente();
		socio.setNombre("Ejemplo");
		socio.setTipoSocio(TipoSocio.SOCIO_ADHERENTE);
		socio.setTelefono(123456);
		socio.setMail("Ejemplo");
		//socio.setNombrePresidente("Ejemplo");
		socio.setUbicacion(ubicacionService.obtenerUbicacion(1));

		Socio socioGuardado4 = socioRepository.save(socio4);

		SocioAdherente socio5 = new SocioAdherente();
		socio.setNombre("Ejemplo");
		socio.setTipoSocio(TipoSocio.SOCIO_ADHERENTE);
		socio.setTelefono(123456);
		socio.setMail("Ejemplo");
		//socio.setNombrePresidente("Ejemplo");
		socio.setUbicacion(ubicacionService.obtenerUbicacion(1));

		Socio socioGuardado5 = socioRepository.save(socio5);

		SocioAdherente socio6 = new SocioAdherente();
		socio.setNombre("Ejemplo");
		socio.setTipoSocio(TipoSocio.SOCIO_ADHERENTE);
		socio.setTelefono(123456);
		socio.setMail("Ejemplo");
		//socio.setNombrePresidente("Ejemplo");
		socio.setUbicacion(ubicacionService.obtenerUbicacion(1));

		Socio socioGuardado6 = socioRepository.save(socio6);

		SocioAdherente socio7 = new SocioAdherente();
		socio.setNombre("Ejemplo");
		socio.setTipoSocio(TipoSocio.SOCIO_ADHERENTE);
		socio.setTelefono(123456);
		socio.setMail("Ejemplo");
		//socio.setNombrePresidente("Ejemplo");
		socio.setUbicacion(ubicacionService.obtenerUbicacion(1));


		Socio socioGuardado7 = socioRepository.save(socio7);

		SocioAdherente socio8 = new SocioAdherente();
		socio.setNombre("Ejemplo");
		socio.setTipoSocio(TipoSocio.SOCIO_ADHERENTE);
		socio.setTelefono(123456);
		socio.setMail("Ejemplo");
		//socio.setNombrePresidente("Ejemplo");
		socio.setUbicacion(ubicacionService.obtenerUbicacion(1));
		SocioAdherente socio9 = new SocioAdherente();
		socio.setNombre("Ejemplo");
		socio.setTipoSocio(TipoSocio.SOCIO_ADHERENTE);
		socio.setTelefono(123456);
		socio.setMail("Ejemplo");
		//socio.setNombrePresidente("Ejemplo");
		socio.setUbicacion(ubicacionService.obtenerUbicacion(1));
		SocioAdherente socio10 = new SocioAdherente();
		socio.setNombre("Ejemplo");
		socio.setTipoSocio(TipoSocio.SOCIO_ADHERENTE);
		socio.setTelefono(123456);
		socio.setMail("Ejemplo");
		//socio.setNombrePresidente("Ejemplo");
		socio.setUbicacion(ubicacionService.obtenerUbicacion(1));
		SocioAdherente socio11 = new SocioAdherente();
		socio.setNombre("Ejemplo");
		socio.setTipoSocio(TipoSocio.SOCIO_ADHERENTE);
		socio.setTelefono(123456);
		socio.setMail("Ejemplo");
		//socio.setNombrePresidente("Ejemplo");
		socio.setUbicacion(ubicacionService.obtenerUbicacion(1));
		SocioAdherente socio12 = new SocioAdherente();
		socio.setNombre("Ejemplo");
		socio.setTipoSocio(TipoSocio.SOCIO_ADHERENTE);
		socio.setTelefono(123456);
		socio.setMail("Ejemplo");
		//socio.setNombrePresidente("Ejemplo");
		socio.setUbicacion(ubicacionService.obtenerUbicacion(1));
		SocioAdherente socio13 = new SocioAdherente();
		socio.setNombre("Ejemplo");
		socio.setTipoSocio(TipoSocio.SOCIO_ADHERENTE);
		socio.setTelefono(123456);
		socio.setMail("Ejemplo");
		//socio.setNombrePresidente("Ejemplo");
		socio.setUbicacion(ubicacionService.obtenerUbicacion(1));
		SocioAdherente socio14 = new SocioAdherente();
		socio.setNombre("Ejemplo");
		socio.setTipoSocio(TipoSocio.SOCIO_ADHERENTE);
		socio.setTelefono(123456);
		socio.setMail("Ejemplo");
		//socio.setNombrePresidente("Ejemplo");
		socio.setUbicacion(ubicacionService.obtenerUbicacion(1));
		SocioAdherente socio15 = new SocioAdherente();
		socio.setNombre("Ejemplo");
		socio.setTipoSocio(TipoSocio.SOCIO_ADHERENTE);
		socio.setTelefono(123456);
		socio.setMail("Ejemplo");
		//socio.setNombrePresidente("Ejemplo");
		socio.setUbicacion(ubicacionService.obtenerUbicacion(1));

		Socio socioGuardado8 = socioRepository.save(socio8);
		Socio socioGuardado9 = socioRepository.save(socio9);
		Socio socioGuardado10 = socioRepository.save(socio10);
		Socio socioGuardado11 = socioRepository.save(socio11);
		Socio socioGuardado12 = socioRepository.save(socio12);
		Socio socioGuardado13 = socioRepository.save(socio13);
		Socio socioGuardado14 = socioRepository.save(socio14);
		Socio socioGuardado15 = socioRepository.save(socio15);



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
