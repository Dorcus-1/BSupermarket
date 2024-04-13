package ne.oop.bsupermat.services;

import ne.oop.bsupermat.dto.requests.CreateRoleDTO;
import ne.oop.bsupermat.model.Cart;
import ne.oop.bsupermat.model.Purchased;
import ne.oop.bsupermat.model.Quantity;
import ne.oop.bsupermat.model.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();
    Role getRoleById(String id);
    Role saveRole(CreateRoleDTO createRoleDTO);
    void deleteRole(String id);

}
