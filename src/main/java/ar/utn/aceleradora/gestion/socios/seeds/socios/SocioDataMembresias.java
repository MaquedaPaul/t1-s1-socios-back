package ar.utn.aceleradora.gestion.socios.seeds.socios;

import ar.utn.aceleradora.gestion.socios.modelos.socios.membresia.Membresia;
import ar.utn.aceleradora.gestion.socios.modelos.socios.membresia.MembresiaParticular;
import ar.utn.aceleradora.gestion.socios.repositorios.socios.MembresiaParticularRepository;

import ar.utn.aceleradora.gestion.socios.repositorios.socios.MembresiaRepository;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SocioDataMembresias {
    private static final Logger logger = LoggerFactory.getLogger(SocioDataMembresias.class);

    final List<Membresia> membresias = Arrays.asList(new Membresia("semestral",6),new Membresia("anual",12));
    final MembresiaParticular membresiaParticular1 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 723450.65);
    final MembresiaParticular membresiaParticular2 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 123456.78);
    final MembresiaParticular membresiaParticular3 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 987654.32);
    final MembresiaParticular membresiaParticular4 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 543210.98);
    final MembresiaParticular membresiaParticular5 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 234567.89);
    final MembresiaParticular membresiaParticular6 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 876543.21);
    final MembresiaParticular membresiaParticular7 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 135792.46);
    final MembresiaParticular membresiaParticular8 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 642039.57);
    final MembresiaParticular membresiaParticular9 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 285714.29);
    final MembresiaParticular membresiaParticular10 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 961538.46);
    final MembresiaParticular membresiaParticular11 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular12 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 634572.93);
    final MembresiaParticular membresiaParticular13 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 234567.89);
    final MembresiaParticular membresiaParticular14 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular15 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 753246.23);
    final MembresiaParticular membresiaParticular16 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 123456.78);
    final MembresiaParticular membresiaParticular17 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular18 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 345678.90);
    final MembresiaParticular membresiaParticular19 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular20 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 567890.12);
    final MembresiaParticular membresiaParticular21 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular22 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 987654.32);
    final MembresiaParticular membresiaParticular23 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular24 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 765432.10);
    final MembresiaParticular membresiaParticular25 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular26 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 234567.89);
    final MembresiaParticular membresiaParticular27 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular28 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 678901.23);
    final MembresiaParticular membresiaParticular29 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular30 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 123456.78);
    final MembresiaParticular membresiaParticular31 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular32 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 634572.93);
    final MembresiaParticular membresiaParticular33 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 234567.89);
    final MembresiaParticular membresiaParticular34 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular35 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 753246.23);
    final MembresiaParticular membresiaParticular36 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 123456.78);
    final MembresiaParticular membresiaParticular37 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular38 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 345678.90);
    final MembresiaParticular membresiaParticular39 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular40 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 567890.12);
    final MembresiaParticular membresiaParticular41 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular42 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 987654.32);
    final MembresiaParticular membresiaParticular43 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular44 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 765432.10);
    final MembresiaParticular membresiaParticular45 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular46 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 234567.89);
    final MembresiaParticular membresiaParticular47 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular48 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 678901.23);
    final MembresiaParticular membresiaParticular49 = new MembresiaParticular(membresias.get(0), LocalDate.now(), 892347.12);
    final MembresiaParticular membresiaParticular50 = new MembresiaParticular(membresias.get(1), LocalDate.now(), 123456.78);
    @Getter
    final List<MembresiaParticular> membresiaParticulares = new ArrayList<>();

    void cargarMembresias(MembresiaParticularRepository membresiaParticularRepository, MembresiaRepository membresiaRepository){
        membresiaRepository.saveAll(membresias);
        for (int i = 1; i <= 50; i++) {
            // Obtén el nombre de la variable del socio usando reflexión
            String nombreVariable = "membresiaParticular" + i;
            MembresiaParticular membresiaParticular;
            try {
                // Utiliza reflexión para obtener el valor de la variable del socio
                membresiaParticular = (MembresiaParticular) getClass().getDeclaredField(nombreVariable).get(this);
                membresiaParticulares.add(membresiaParticular);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                logger.error("Error al cargar " + nombreVariable, e);
            }
        }
    }
}
