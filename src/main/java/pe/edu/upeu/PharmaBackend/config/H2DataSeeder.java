package pe.edu.upeu.PharmaBackend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import pe.edu.upeu.PharmaBackend.entity.Categoria;
import pe.edu.upeu.PharmaBackend.entity.Producto;
import pe.edu.upeu.PharmaBackend.repository.CategoriaRepository;
import pe.edu.upeu.PharmaBackend.repository.ProductoRepository;

import java.math.BigDecimal;
import java.util.List;

@Component
@Profile("h2")
public class H2DataSeeder implements CommandLineRunner {

    private final CategoriaRepository categoriaRepository;
    private final ProductoRepository productoRepository;

    public H2DataSeeder(CategoriaRepository categoriaRepository, ProductoRepository productoRepository) {
        this.categoriaRepository = categoriaRepository;
        this.productoRepository = productoRepository;
    }

    @Override
    public void run(String... args) {
        if (productoRepository.count() == 0) {
            Categoria cat1 = new Categoria(null, "Analgésicos", "Medicamentos para el dolor", true, null, null);
            Categoria cat2 = new Categoria(null, "Antibióticos", "Medicamentos para infecciones", true, null, null);
            categoriaRepository.saveAll(List.of(cat1, cat2));

            Producto p1 = new Producto(null, "Paracetamol 500mg", new BigDecimal("2.50"), 100, true, cat1, null, null);
            Producto p2 = new Producto(null, "Ibuprofeno 400mg", new BigDecimal("3.00"), 50, true, cat1, null, null);
            Producto p3 = new Producto(null, "Amoxicilina 500mg", new BigDecimal("5.00"), 30, true, cat2, null, null);
            
            productoRepository.saveAll(List.of(p1, p2, p3));
            System.out.println("====== H2 DATABASE SEEDED WITH CATEGORIES AND PRODUCTS ======");
        }
    }
}
