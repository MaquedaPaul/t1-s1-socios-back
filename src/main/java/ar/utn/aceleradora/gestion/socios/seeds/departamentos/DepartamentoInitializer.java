package ar.utn.aceleradora.gestion.socios.seeds.departamentos;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.AutoridadRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.departamentos.CoorDepartamentoRepository;
import ar.utn.aceleradora.gestion.socios.repositorios.socios.SocioRepository;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoInitializer {
    private final SocioRepository socioRepository;
    private final AutoridadRepository autoridadRepository;
    private final CoorDepartamentoRepository coorDepartamentoRepository;
    public DepartamentoInitializer(SocioRepository socioRepository, AutoridadRepository autoridadRepository, CoorDepartamentoRepository coorDepartamentoRepository) {
        this.socioRepository = socioRepository;
        this.autoridadRepository = autoridadRepository;
        this.coorDepartamentoRepository = coorDepartamentoRepository;
    }
    public void run() {
       DepartamentoDataDepartamentos dataDepartamentos = new DepartamentoDataDepartamentos();
       DepartamentoDataAutoridad dataAutoridad = new DepartamentoDataAutoridad();
       DepartamentoDataCoordinacion dataCoordinacion = new DepartamentoDataCoordinacion();
       dataAutoridad.cargarAutoridades(autoridadRepository);
       dataDepartamentos.cargarDepartamentos(autoridadRepository, socioRepository);
       dataCoordinacion.cargarCoordinaciones(coorDepartamentoRepository, autoridadRepository, dataDepartamentos);
    }

}
