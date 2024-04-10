package ne.oop.bsupermat.repositories;

import ne.oop.bsupermat.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
