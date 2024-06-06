package ne.oop.bsupermat.serviceImpls;

import lombok.RequiredArgsConstructor;
import ne.oop.bsupermat.dto.requests.AssignRoleDTO;
import ne.oop.bsupermat.dto.requests.CreateRoleDTO;
import ne.oop.bsupermat.exceptions.NotFoundException;
import ne.oop.bsupermat.model.Role;
import ne.oop.bsupermat.model.User;
import ne.oop.bsupermat.repositories.RoleRepository;
import ne.oop.bsupermat.repositories.UserRepository;
import ne.oop.bsupermat.services.RoleService;
import ne.oop.bsupermat.utils.ExceptionUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final UserRepository userRepository;

    @Override
    public List<Role> getAllRoles() {
        try{
            return roleRepository.findAll();
        }catch (Exception e){
            ExceptionUtils.handleServiceExceptions(e);
            return null;
        }
    }

    @Override
    public Role getRoleById(String id) {
        return null;
    }

    @Override
    public Role saveRole(CreateRoleDTO createRoleDTO) {
        try {
            Role role= new Role();
            role.setRoleName(createRoleDTO.getRoleName());
            return roleRepository.save(role);
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }


    @Override
    public void deleteRole(String id) {

    }

    @Override
    public Role assignRoles(AssignRoleDTO assignRoleDTO) {
        try{
            Role role= roleRepository.findById(assignRoleDTO.getRoleId()).get();
            List<User> users= new ArrayList<>();

            for(UUID userId:assignRoleDTO.getUsers()){
                User user= userRepository.findById(userId).get();
                if(user!=null){
                    users.add(user);
                }else{
                    throw new NotFoundException("User NotFound");
                }
                role.setUsers(users);
                roleRepository.save(role);
            }
            return  role;
        }catch (Exception e){
            ExceptionUtils.handleServiceExceptions(e);
        }
        return  null;
    }
}
