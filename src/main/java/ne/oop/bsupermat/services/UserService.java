package ne.oop.bsupermat.services;

import ne.oop.bsupermat.dto.requests.CreateUserDTO;
import ne.oop.bsupermat.model.Cart;
import ne.oop.bsupermat.model.Role;
import ne.oop.bsupermat.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    User getUserById(String id);
    User saveUser(CreateUserDTO createUserDTO);
    void deleteUser(String id);
}
