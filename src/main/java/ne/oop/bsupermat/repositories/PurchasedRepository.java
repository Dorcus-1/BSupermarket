package ne.oop.bsupermat.repositories;

import ne.oop.bsupermat.model.Purchased;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PurchasedRepository extends JpaRepository<Purchased, UUID> {
}
