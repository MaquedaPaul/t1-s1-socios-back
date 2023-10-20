package ar.utn.aceleradora.gestion.socios.seeds;

import ar.utn.aceleradora.gestion.socios.modelos.empresa.Categoria;
import ar.utn.aceleradora.gestion.socios.repositorios.CategoriaRepository;

import java.util.Arrays;
import java.util.List;

public class SocioDataCategorias {
    Categoria lacteos = new Categoria("Productos Lácteos");
    Categoria panaderia = new Categoria("Productos de Panadería");
    Categoria carnesYaves = new Categoria("Carnes y Aves");
    Categoria productosDelMar = new Categoria("Productos del Mar");
    Categoria alimentosCongelados = new Categoria("Alimentos Congelados");
    Categoria bebidasNoAlcoholicas = new Categoria("Bebidas No Alcohólicas");
    Categoria bebidasAlcoholicas = new Categoria("Bebidas Alcohólicas");
    Categoria productosEnConserva = new Categoria("Productos en Conserva");
    Categoria condimentosYSalsas = new Categoria("Condimentos y Salsas");
    Categoria alimentosOrganicos = new Categoria("Alimentos Orgánicos");
    Categoria alimentosSinGluten = new Categoria("Alimentos sin Gluten");
    Categoria alimentosVeganosYVegetarianos = new Categoria("Alimentos Veganos y Vegetarianos");
    Categoria productosGourmet = new Categoria("Productos Gourmet");
    Categoria alimentosHalal = new Categoria("Alimentos Halal");
    Categoria alimentosKosher = new Categoria("Alimentos Kosher");
    Categoria productosSinAzucar = new Categoria("Productos Sin Azúcar");
    Categoria snacksSaludables = new Categoria("Snacks Saludables");
    Categoria alimentosSinLactosa = new Categoria("Alimentos Sin Lactosa");
    Categoria alimentosSinNueces = new Categoria("Alimentos Sin Nueces");
    Categoria alimentosBajosEnGrasa = new Categoria("Alimentos Bajos en Grasa");
    Categoria alimentosSinOGM = new Categoria("Alimentos Sin Organismos Genéticamente Modificados (OGM)");
    Categoria alimentosParaDeportistas = new Categoria("Alimentos para Deportistas");

    List<Categoria> categorias = Arrays.asList(lacteos, panaderia, carnesYaves, productosDelMar, alimentosCongelados,
            bebidasNoAlcoholicas, bebidasAlcoholicas, productosEnConserva, condimentosYSalsas, alimentosOrganicos,
            alimentosSinGluten, alimentosVeganosYVegetarianos, productosGourmet, alimentosHalal, alimentosKosher,
            productosSinAzucar, snacksSaludables, alimentosSinLactosa,alimentosBajosEnGrasa,alimentosSinOGM,alimentosParaDeportistas,alimentosSinNueces);
    void cargarCategorias(CategoriaRepository categoriaRepository){
        categoriaRepository.saveAll(categorias);
    }
}
