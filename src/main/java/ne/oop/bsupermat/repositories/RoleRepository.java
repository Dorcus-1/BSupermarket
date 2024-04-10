package ne.oop.bsupermat.repositories;

import ne.oop.bsupermat.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}
