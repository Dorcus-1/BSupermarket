package ne.oop.bsupermat.repositories;

import ne.oop.bsupermat.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
