package ne.oop.bsupermat.dto.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public class CreateQuantityDTO {

    private UUID product;
    private int quantity;

}
