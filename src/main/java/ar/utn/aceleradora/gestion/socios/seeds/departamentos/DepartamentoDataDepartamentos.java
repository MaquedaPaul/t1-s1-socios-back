package ar.utn.aceleradora.gestion.socios.seeds.departamentos;

import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Autoridad;
import ar.utn.aceleradora.gestion.socios.modelos.departamentos.Departamento;
import ar.utn.aceleradora.gestion.socios.modelos.socios.Socio;
import ar.utn.aceleradora.gestion.socios.repositorios.AutoridadRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.SocioRepository;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static java.util.Arrays.asList;

public class DepartamentoDataDepartamentos {

    final Departamento departamento1 = new Departamento(
            "Economía, Desarrollo Regional y PyME",
            "Su objetivo es el diseño de propuestas y seguimiento en materia de políticas de desarrollo productivo, acceso al financiamiento y mejora de la competitividad de los sectores de la industria de alimentos y bebidas, en particular las economías regionales y el entramado PyME.",
            "icono_economia.png",
            2
    );
    final Departamento departamento2 = new Departamento(
            "Normativa Alimentaria",
            "Su objetivo principal consiste en el seguimiento y análisis de las regulaciones alimentarias vigentes y proyectos de las mismas, sean estos de carácter regional (MERCOSUR), nacional, provincial o municipal, dando cobertura a distintas instancias de discusión normativa.",
            "icono_normativa.png",
            2
    );

    final Departamento departamento3 = new Departamento(
            "Asuntos Institucionales y Comunicación",
            "Su objetivo es desarrollar la estrategia institucional y de comunicación para posicionar la agenda de propuestas de política pública para la mejora de los sectores de la IAB ante el Gobierno Nacional, los Gobiernos Provinciales y los Gobiernos Municipales.",
            "icono_comunicacion.png",
            2
    );
    final Departamento departamento4 = new Departamento(
            "Política Fiscal y Tributaria",
            "Su objetivo principal es analizar, evaluar y proponer las mejoras del sistema tributario que alcanza a la IAB, con intención de disminuir la carga tributaria y simplificar los regímenes correspondientes.",
            "icono_fiscal.png",
            2
    );
    final Departamento departamento5 = new Departamento(
            "Asuntos Laborales",
            "Su objetivo es monitorear y analizar los temas legales y de política laboral, como así también las cuestiones relativas a la seguridad social de las empresas representadas por sus Cámaras.",
            "icono_laboral.png",
            2
    );
    final Departamento departamento6 = new Departamento(
            "Comercio Exterior",
            "Su objetivo es tener activa participación, seguimiento y monitoreo de las negociaciones económicas internacionales, en las que se encuentra involucrado el país, ya sea individualmente o como parte del MERCOSUR. Asimismo, atender la agenda de la política de internacionalización de los sectores de la IAB.",
            "icono_comercio.png",
            2
    );
    final Departamento departamento7 = new Departamento(
            "Sustentabilidad y Política Ambiental",
            "Su principal objetivo es el de atender todos aquellos temas que hacen al estudio de los planes, alternativas o proyectos de ley que tengan que ver con la gestión ambiental.",
            "icono_ambiental.png",
            2
    );
    @Getter

    final List<Departamento> departamentos = asList(departamento1,departamento2,departamento3,departamento4,departamento5,departamento6,departamento7);
    void cargarDepartamentos(AutoridadRepository autoridadRepository, SocioRepository socioRepository){
        List<Autoridad> autoridades = autoridadRepository.findAll();
        List<Socio> socios = socioRepository.findAll();
        departamentos.forEach(depa -> this.agregarAutoridadesADepartamento(depa, autoridades));
        departamentos.forEach(depa -> this.agregarSociosSuscritosADepartamento(depa, socios));
        //departamentoRepository.saveAll(this.departamentos);
    }

    private <T> List<T> seleccionarElementosAleatorios(List<T> lista) {
        Random random = new Random();
        int tamanioArray = lista.size();
        List<T> elementosSeleccionados = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            int indiceAleatorio = random.nextInt(tamanioArray);
            elementosSeleccionados.add(lista.get(indiceAleatorio));
        }

        return elementosSeleccionados;
    }

    void agregarAutoridadesADepartamento(Departamento unDepartamento, List<Autoridad> autoridades) {
        List<Autoridad> autoridadesSeleccionadas = seleccionarElementosAleatorios(autoridades);
        unDepartamento.agregarAutoridades(autoridadesSeleccionadas);
    }

    private void agregarSociosSuscritosADepartamento(Departamento unDepartamento, List<Socio> socios) {
        List<Socio> sociosSeleccionados = seleccionarElementosAleatorios(socios);
        unDepartamento.setSociosSuscritos(sociosSeleccionados);
    }




}
