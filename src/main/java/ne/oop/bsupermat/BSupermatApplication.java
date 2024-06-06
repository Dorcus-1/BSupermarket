package ne.oop.bsupermat;

import ne.oop.bsupermat.enums.Roles;
import ne.oop.bsupermat.model.Role;
import ne.oop.bsupermat.repositories.RoleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableCaching
@EnableWebSecurity
@EnableGlobalAuthentication()
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableTransactionManagement
public class BSupermatApplication {
    private final RoleRepository roleRepository;

    public BSupermatApplication(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(BSupermatApplication.class, args);

    }

    @Bean
    public void registerRoles(){
        Set<Roles> userRoles = new HashSet<>();
        userRoles.add(Roles.ADMIN);
        userRoles.add(Roles.USER);


        for(Roles role : userRoles ){
            Role sampleRole = new Role(role.toString());
            if(roleRepository.findByRoleName(role.name()) == null){
                roleRepository.save(sampleRole);
            }
        }
    }

}
