package ne.oop.bsupermat.repositories;

import ne.oop.bsupermat.model.Quantity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface QuantityRepository extends JpaRepository<Quantity, UUID> {
}
