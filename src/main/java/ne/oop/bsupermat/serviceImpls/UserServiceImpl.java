package ne.oop.bsupermat.serviceImpls;

import lombok.RequiredArgsConstructor;
import ne.oop.bsupermat.dto.requests.CreateUserDTO;
import ne.oop.bsupermat.exceptions.BadRequestException;
import ne.oop.bsupermat.exceptions.NotFoundException;
import ne.oop.bsupermat.model.Role;
import ne.oop.bsupermat.model.User;
import ne.oop.bsupermat.repositories.RoleRepository;
import ne.oop.bsupermat.repositories.UserRepository;
import ne.oop.bsupermat.services.UserService;
import ne.oop.bsupermat.utils.ExceptionUtils;
import ne.oop.bsupermat.utils.Hash;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private  final RoleRepository roleRepository;

    @Override
    public List<User> getAllUsers() {
        try{
            return userRepository.findAll();
        }catch (Exception e){
            ExceptionUtils.handleServiceExceptions(e);
            return null;
        }
    }

    @Override
    public User getUserById(String id) {
        return null;
    }

    @Override
    public User saveUser(CreateUserDTO createUserDTO) {
        try {
           Optional <User> user=userRepository.findByEmail(createUserDTO.getEmail());
           if (user.isPresent()){
             throw new BadRequestException("Email already exist");
           }
           Role role= roleRepository.findByRoleName("USER");
           if(role==null){
               throw  new NotFoundException("No user role");
           }

           User user1= new User();
           List<User> users= new ArrayList<>();
           user1.setFirstName(createUserDTO.getFirstname());
           user1.setLastName(createUserDTO.getLastname());
           user1.setEmail(createUserDTO.getEmail());
           user1.setUsername(createUserDTO.getUsername());
           user1.setPassword(Hash.hashPassword(createUserDTO.getPassword()));
           users.add(user1);
           role.setUsers(users);
           roleRepository.save(role);
           return userRepository.save(user1);
        }
        catch (Exception e){
            ExceptionUtils.handleServiceExceptions(e);
            return null;
        }
    }

    @Override
    public void deleteUser(String id) {

    }
}
