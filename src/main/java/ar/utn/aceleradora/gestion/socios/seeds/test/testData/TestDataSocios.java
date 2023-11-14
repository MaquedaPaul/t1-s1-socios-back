
package ar.utn.aceleradora.gestion.socios.seeds.test.testData;

import ar.utn.aceleradora.gestion.socios.modelos.socios.Categoria;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.socios.TipoSocio;
import ar.utn.aceleradora.gestion.socios.modelos.socios.membresia.Membresia;
import ar.utn.aceleradora.gestion.socios.modelos.socios.membresia.MembresiaParticular;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.repositorios.CategoriaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.MembresiaParticularRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.MembresiaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import ar.utn.aceleradora.gestion.socios.seeds.socios.SocioDataSocios;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestDataSocios {

    private static final Logger logger = LoggerFactory.getLogger(SocioDataSocios.class);

    //Test Sample de Categorias
    static final Categoria lacteos = new Categoria("Productos Lácteos");
    static final Categoria panaderia = new Categoria("Productos de Panadería");
    static final Categoria carnesYaves = new Categoria("Carnes y Aves");
    static final Categoria productosDelMar = new Categoria("Productos del Mar");
    static final Categoria alimentosCongelados = new Categoria("Alimentos Congelados");
    static final Categoria bebidasNoAlcoholicas = new Categoria("Bebidas No Alcohólicas");
    static final Categoria bebidasAlcoholicas = new Categoria("Bebidas Alcohólicas");
    static final Categoria productosEnConserva = new Categoria("Productos en Conserva");
    static final Categoria condimentosYSalsas = new Categoria("Condimentos y Salsas");
    static final Categoria alimentosOrganicos = new Categoria("Alimentos Orgánicos");
    static final Categoria alimentosSinGluten = new Categoria("Alimentos sin Gluten");

    //Creo listas de categorias para cada socio
    static final List<Categoria> categorias1 = Arrays.asList(lacteos, panaderia);
    static final List<Categoria> categorias2 = Arrays.asList(carnesYaves, panaderia);
    static final List<Categoria> categorias3 = Arrays.asList(alimentosCongelados);
    static final List<Categoria> categorias4 = Arrays.asList();
    static final List<Categoria> categorias5 = Arrays.asList(lacteos, carnesYaves, alimentosCongelados);
    static final List<Categoria> categorias6 = Arrays.asList(productosDelMar,alimentosCongelados);
    static final List<Categoria> categorias7 = Arrays.asList(alimentosSinGluten);
    static final List<Categoria> categorias8 = Arrays.asList(alimentosOrganicos,condimentosYSalsas,panaderia);
    static final List<Categoria> categorias9 = Arrays.asList(carnesYaves,lacteos,panaderia,alimentosOrganicos,alimentosCongelados,productosDelMar,productosEnConserva,bebidasNoAlcoholicas,bebidasAlcoholicas);
    static final List<Categoria> categorias10 = Arrays.asList(panaderia);
    static final List<Categoria> categorias11 = Arrays.asList(bebidasAlcoholicas,bebidasNoAlcoholicas);
    static final List<Categoria> categorias12 =  Arrays.asList(alimentosCongelados,bebidasNoAlcoholicas);
    static final List<Categoria> categorias13 = Arrays.asList(carnesYaves,alimentosSinGluten);
    static final List<Categoria> categorias14 = Arrays.asList(condimentosYSalsas,bebidasAlcoholicas,bebidasNoAlcoholicas);
    static final List<Categoria> categorias15 = Arrays.asList(bebidasAlcoholicas);

    final List<Categoria> categorias = Arrays.asList(lacteos,panaderia,carnesYaves,productosDelMar,alimentosCongelados ,bebidasNoAlcoholicas,bebidasAlcoholicas ,productosEnConserva,condimentosYSalsas ,alimentosOrganicos,alimentosSinGluten);

    //Test Sample de Membresias
    static final List<Membresia> membresias = Arrays.asList(new Membresia("semestrual", 6), new Membresia("anual", 12));
    static final MembresiaParticular membresiaParticular1 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 723450.65);
    static final MembresiaParticular membresiaParticular2 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 123456.78);
    static final MembresiaParticular membresiaParticular3 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 987654.32);
    static final MembresiaParticular membresiaParticular4 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 543210.98);
    static final MembresiaParticular membresiaParticular5 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 234567.89);
    static final MembresiaParticular membresiaParticular6 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 723750.65);
    static final MembresiaParticular membresiaParticular7 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 225456.78);
    static final MembresiaParticular membresiaParticular8 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 987694.12);
    static final MembresiaParticular membresiaParticular9 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 543350.98);
    static final MembresiaParticular membresiaParticular10 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 237767.89);
    static final MembresiaParticular membresiaParticular11 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 983450.55);
    static final MembresiaParticular membresiaParticular12 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 123724.98);
    static final MembresiaParticular membresiaParticular13 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 989654.32);
    static final MembresiaParticular membresiaParticular14 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 542220.88);
    static final MembresiaParticular membresiaParticular15 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 235566.70);

    final List<MembresiaParticular> membresiasParticulares = Arrays.asList(membresiaParticular1,membresiaParticular2,membresiaParticular3, membresiaParticular4,membresiaParticular5, membresiaParticular6, membresiaParticular7,membresiaParticular8,membresiaParticular9,membresiaParticular10,membresiaParticular11,membresiaParticular12,membresiaParticular13,membresiaParticular14,membresiaParticular15);

    //Listas de membresias para cada socio
    static final List<MembresiaParticular> membresias1 = Arrays.asList(membresiaParticular1);
    static final List<MembresiaParticular> membresias2 = Arrays.asList(membresiaParticular2);
    static final List<MembresiaParticular> membresias3 = Arrays.asList(membresiaParticular3);
    static final List<MembresiaParticular> membresias4 = Arrays.asList(membresiaParticular4);
    static final List<MembresiaParticular> membresias5 = Arrays.asList(membresiaParticular5);
    static final List<MembresiaParticular> membresias6 = Arrays.asList(membresiaParticular6);
    static final List<MembresiaParticular> membresias7 = Arrays.asList(membresiaParticular7);
    static final List<MembresiaParticular> membresias8 = Arrays.asList(membresiaParticular8);
    static final List<MembresiaParticular> membresias9 = Arrays.asList(membresiaParticular9);
    static final List<MembresiaParticular> membresias10 = Arrays.asList(membresiaParticular10);
    static final List<MembresiaParticular> membresias11 = Arrays.asList(membresiaParticular11);
    static final List<MembresiaParticular> membresias12 = Arrays.asList(membresiaParticular12);
    static final List<MembresiaParticular> membresias13 = Arrays.asList(membresiaParticular13);
    static final List<MembresiaParticular> membresias14 = Arrays.asList(membresiaParticular14);
    static final List<MembresiaParticular> membresias15 = Arrays.asList(membresiaParticular15);

    static Socio socio1 = new Socio(
            "Luisa Pérez",
            "Carlos García",
            "20345678901", // CUIT ficticio
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654517", // Número de teléfono modificado
            "luisaperez@gmail.com", // Correo electrónico de Gmail
            categorias1,
            membresias1,
            new Ubicacion("Av. Rivadavia 517", "5to piso", "Departamento 35", "Buenos Aires", "Buenos Aires")

    );

    static Socio socio2 = new Socio(
            "Eduardo López",
            "Ana Rodríguez",
            "20345678902", // CUIT ficticio
            TipoSocio.SOCIO_PLENARIO,
            "11-987654518",
            "eduardolopez@gmail.com",
            categorias2,
            membresias2,
            new Ubicacion("Calle San Martín 225", "3er piso", "Departamento 12", "Buenos Aires", "Buenos Aires")
    );

    static Socio socio3 = new Socio(
            "Carolina Fernández",
            "Javier Martínez",
            "20345678903", // CUIT ficticio
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654519",
            "carolinafernandez@gmail.com",
            categorias3,
            membresias3,
            new Ubicacion("Av. Libertador 1234", "10mo piso", "Departamento 50", "Buenos Aires", "Buenos Aires")
    );

    static Socio socio4 = new Socio(
            "Martín Sánchez",
            "Laura Gómez",
            "20345678904", // CUIT ficticio
            TipoSocio.SOCIO_PLENARIO,
            "11-987654520",
            "martinsanchez@gmail.com",
            categorias4,
            membresias4,
            new Ubicacion("Calle Mayo 567", "6to piso", "Departamento 28", "Buenos Aires", "Buenos Aires")
    );

    static Socio socio5 = new Socio(
            "Verónica Torres",
            "Alejandro Pérez",
            "20345678905", // CUIT ficticio
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654521",
            "veronicatorres@gmail.com",
            categorias5,
            membresias5,
            new Ubicacion("Av. Corrientes 789", "8vo piso", "Departamento 42", "Buenos Aires", "Buenos Aires")
    );

    static Socio socio6 = new Socio(
            "Roberto Gómez",
            "Silvia Martínez",
            "20345678906", // CUIT ficticio
            TipoSocio.SOCIO_PLENARIO,
            "11-987654522",
            "robertogomez@gmail.com",
            categorias6,
            membresias6,
            new Ubicacion("Calle Sarmiento 321", "4to piso", "Departamento 19", "Buenos Aires", "Buenos Aires")
    );
    static Socio socio7 = new Socio(
            "Marcela Fernández",
            "Carlos Sánchez",
            "20345678907", // CUIT ficticio
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654523",
            "marcelafernandez@gmail.com",
            categorias7,
            membresias7,
            new Ubicacion("Av. Santa Fe 456", "9no piso", "Departamento 63", "Buenos Aires", "Buenos Aires")
    );

    static Socio socio8 = new Socio(
            "Fernando Rodríguez",
            "Adriana López",
            "20345678908", // CUIT ficticio
            TipoSocio.SOCIO_PLENARIO,
            "11-987654524",
            "fernandorodriguez@gmail.com",
            categorias8,
            membresias8,
            new Ubicacion("Calle Maipú 789", "7mo piso", "Departamento 45", "Buenos Aires", "Buenos Aires")
    );

    static Socio socio9 = new Socio(
            "Mónica Torres",
            "Jorge Martínez",
            "20345678909", // CUIT ficticio
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654525",
            "monicatorres@gmail.com",
            categorias9,
            membresias9,
            new Ubicacion("Av. Córdoba 1234", "12vo piso", "Departamento 72", "Buenos Aires", "Buenos Aires")
    );

    static Socio socio10 = new Socio(
            "Diego García",
            "Laura Rodríguez",
            "20345678910", // CUIT ficticio
            TipoSocio.SOCIO_PLENARIO,
            "11-987654526",
            "diegogarcia@gmail.com",
            categorias10,
            membresias10,
            new Ubicacion("Av. 9 de Julio 567", "15vo piso", "Departamento 94", "Buenos Aires", "Buenos Aires")
    );

    static Socio socio11 = new Socio(
            "Valeria Gómez",
            "Juan Pérez",
            "20345678911", // CUIT ficticio
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654527",
            "valeriagomez@gmail.com",
            categorias11,
            membresias11,
            new Ubicacion("Calle Lavalle 321", "8vo piso", "Departamento 57", "Buenos Aires", "Buenos Aires")
    );

    static Socio socio12 = new Socio(
            "Gabriel Martínez",
            "Sofía Fernández",
            "20345678912", // CUIT ficticio
            TipoSocio.SOCIO_PLENARIO,
            "11-987654528",
            "gabrielmartinez@gmail.com",
            categorias12,
            membresias12,
            new Ubicacion("Av. Callao 789", "11vo piso", "Departamento 68", "Buenos Aires", "Buenos Aires")
    );

    static Socio socio13 = new Socio(
            "Cecilia Sánchez",
            "Andrés López",
            "20345678913", // CUIT ficticio
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654529",
            "ceciliasanchez@gmail.com",
            categorias13,
            membresias13,
            new Ubicacion("Calle Suipacha 456", "6to piso", "Departamento 39", "Buenos Aires", "Buenos Aires")
    );

    static Socio socio14 = new Socio(
            "Ricardo Torres",
            "María Martínez",
            "20345678914", // CUIT ficticio
            TipoSocio.SOCIO_PLENARIO,
            "11-987654530",
            "ricardotorres@gmail.com",
            categorias14,
            membresias14,
            new Ubicacion("Av. Pueyrredón 1234", "10mo piso", "Departamento 82", "Buenos Aires", "Buenos Aires")
    );

    static Socio socio15 = new Socio(
            "Laura Pérez",
            "Carlos Fernández",
            "20345678915", // CUIT ficticio
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654531",
            "lauraperez@gmail.com",
            categorias15,
            membresias15,
            new Ubicacion("Calle Uruguay 789", "5to piso", "Departamento 26", "Buenos Aires", "Buenos Aires")
    );

    final List<Socio> sociosCargados = new ArrayList<>();
    public void cargarSociosyMembresias(SocioRepository socioRepository, MembresiaParticularRepository membresiaParticularRepository){

        for (int i = 1; i <= 15; i++) {
            // Obtén el nombre de la variable del socio usando reflexión
            String nombreVariable = "socio" + i;
            Socio socio;
            try {
                socio = (Socio) getClass().getDeclaredField(nombreVariable).get(this);
                sociosCargados.add(socio);
                socioRepository.save(socio);
                membresiaParticularRepository.save(membresiasParticulares.get(i-1));
            } catch (NoSuchFieldException | IllegalAccessException e) {
                logger.error("Error al cargar " + nombreVariable, e);
            }
        }
    }

    public void cargarCategorias(CategoriaRepository categoriaRepository){
        for (int i = 1; i <= 10; i++){
            categoriaRepository.save(categorias.get(i-1));
        }
    }

    public void cargarMembresias(MembresiaRepository membresiaRepository){
        membresiaRepository.save(membresias.get(0));
        membresiaRepository.save(membresias.get(1));
    }
}

