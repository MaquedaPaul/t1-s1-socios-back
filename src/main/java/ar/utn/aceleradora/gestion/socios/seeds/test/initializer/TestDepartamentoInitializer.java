package ar.utn.aceleradora.gestion.socios.seeds.test.initializer;
import ar.utn.aceleradora.gestion.socios.repositorios.*;
import ar.utn.aceleradora.gestion.socios.seeds.test.testData.TestDataDepartamentos;
import org.springframework.stereotype.Component;

@Component
public class TestDepartamentoInitializer {
    private final DepartamentoRepository departamentoRepository;
    private final AutoridadRepository autoridadRepository;
    private final CoorDepartamentoRepository coorDepartamentoRepository;

    public TestDepartamentoInitializer(DepartamentoRepository departamentoRepository, AutoridadRepository autoridadRepository, CoorDepartamentoRepository coorDepartamentoRepository) {
        this.departamentoRepository = departamentoRepository;
        this.autoridadRepository = autoridadRepository;
        this.coorDepartamentoRepository = coorDepartamentoRepository;
    }

    public void run() {
        TestDataDepartamentos dataDepartamentos = new TestDataDepartamentos();

        dataDepartamentos.cargarDepartamentosYAutoridades(departamentoRepository, autoridadRepository);
        dataDepartamentos.cargarCoordinaciones(coorDepartamentoRepository);
    }

}
