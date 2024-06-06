package ne.oop.bsupermat.services;

import ne.oop.bsupermat.dto.requests.LoginDTO;
import ne.oop.bsupermat.dto.requests.ResetPasswordDTO;
import ne.oop.bsupermat.dto.response.LoginResponse;
import ne.oop.bsupermat.dto.response.ProfileResponseDTO;
import ne.oop.bsupermat.model.User;

public interface AuthService {

    LoginResponse login(LoginDTO loginDTO);
    boolean verifyAccount(String email);
    User initiatePasswordReset(String email);
    User resetPassword(ResetPasswordDTO resetPasswordDTO);
    ProfileResponseDTO getUserProfile();


}
