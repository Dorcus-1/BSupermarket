package ne.oop.bsupermat.repositories;

import ne.oop.bsupermat.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductTypeRepository extends JpaRepository<ProductType, UUID> {
}
