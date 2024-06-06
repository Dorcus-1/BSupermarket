package ne.oop.bsupermat.dto.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDTO {
    String email;
    String password;
}
