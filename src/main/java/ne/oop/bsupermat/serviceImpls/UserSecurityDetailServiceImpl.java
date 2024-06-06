package ne.oop.bsupermat.serviceImpls;

import lombok.RequiredArgsConstructor;
import ne.oop.bsupermat.exceptions.NotFoundException;
import ne.oop.bsupermat.model.User;
import ne.oop.bsupermat.repositories.UserRepository;
import ne.oop.bsupermat.security.user.UserSecurityDetails;
import ne.oop.bsupermat.utils.ExceptionUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSecurityDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            Optional<User> user=userRepository.findByEmail(username);
            if(user.isPresent()){
                return new UserSecurityDetails(user.get());
            }else{
                throw new NotFoundException("user not found");
            }
        }catch (Exception e){
            ExceptionUtils.handleServiceExceptions(e);
            return null;
        }
    }
}
