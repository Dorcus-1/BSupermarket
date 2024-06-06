package ne.oop.bsupermat.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ResetPasswordDTO {
    String email;
    String newPassword;
}
