package ne.oop.bsupermat.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Quantity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @ManyToOne
    private Product product;


    private int quantity;

    @ManyToMany
    @JoinTable(name = "cart_quantities", joinColumns = @JoinColumn(name = "cart_id"),inverseJoinColumns = @JoinColumn(name = "quantity_id"))
    @JsonIgnore
     private List<Cart> carts;
}
