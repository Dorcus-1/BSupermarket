package ne.oop.bsupermat.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import ne.oop.bsupermat.model.Role;
import ne.oop.bsupermat.model.User;

import java.util.Set;

@AllArgsConstructor
@Getter
@Setter
public class LoginResponse {

   public String token;
    public User userData;
    private Set<Role> userRole;


}
