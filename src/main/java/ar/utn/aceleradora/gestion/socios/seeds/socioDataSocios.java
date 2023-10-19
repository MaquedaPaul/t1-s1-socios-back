package ar.utn.aceleradora.gestion.socios.seeds;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.Categoria;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.Socio;
import ar.utn.aceleradora.gestion.socios.modelos.empresa.TipoSocio;
import ar.utn.aceleradora.gestion.socios.modelos.membresia.MembresiaParticular;
import ar.utn.aceleradora.gestion.socios.modelos.ubicacion.Ubicacion;
import ar.utn.aceleradora.gestion.socios.repositorios.CategoriaRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.MembresiaParticularRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class socioDataSocios {

    Socio socio1 = new Socio(
            "Luisa Pérez",
            "Carlos García",
            "20345678901", // CUIT ficticio
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654517", // Número de teléfono modificado
            "luisaperez@gmail.com", // Correo electrónico de Gmail
            new Ubicacion("Av. Rivadavia 517", "5to piso", "Departamento 35", "Buenos Aires", "Buenos Aires")
    );

    Socio socio2 = new Socio(
            "Eduardo López",
            "Ana Rodríguez",
            "20345678902", // CUIT ficticio
            TipoSocio.SOCIO_PLENARIO,
            "11-987654518",
            "eduardolopez@gmail.com",
            new Ubicacion("Calle San Martín 225", "3er piso", "Departamento 12", "Buenos Aires", "Buenos Aires")
    );

    Socio socio3 = new Socio(
            "Carolina Fernández",
            "Javier Martínez",
            "20345678903", // CUIT ficticio
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654519",
            "carolinafernandez@gmail.com",
            new Ubicacion("Av. Libertador 1234", "10mo piso", "Departamento 50", "Buenos Aires", "Buenos Aires")
    );

    Socio socio4 = new Socio(
            "Martín Sánchez",
            "Laura Gómez",
            "20345678904", // CUIT ficticio
            TipoSocio.SOCIO_PLENARIO,
            "11-987654520",
            "martinsanchez@gmail.com",
            new Ubicacion("Calle Mayo 567", "6to piso", "Departamento 28", "Buenos Aires", "Buenos Aires")
    );

    Socio socio5 = new Socio(
            "Verónica Torres",
            "Alejandro Pérez",
            "20345678905", // CUIT ficticio
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654521",
            "veronicatorres@gmail.com",
            new Ubicacion("Av. Corrientes 789", "8vo piso", "Departamento 42", "Buenos Aires", "Buenos Aires")
    );

    Socio socio6 = new Socio(
            "Roberto Gómez",
            "Silvia Martínez",
            "20345678906", // CUIT ficticio
            TipoSocio.SOCIO_PLENARIO,
            "11-987654522",
            "robertogomez@gmail.com",
            new Ubicacion("Calle Sarmiento 321", "4to piso", "Departamento 19", "Buenos Aires", "Buenos Aires")
    );
    Socio socio7 = new Socio(
            "Marcela Fernández",
            "Carlos Sánchez",
            "20345678907", // CUIT ficticio
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654523",
            "marcelafernandez@gmail.com",
            new Ubicacion("Av. Santa Fe 456", "9no piso", "Departamento 63", "Buenos Aires", "Buenos Aires")
    );

    Socio socio8 = new Socio(
            "Fernando Rodríguez",
            "Adriana López",
            "20345678908", // CUIT ficticio
            TipoSocio.SOCIO_PLENARIO,
            "11-987654524",
            "fernandorodriguez@gmail.com",
            new Ubicacion("Calle Maipú 789", "7mo piso", "Departamento 45", "Buenos Aires", "Buenos Aires")
    );

    Socio socio9 = new Socio(
            "Mónica Torres",
            "Jorge Martínez",
            "20345678909", // CUIT ficticio
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654525",
            "monicatorres@gmail.com",
            new Ubicacion("Av. Córdoba 1234", "12vo piso", "Departamento 72", "Buenos Aires", "Buenos Aires")
    );

    Socio socio10 = new Socio(
            "Diego García",
            "Laura Rodríguez",
            "20345678910", // CUIT ficticio
            TipoSocio.SOCIO_PLENARIO,
            "11-987654526",
            "diegogarcia@gmail.com",
            new Ubicacion("Av. 9 de Julio 567", "15vo piso", "Departamento 94", "Buenos Aires", "Buenos Aires")
    );

    Socio socio11 = new Socio(
            "Valeria Gómez",
            "Juan Pérez",
            "20345678911", // CUIT ficticio
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654527",
            "valeriagomez@gmail.com",
            new Ubicacion("Calle Lavalle 321", "8vo piso", "Departamento 57", "Buenos Aires", "Buenos Aires")
    );

    Socio socio12 = new Socio(
            "Gabriel Martínez",
            "Sofía Fernández",
            "20345678912", // CUIT ficticio
            TipoSocio.SOCIO_PLENARIO,
            "11-987654528",
            "gabrielmartinez@gmail.com",
            new Ubicacion("Av. Callao 789", "11vo piso", "Departamento 68", "Buenos Aires", "Buenos Aires")
    );

    Socio socio13 = new Socio(
            "Cecilia Sánchez",
            "Andrés López",
            "20345678913", // CUIT ficticio
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654529",
            "ceciliasanchez@gmail.com",
            new Ubicacion("Calle Suipacha 456", "6to piso", "Departamento 39", "Buenos Aires", "Buenos Aires")
    );

    Socio socio14 = new Socio(
            "Ricardo Torres",
            "María Martínez",
            "20345678914", // CUIT ficticio
            TipoSocio.SOCIO_PLENARIO,
            "11-987654530",
            "ricardotorres@gmail.com",
            new Ubicacion("Av. Pueyrredón 1234", "10mo piso", "Departamento 82", "Buenos Aires", "Buenos Aires")
    );

    Socio socio15 = new Socio(
            "Laura Pérez",
            "Carlos Fernández",
            "20345678915", // CUIT ficticio
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654531",
            "lauraperez@gmail.com",
            new Ubicacion("Calle Uruguay 789", "5to piso", "Departamento 26", "Buenos Aires", "Buenos Aires")
    );

    Socio socio16 = new Socio(
            "Javier Rodríguez",
            "Patricia Gómez",
            "20345678916", // CUIT ficticio
            TipoSocio.SOCIO_PLENARIO,
            "11-987654532",
            "javierrodriguez@gmail.com",
            new Ubicacion("Av. Monroe 456", "7mo piso", "Departamento 48", "Buenos Aires", "Buenos Aires")
    );

    Socio socio17 = new Socio(
            "Gabriela Martínez",
            "Jorge Rodríguez",
            "20345678927",
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654543",
            "gabrielamartinez@gmail.com",
            new Ubicacion("Av. Rivadavia 789", "7mo piso", "Departamento 62", "Buenos Aires", "Buenos Aires")
    );

    Socio socio18 = new Socio(
            "Hernán López",
            "María Sánchez",
            "20345678928",
            TipoSocio.SOCIO_PLENARIO,
            "11-987654544",
            "hernanlopez@gmail.com",
            new Ubicacion("Calle Maipú 456", "4to piso", "Departamento 35", "Buenos Aires", "Buenos Aires")
    );

    Socio socio19 = new Socio(
            "Valeria Gómez",
            "Juan Pérez",
            "20345678929",
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654545",
            "valeriagomez@gmail.com",
            new Ubicacion("Av. Belgrano 1234", "11vo piso", "Departamento 78", "Buenos Aires", "Buenos Aires")
    );

    Socio socio20 = new Socio(
            "Federico Rodríguez",
            "Laura Fernández",
            "20345678930",
            TipoSocio.SOCIO_PLENARIO,
            "11-987654546",
            "federicorodriguez@gmail.com",
            new Ubicacion("Av. Corrientes 567", "6to piso", "Departamento 41", "Buenos Aires", "Buenos Aires")
    );

    Socio socio21 = new Socio(
            "Marina Torres",
            "Carlos Gómez",
            "20345678931",
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654547",
            "marinatorres@gmail.com",
            new Ubicacion("Calle Suipacha 789", "9no piso", "Departamento 52", "Buenos Aires", "Buenos Aires")
    );

    Socio socio22 = new Socio(
            "Luis García",
            "Ana Rodríguez",
            "20345678932",
            TipoSocio.SOCIO_PLENARIO,
            "11-987654548",
            "luisgarcia@gmail.com",
            new Ubicacion("Av. Santa Fe 321", "5to piso", "Departamento 27", "Buenos Aires", "Buenos Aires")
    );

    Socio socio23 = new Socio(
            "Cecilia Martínez",
            "Javier López",
            "20345678933",
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654549",
            "ceciliamartinez@gmail.com",
            new Ubicacion("Calle Uruguay 456", "8vo piso", "Departamento 34", "Buenos Aires", "Buenos Aires")
    );

    Socio socio24 = new Socio(
            "Gonzalo Sánchez",
            "Mónica Gómez",
            "20345678934",
            TipoSocio.SOCIO_PLENARIO,
            "11-987654550",
            "gonzalosanchez@gmail.com",
            new Ubicacion("Av. Pueyrredón 789", "10mo piso", "Departamento 67", "Buenos Aires", "Buenos Aires")
    );

    Socio socio25 = new Socio(
            "Mariano Rodríguez",
            "Silvia Martínez",
            "20345678935",
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654551",
            "marianorodriguez@gmail.com",
            new Ubicacion("Av. 9 de Julio 1234", "15vo piso", "Departamento 92", "Buenos Aires", "Buenos Aires")
    );

    Socio socio26 = new Socio(
            "Natalia López",
            "Alejandro Pérez",
            "20345678936",
            TipoSocio.SOCIO_PLENARIO,
            "11-987654552",
            "natalialopez@gmail.com",
            new Ubicacion("Calle Sarmiento 567", "7mo piso", "Departamento 46", "Buenos Aires", "Buenos Aires")
    );
    Socio socio27 = new Socio(
            "Laura Rodríguez",
            "Carlos Gómez",
            "20345678937",
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654553",
            "laurarodriguez@gmail.com",
            new Ubicacion("Av. Corrientes 456", "8vo piso", "Departamento 53", "Buenos Aires", "Buenos Aires")
    );

    Socio socio28 = new Socio(
            "Eduardo Pérez",
            "Mónica Martínez",
            "20345678938",
            TipoSocio.SOCIO_PLENARIO,
            "11-987654554",
            "eduardoperez@gmail.com",
            new Ubicacion("Av. Santa Fe 1234", "11vo piso", "Departamento 74", "Buenos Aires", "Buenos Aires")
    );

    Socio socio29 = new Socio(
            "Natalia García",
            "Javier López",
            "20345678939",
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654555",
            "nataliagarcia@gmail.com",
            new Ubicacion("Calle Uruguay 789", "6to piso", "Departamento 28", "Buenos Aires", "Buenos Aires")
    );

    Socio socio30 = new Socio(
            "Mariano Torres",
            "Silvina Rodríguez",
            "20345678940",
            TipoSocio.SOCIO_PLENARIO,
            "11-987654556",
            "marianotorres@gmail.com",
            new Ubicacion("Calle Suipacha 456", "7mo piso", "Departamento 42", "Buenos Aires", "Buenos Aires")
    );

    Socio socio31 = new Socio(
            "Sofía Martínez",
            "Alejandro Pérez",
            "20345678941",
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654557",
            "sofiamartinez@gmail.com",
            new Ubicacion("Av. Callao 789", "9no piso", "Departamento 57", "Buenos Aires", "Buenos Aires")
    );

    Socio socio32 = new Socio(
            "Luisa Gómez",
            "Carlos Fernández",
            "20345678942",
            TipoSocio.SOCIO_PLENARIO,
            "11-987654558",
            "luisagomez@gmail.com",
            new Ubicacion("Av. Córdoba 567", "5to piso", "Departamento 31", "Buenos Aires", "Buenos Aires")
    );

    Socio socio33 = new Socio(
            "Gustavo Rodríguez",
            "Mónica López",
            "20345678943",
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654559",
            "gustavorodriguez@gmail.com",
            new Ubicacion("Av. Pueyrredón 789", "8vo piso", "Departamento 49", "Buenos Aires", "Buenos Aires")
    );

    Socio socio34 = new Socio(
            "Carolina Pérez",
            "Javier Gómez",
            "20345678944",
            TipoSocio.SOCIO_PLENARIO,
            "11-987654560",
            "carolinaperez@gmail.com",
            new Ubicacion("Calle Lavalle 456", "7mo piso", "Departamento 38", "Buenos Aires", "Buenos Aires")
    );

    Socio socio35 = new Socio(
            "Federico Martínez",
            "Silvia García",
            "20345678945",
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654561",
            "federicomartinez@gmail.com",
            new Ubicacion("Av. Rivadavia 1234", "10mo piso", "Departamento 82", "Buenos Aires", "Buenos Aires")
    );

    Socio socio36 = new Socio(
            "Laura López",
            "Carlos Rodríguez",
            "20345678946",
            TipoSocio.SOCIO_PLENARIO,
            "11-987654562",
            "lauralopez@gmail.com",
            new Ubicacion("Av. Belgrano 567", "6to piso", "Departamento 29", "Buenos Aires", "Buenos Aires")
    );

    Socio socio37 = new Socio(
            "Alejandro Pérez",
            "Julieta Martínez",
            "20345678947",
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654563",
            "alejandroperez@gmail.com",
            new Ubicacion("Av. Corrientes 789", "11vo piso", "Departamento 68", "Buenos Aires", "Buenos Aires")
    );

    Socio socio38 = new Socio(
            "María García",
            "Luis Rodríguez",
            "20345678948",
            TipoSocio.SOCIO_PLENARIO,
            "11-987654564",
            "mariagarcia@gmail.com",
            new Ubicacion("Calle Suipacha 321", "8vo piso", "Departamento 57", "Buenos Aires", "Buenos Aires")
    );

    Socio socio39 = new Socio(
            "Carlos López",
            "Natalia Fernández",
            "20345678949",
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654565",
            "carloslopez@gmail.com",
            new Ubicacion("Av. 9 de Julio 1234", "14vo piso", "Departamento 93", "Buenos Aires", "Buenos Aires")
    );

    Socio socio40 = new Socio(
            "Silvia Martínez",
            "Martín Pérez",
            "20345678950",
            TipoSocio.SOCIO_PLENARIO,
            "11-987654566",
            "silviamartinez@gmail.com",
            new Ubicacion("Av. Santa Fe 567", "6to piso", "Departamento 32", "Buenos Aires", "Buenos Aires")
    );

    Socio socio41 = new Socio(
            "Javier Rodríguez",
            "Florencia Gómez",
            "20345678951",
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654567",
            "javierrodriguez@gmail.com",
            new Ubicacion("Calle Lavalle 789", "9no piso", "Departamento 52", "Buenos Aires", "Buenos Aires")
    );

    Socio socio42 = new Socio(
            "Luisa Rodríguez",
            "Carlos Pérez",
            "20345678960",
            TipoSocio.SOCIO_PLENARIO,
            "11-987654576",
            "luisarodriguez@gmail.com",
            new Ubicacion("Calle Lavalle 789", "10mo piso", "Departamento 58", "Buenos Aires", "Buenos Aires")
    );
    Socio socio43 = new Socio(
            "Martín García",
            "Laura Martínez",
            "20345678952",
            TipoSocio.SOCIO_PLENARIO,
            "11-987654568",
            "martingarcia@gmail.com",
            new Ubicacion("Av. Corrientes 456", "10mo piso", "Departamento 69", "Buenos Aires", "Buenos Aires")
    );

    Socio socio44 = new Socio(
            "Florencia López",
            "Javier Rodríguez",
            "20345678953",
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654569",
            "florencialopez@gmail.com",
            new Ubicacion("Calle Suipacha 1234", "12vo piso", "Departamento 87", "Buenos Aires", "Buenos Aires")
    );

    Socio socio45 = new Socio(
            "Carlos Pérez",
            "Ana Gómez",
            "20345678954",
            TipoSocio.SOCIO_PLENARIO,
            "11-987654570",
            "carlosperez@gmail.com",
            new Ubicacion("Av. Belgrano 789", "8vo piso", "Departamento 59", "Buenos Aires", "Buenos Aires")
    );

    Socio socio46 = new Socio(
            "Natalia García",
            "Luis Rodríguez",
            "20345678955",
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654571",
            "nataliagarcia@gmail.com",
            new Ubicacion("Calle Lavalle 456", "6to piso", "Departamento 37", "Buenos Aires", "Buenos Aires")
    );

    Socio socio47 = new Socio(
            "Julián Martínez",
            "Silvia Pérez",
            "20345678956",
            TipoSocio.SOCIO_PLENARIO,
            "11-987654572",
            "julianmartinez@gmail.com",
            new Ubicacion("Av. Santa Fe 789", "11vo piso", "Departamento 63", "Buenos Aires", "Buenos Aires")
    );

    Socio socio48 = new Socio(
            "Florencia García",
            "Martín López",
            "20345678957",
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654573",
            "florenciagarcia@gmail.com",
            new Ubicacion("Calle Maipú 567", "7mo piso", "Departamento 44", "Buenos Aires", "Buenos Aires")
    );

    Socio socio49 = new Socio(
            "Andrés Pérez",
            "Natalia Rodríguez",
            "20345678958",
            TipoSocio.SOCIO_PLENARIO,
            "11-987654574",
            "andresperez@gmail.com",
            new Ubicacion("Av. Callao 1234", "12vo piso", "Departamento 79", "Buenos Aires", "Buenos Aires")
    );

    Socio socio50 = new Socio(
            "Mariano Gómez",
            "Carolina Martínez",
            "20345678959",
            TipoSocio.SOCIO_ADHERENTE,
            "11-987654575",
            "marianogomez@gmail.com",
            new Ubicacion("Av. 9 de Julio 789", "9no piso", "Departamento 55", "Buenos Aires", "Buenos Aires")
    );
    List<Socio> sociosCargados = new ArrayList<>();
    void cargarSocios(SocioRepository socioRepository, MembresiaParticularRepository membresiaParticularRepository, CategoriaRepository categoriaRepository, socioDataMembresias dataMembresias) {

        List<MembresiaParticular> membresias = dataMembresias.getMembresiaParticulares();
        for (int i = 1; i <= 50; i++) {
            // Obtén el nombre de la variable del socio usando reflexión
            String nombreVariable = "socio" + i;
            Socio socio = null;
            try {
                socio = (Socio) getClass().getDeclaredField(nombreVariable).get(this);
                socio.agregarMembresia(membresias.get(i-1));
                membresias.get(i-1).setSocio(socio);
                this.agregarCategoriasASocio(socio, categoriaRepository);
                sociosCargados.add(socio);

                socioRepository.save(socio);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace(); // Maneja las excepciones apropiadamente
            }
        }
    }
    void agregarCategoriasASocio(Socio unSocio, CategoriaRepository categoriaRepository){
        List<Categoria> categorias = categoriaRepository.findAll();
        int tamanioArray = categorias.size();
        // Crear una instancia de la clase Random
        Random random = new Random();
        // Generar un número aleatorio entre 1 y 20 (inclusive)
        int numeroAleatorio = random.nextInt(tamanioArray);
        int otroAleatorio = random.nextInt(tamanioArray);
        int tercerAleatorio = random.nextInt(tamanioArray);
        Categoria unaCategoria = categorias.get(numeroAleatorio);
        Categoria otraCategoria = categorias.get(otroAleatorio);
        Categoria tercerCategoria = categorias.get(tercerAleatorio);
        int cantidadElementos = random.nextInt(3)+1;
        List<Categoria> categoriasAniadir = Arrays.asList(unaCategoria,otraCategoria,tercerCategoria);
        List<Categoria> elementosAleatorios = new ArrayList<>();
        for (int j = 0; j < cantidadElementos; j++) {
            int indiceAleatorio = random.nextInt(categoriasAniadir.size());
            elementosAleatorios.add(categoriasAniadir.get(indiceAleatorio));
        }
        unSocio.agregarCategoria(elementosAleatorios);
    }
    void agregarMembresiasASocios(SocioRepository socioRepository, MembresiaParticularRepository membresiaParticularRepository, CategoriaRepository categoriaRepository) {

        List<MembresiaParticular> membresias = membresiaParticularRepository.findAll();
        for (int i = 1; i <= 50; i++) {
            // Obtén el nombre de la variable del socio usando reflexión
            String nombreVariable = "socio" + i;
            Socio socio = null;
            try {
                socio = (Socio) getClass().getDeclaredField(nombreVariable).get(this);
                socio.agregarMembresia(membresias.get(i-1));
                membresias.get(i-1).setSocio(socio);
                this.agregarCategoriasASocio(socio, categoriaRepository);
                sociosCargados.add(socio);
                socioRepository.save(socio);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace(); // Maneja las excepciones apropiadamente
            }
        }
    }
}
