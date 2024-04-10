package ne.oop.bsupermat.services;

import ne.oop.bsupermat.model.Cart;
import ne.oop.bsupermat.model.Role;
import ne.oop.bsupermat.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();
    Role getUserById(String id);
    Role saveUser(User user);
    void deleteUser(String id);
}
