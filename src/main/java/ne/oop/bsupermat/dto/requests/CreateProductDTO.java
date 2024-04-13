package ne.oop.bsupermat.dto.requests;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@RequiredArgsConstructor
public class CreateProductDTO {
    private String productName;
    private int price;
    private Date date;
    private String image;
    private String code;
    private UUID productType;
}
