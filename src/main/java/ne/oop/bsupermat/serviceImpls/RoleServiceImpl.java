package ne.oop.bsupermat.serviceImpls;

import lombok.RequiredArgsConstructor;
import ne.oop.bsupermat.dto.requests.CreateRoleDTO;
import ne.oop.bsupermat.model.Role;
import ne.oop.bsupermat.repositories.RoleRepository;
import ne.oop.bsupermat.services.RoleService;
import ne.oop.bsupermat.utils.ExceptionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

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
}
