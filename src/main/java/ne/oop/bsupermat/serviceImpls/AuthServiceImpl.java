package ne.oop.bsupermat.serviceImpls;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import ne.oop.bsupermat.dto.requests.LoginDTO;
import ne.oop.bsupermat.dto.requests.ResetPasswordDTO;
import ne.oop.bsupermat.dto.response.LoginResponse;
import ne.oop.bsupermat.dto.response.ProfileResponseDTO;
import ne.oop.bsupermat.exceptions.BadRequestException;
import ne.oop.bsupermat.exceptions.NotFoundException;
import ne.oop.bsupermat.model.User;
import ne.oop.bsupermat.repositories.UserRepository;
import ne.oop.bsupermat.security.jwt.JwtUtils;
import ne.oop.bsupermat.security.user.UserAuthority;
import ne.oop.bsupermat.security.user.UserSecurityDetails;
import ne.oop.bsupermat.services.AuthService;
import ne.oop.bsupermat.utils.ExceptionUtils;
import ne.oop.bsupermat.utils.Hash;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserRepository userRepository;
    private final JwtUtils jwtUtils;
    private final UserSecurityDetailServiceImpl userSecurityDetailServiceImpl;
    @Override
    public LoginResponse login(LoginDTO loginDTO) {
        try{
            User user= userRepository.findByEmail(loginDTO.getEmail()).orElseThrow(()->new NotFoundException("email not found"));

            if(Hash.isTheSame(loginDTO.getPassword(),user.getPassword())){
                UserSecurityDetails userSecurityDetails= (UserSecurityDetails)userSecurityDetailServiceImpl.loadUserByUsername(loginDTO.getEmail());
                System.out.println(userSecurityDetails.getGrantedAuthorities());
                List<GrantedAuthority> grantedAuthorities= userSecurityDetails.getGrantedAuthorities();
                if(grantedAuthorities.isEmpty()){
                    throw new BadRequestException("Use has no role");
                }
                UserAuthority userAuthority= (UserAuthority) grantedAuthorities.get(0);
                String role = userAuthority.getAuthority();
                String token= jwtUtils.createToken(user.getId(), loginDTO.getEmail(),role);

                return new LoginResponse(token,user,user.getRoles());

            }else {
                throw  new BadRequestException("Incorrect username and password");
            }
        }catch(Exception e){
            ExceptionUtils.handleServiceExceptions(e);
            return null;
        }
    }

    @Override
    public boolean verifyAccount(String email) {
        return false;
    }

    @Override
    public User initiatePasswordReset(String email) {
        return null;
    }

    @Override
    public User resetPassword(ResetPasswordDTO resetPasswordDTO) {
        return null;
    }

    @Override
    public ProfileResponseDTO getUserProfile() {
        return null;
    }
}
