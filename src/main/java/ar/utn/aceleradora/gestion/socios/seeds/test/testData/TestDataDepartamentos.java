package ar.utn.aceleradora.gestion.socios.seeds.test.testData;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Autoridad;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Coordinacion;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.repositorios.AutoridadRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.CoorDepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.DepartamentoRepository;

import java.util.Arrays;
import java.util.List;

public class TestDataDepartamentos {

    private Socio socio1 = TestDataSocios.socio1;
    private Socio socio2 = TestDataSocios.socio2;
    private Socio socio3 = TestDataSocios.socio3;
    private Socio socio4 = TestDataSocios.socio4;
    private Socio socio5 = TestDataSocios.socio5;
    private Socio socio6 = TestDataSocios.socio6;
    private Socio socio7 = TestDataSocios.socio7;
    private Socio socio8 = TestDataSocios.socio8;
    private Socio socio9 = TestDataSocios.socio9;
    private Socio socio10 = TestDataSocios.socio10;
    private Socio socio11 = TestDataSocios.socio11;
    private Socio socio12 = TestDataSocios.socio12;
    private Socio socio13 = TestDataSocios.socio13;
    private Socio socio14 = TestDataSocios.socio14;
    private Socio socio15 = TestDataSocios.socio15;


    //Socios de cada departamento
    final List<Socio> sociosDelDepto1 = Arrays.asList(socio1, socio2, socio8);
    final List<Socio> sociosDelDepto2 = Arrays.asList(socio2,socio9);
    final List<Socio> sociosDelDepto3 = Arrays.asList(socio3);
    final List<Socio> sociosDelDepto4 = Arrays.asList(socio4, socio1, socio5,socio9);
    final List<Socio> sociosDelDepto5 = Arrays.asList(socio5,socio6);
    final List<Socio> sociosDelDepto6 = Arrays.asList(socio7,socio10,socio14,socio15);
    final List<Socio> sociosDelDepto7 = Arrays.asList(socio11,socio12,socio13);

    //Autoridades de cada departamento
    Autoridad autoridad1 = new Autoridad(
            "Paulina",
            "Campion",
            "autoridad/paulinacampion.jpg",
            "Jefe de Departamento de Comercio Exterior"
    );

    Autoridad autoridad2 = new Autoridad(
            "Nicolas",
            "Ferinovic",
            "autoridad/nicolasferinovic.jpg",
            "Asistente de Departamento de Comercio Exterior"
    );

    Autoridad autoridad3 = new Autoridad(
            "Abril",
            "Drach",
            "autoridad/abrildrach.jpg",
            "Jefe de Departamento de Normativa Alimentaria"
    );

    Autoridad autoridad4 = new Autoridad(
            "Julieta",
            "Mendez",
            "autoridad/julietamendez.jpg",
            "Asistente de Departamento de Normativa Alimentaria"
    );

    Autoridad autoridad5 = new Autoridad(
            "Paulina",
            "Campion",
            "autoridad/paulinacampion.jpg",
            "Jefe de Departamento de Economía, Desarrollo Regional y PyME"
    );

    Autoridad autoridad6 = new Autoridad(
            "Paulina",
            "Campion",
            "autoridad/paulinacampion.jpg",
            "Jefe de Departamento de Política Tributaria"
    );

    Autoridad autoridad7 = new Autoridad(
            "Gabriela",
            "Petray",
            "autoridad/gabrielapetray.jpg",
            "Asistente de Departamento de Asuntos Laborales"
    );


    private List<Autoridad> autoridades = Arrays.asList(autoridad1,autoridad2,autoridad3,autoridad4,autoridad5,autoridad6,autoridad7);


    final Departamento departamento1 = new Departamento(
            "Economía, Desarrollo Regional y PyME",
            "Su objetivo es el diseño de propuestas y seguimiento en materia de políticas de desarrollo productivo, acceso al financiamiento y mejora de la competitividad de los sectores de la industria de alimentos y bebidas, en particular las economías regionales y el entramado PyME.",
            "icono_economia.png",
            2,
            sociosDelDepto1,
            List.of(autoridades.get(0))
    );
    final Departamento departamento2 = new Departamento(
            "Normativa Alimentaria",
            "Su objetivo principal consiste en el seguimiento y análisis de las regulaciones alimentarias vigentes y proyectos de las mismas, sean estos de carácter regional (MERCOSUR), nacional, provincial o municipal, dando cobertura a distintas instancias de discusión normativa.",
            "icono_normativa.png",
            2,
            sociosDelDepto2,
            List.of(autoridades.get(1))
    );

    final Departamento departamento3 = new Departamento(
            "Asuntos Institucionales y Comunicación",
            "Su objetivo es desarrollar la estrategia institucional y de comunicación para posicionar la agenda de propuestas de política pública para la mejora de los sectores de la IAB ante el Gobierno Nacional, los Gobiernos Provinciales y los Gobiernos Municipales.",
            "icono_comunicacion.png",
            2,
            sociosDelDepto3,
            List.of(autoridades.get(2))
    );
    final Departamento departamento4 = new Departamento(
            "Política Fiscal y Tributaria",
            "Su objetivo principal es analizar, evaluar y proponer las mejoras del sistema tributario que alcanza a la IAB, con intención de disminuir la carga tributaria y simplificar los regímenes correspondientes.",
            "icono_fiscal.png",
            2,
            sociosDelDepto4,
            List.of(autoridades.get(3))
    );
    final Departamento departamento5 = new Departamento(
            "Asuntos Laborales",
            "Su objetivo es monitorear y analizar los temas legales y de política laboral, como así también las cuestiones relativas a la seguridad social de las empresas representadas por sus Cámaras.",
            "icono_laboral.png",
            2,
            sociosDelDepto5,
            List.of(autoridades.get(4))
    );
    final Departamento departamento6 = new Departamento(
            "Comercio Exterior",
            "Su objetivo es tener activa participación, seguimiento y monitoreo de las negociaciones económicas internacionales, en las que se encuentra involucrado el país, ya sea individualmente o como parte del MERCOSUR. Asimismo, atender la agenda de la política de internacionalización de los sectores de la IAB.",
            "icono_comercio.png",
            2,
            sociosDelDepto6,
            List.of(autoridades.get(5))
    );
    final Departamento departamento7 = new Departamento(
            "Sustentabilidad y Política Ambiental",
            "Su principal objetivo es el de atender todos aquellos temas que hacen al estudio de los planes, alternativas o proyectos de ley que tengan que ver con la gestión ambiental.",
            "icono_ambiental.png",
            2,
            sociosDelDepto7,
            List.of(autoridades.get(6))
    );
    final List<Departamento> departamentos = Arrays.asList(departamento1,departamento2,departamento3,departamento4,departamento5,departamento6,departamento7);

    final Autoridad autoridadCoordinacionDepartamental = new Autoridad(
            "Darinka",
            "Anzulovich",
            "autoridad/darinkaanzulovich.jpg",
            "Coordinación Departamentos Técnicos");

    //Coordinaciones
    final Coordinacion coordinacion1 = new Coordinacion(
            "Coordinación Departamentos Técnicos",
            "Supervisa cada uno de los departamentos técnicos en pos de que se cumplan sus respectivos objetivos",
            "icono_coordinacion_departamentos.png",
            1,
            autoridadCoordinacionDepartamental);

    final List<Coordinacion> coordinaciones = Arrays.asList(coordinacion1);

    public void cargarDepartamentosYAutoridades(DepartamentoRepository departamentoRepository, AutoridadRepository autoridadRepository){
        for (int i = 0; i <= 6; i++) {
            departamentoRepository.save(departamentos.get(i));
            autoridadRepository.save(autoridades.get(1));
        }
    }

    public void cargarCoordinaciones(CoorDepartamentoRepository coordinacionRepository){

        coordinacionRepository.save(coordinaciones.get(0));
    }



}


