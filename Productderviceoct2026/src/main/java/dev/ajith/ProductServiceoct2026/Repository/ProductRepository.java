package dev.ajith.ProductServiceoct2026.Repository;

import dev.ajith.ProductServiceoct2026.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
