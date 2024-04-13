package ne.oop.bsupermat.dto.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@RequiredArgsConstructor
public class CreateProductTypeDTO {
    private String productTypeName;
}
