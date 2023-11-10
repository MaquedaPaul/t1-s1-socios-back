package ar.utn.aceleradora.gestion.socios.seeds.socios;

import ar.utn.aceleradora.gestion.socios.modelos.socios.Categoria;
import ar.utn.aceleradora.gestion.socios.repositorios.socios.CategoriaRepository;

import java.util.Arrays;
import java.util.List;

public class SocioDataCategorias {
    final Categoria lacteos = new Categoria("Productos Lácteos");
    final Categoria panaderia = new Categoria("Productos de Panadería");
    final Categoria carnesYaves = new Categoria("Carnes y Aves");
    final Categoria productosDelMar = new Categoria("Productos del Mar");
    final Categoria alimentosCongelados = new Categoria("Alimentos Congelados");
    final Categoria bebidasNoAlcoholicas = new Categoria("Bebidas No Alcohólicas");
    final Categoria bebidasAlcoholicas = new Categoria("Bebidas Alcohólicas");
    final Categoria productosEnConserva = new Categoria("Productos en Conserva");
    final Categoria condimentosYSalsas = new Categoria("Condimentos y Salsas");
    final Categoria alimentosOrganicos = new Categoria("Alimentos Orgánicos");
    final Categoria alimentosSinGluten = new Categoria("Alimentos sin Gluten");
    final Categoria alimentosVeganosYVegetarianos = new Categoria("Alimentos Veganos y Vegetarianos");
    final Categoria productosGourmet = new Categoria("Productos Gourmet");
    final Categoria alimentosHalal = new Categoria("Alimentos Halal");
    final Categoria alimentosKosher = new Categoria("Alimentos Kosher");
    final Categoria productosSinAzucar = new Categoria("Productos Sin Azúcar");
    final Categoria snacksSaludables = new Categoria("Snacks Saludables");
    final Categoria alimentosSinLactosa = new Categoria("Alimentos Sin Lactosa");
    final Categoria alimentosSinNueces = new Categoria("Alimentos Sin Nueces");
    final Categoria alimentosBajosEnGrasa = new Categoria("Alimentos Bajos en Grasa");
    final Categoria alimentosSinOGM = new Categoria("Alimentos Sin Organismos Genéticamente Modificados (OGM)");
    final Categoria alimentosParaDeportistas = new Categoria("Alimentos para Deportistas");

    final List<Categoria> categorias = Arrays.asList(lacteos, panaderia, carnesYaves, productosDelMar, alimentosCongelados,
            bebidasNoAlcoholicas, bebidasAlcoholicas, productosEnConserva, condimentosYSalsas, alimentosOrganicos,
            alimentosSinGluten, alimentosVeganosYVegetarianos, productosGourmet, alimentosHalal, alimentosKosher,
            productosSinAzucar, snacksSaludables, alimentosSinLactosa,alimentosBajosEnGrasa,alimentosSinOGM,alimentosParaDeportistas,alimentosSinNueces);
    void cargarCategorias(CategoriaRepository categoriaRepository){
        categoriaRepository.saveAll(categorias);
    }
}
