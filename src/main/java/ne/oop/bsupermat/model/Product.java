package ne.oop.bsupermat.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String productName;
    @ManyToOne
    private ProductType productType;
    private int price;
    private Date date;
    private String image;
    private String code;

}
