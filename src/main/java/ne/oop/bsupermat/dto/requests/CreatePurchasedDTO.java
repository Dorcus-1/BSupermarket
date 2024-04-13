package ne.oop.bsupermat.dto.requests;

import lombok.Getter;
import lombok.Setter;
import ne.oop.bsupermat.model.Quantity;
import ne.oop.bsupermat.model.User;

import javax.persistence.ManyToOne;
import java.util.UUID;

@Getter
@Setter
public class CreatePurchasedDTO {

    private UUID quantity;

    private  UUID user;
}
