package ar.utn.aceleradora.gestion.socios.seeds.departamentos;
import ar.utn.aceleradora.gestion.socios.repositorios.*;
import org.springframework.stereotype.Component;

@Component
public class DepartamentoInitializer {
    private final SocioRepository socioRepository;
    private final DepartamentoRepository departamentoRepository;
    private final AutoridadRepository autoridadRepository;
    private final CoorDepartamentoRepository coorDepartamentoRepository;
    public DepartamentoInitializer(SocioRepository socioRepository, DepartamentoRepository departamentoRepository, AutoridadRepository autoridadRepository, CoorDepartamentoRepository coorDepartamentoRepository) {
        this.socioRepository = socioRepository;
        this.departamentoRepository = departamentoRepository;
        this.autoridadRepository = autoridadRepository;
        this.coorDepartamentoRepository = coorDepartamentoRepository;
    }
    public void run() throws Exception {
       DepartamentoDataDepartamentos dataDepartamentos = new DepartamentoDataDepartamentos();
       DepartamentoDataAutoridad dataAutoridad = new DepartamentoDataAutoridad();
       DepartamentoDataCoordinacion dataCoordinacion = new DepartamentoDataCoordinacion();
       dataAutoridad.cargarAutoridades(autoridadRepository);
       dataDepartamentos.cargarDepartamentos(departamentoRepository, autoridadRepository, socioRepository);
       dataCoordinacion.cargarCoordinaciones(coorDepartamentoRepository, autoridadRepository, departamentoRepository, dataDepartamentos);
    }

}
