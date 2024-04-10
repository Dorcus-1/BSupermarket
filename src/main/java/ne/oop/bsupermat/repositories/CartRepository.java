package ne.oop.bsupermat.repositories;

import ne.oop.bsupermat.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CartRepository extends JpaRepository<Cart, UUID> {

}
