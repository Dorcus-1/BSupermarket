package ne.oop.bsupermat.dto.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateUserDTO {
    private String firstname;
    private String lastname;
    private String username;
    private String email;
    private String password;


}
