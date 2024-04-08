package ne.oop.bsupermat.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    @Id
    private long id;
    private String productName;
    @ManyToOne
    private ProductType productType;
    private int price;
    private Date date;
    private String image;
    private String code;

}
