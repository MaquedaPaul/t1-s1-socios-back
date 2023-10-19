package ar.utn.aceleradora.gestion.socios.seeds.departamentos;

import ar.utn.aceleradora.gestion.socios.modelos.Autoridad;
import ar.utn.aceleradora.gestion.socios.modelos.Departamento;
import ar.utn.aceleradora.gestion.socios.repositorios.AutoridadRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.DepartamentoRepository;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class DepartamentoDataDepartamentos {

    Departamento departamento1 = new Departamento(
            "Economía, Desarrollo Regional y PyME",
            "Su objetivo es el diseño de propuestas y seguimiento en materia de políticas de desarrollo productivo, acceso al financiamiento y mejora de la competitividad de los sectores de la industria de alimentos y bebidas, en particular las economías regionales y el entramado PyME.",
            "icono_economia.png",
            2
    );
    Departamento departamento2 = new Departamento(
            "Normativa Alimentaria",
            "Su objetivo principal consiste en el seguimiento y análisis de las regulaciones alimentarias vigentes y proyectos de las mismas, sean estos de carácter regional (MERCOSUR), nacional, provincial o municipal, dando cobertura a distintas instancias de discusión normativa.",
            "icono_normativa.png",
            2
    );

    Departamento departamento3 = new Departamento(
            "Asuntos Institucionales y Comunicación",
            "Su objetivo es desarrollar la estrategia institucional y de comunicación para posicionar la agenda de propuestas de política pública para la mejora de los sectores de la IAB ante el Gobierno Nacional, los Gobiernos Provinciales y los Gobiernos Municipales.",
            "icono_comunicacion.png",
            2
    );
    Departamento departamento4 = new Departamento(
            "Política Fiscal y Tributaria",
            "Su objetivo principal es analizar, evaluar y proponer las mejoras del sistema tributario que alcanza a la IAB, con intención de disminuir la carga tributaria y simplificar los regímenes correspondientes.",
            "icono_fiscal.png",
            2
    );
    Departamento departamento5 = new Departamento(
            "Asuntos Laborales",
            "Su objetivo es monitorear y analizar los temas legales y de política laboral, como así también las cuestiones relativas a la seguridad social de las empresas representadas por sus Cámaras.",
            "icono_laboral.png",
            2
    );
    Departamento departamento6 = new Departamento(
            "Comercio Exterior",
            "Su objetivo es tener activa participación, seguimiento y monitoreo de las negociaciones económicas internacionales, en las que se encuentra involucrado el país, ya sea individualmente o como parte del MERCOSUR. Asimismo, atender la agenda de la política de internacionalización de los sectores de la IAB.",
            "icono_comercio.png",
            2
    );
    Departamento departamento7 = new Departamento(
            "Sustentabilidad y Política Ambiental",
            "Su principal objetivo es el de atender todos aquellos temas que hacen al estudio de los planes, alternativas o proyectos de ley que tengan que ver con la gestión ambiental.",
            "icono_ambiental.png",
            2
    );
    @Getter

    List<Departamento> departamentos = asList(departamento1,departamento2,departamento3,departamento4,departamento5,departamento6,departamento7);
    void cargarDepartamentos(DepartamentoRepository departamentoRepository, AutoridadRepository autoridadRepository){
        List<Autoridad> autoridades = autoridadRepository.findAll();
        departamentos.forEach(depa -> this.agregarAutoridadesADepartamento(depa, autoridades));
        departamentoRepository.saveAll(this.departamentos);
    }
    void agregarAutoridadesADepartamento(Departamento unDepartamento, List<Autoridad> autoridades){
        int tamanioArray = autoridades.size();
        // Crear una instancia de la clase Random
        Random random = new Random();
        // Generar un número aleatorio entre 1 y 20 (inclusive)
        int numeroAleatorio = random.nextInt(tamanioArray);
        int otroAleatorio = random.nextInt(tamanioArray);
        int tercerAleatorio = random.nextInt(tamanioArray);
        int cuartoAleatorio = random.nextInt(tamanioArray);
        Autoridad autoridad1 = autoridades.get(numeroAleatorio);
        Autoridad autoridad2 = autoridades.get(otroAleatorio);
        Autoridad autoridad3 = autoridades.get(tercerAleatorio);
        Autoridad autoridad4 = autoridades.get(cuartoAleatorio);
        unDepartamento.agregarAutoridades(Arrays.asList(autoridad1,autoridad2,autoridad3,autoridad4));
    }

}
