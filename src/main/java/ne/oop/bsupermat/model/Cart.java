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
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @OneToOne
    private User user;
    @ManyToMany
    @JoinTable(name = "cart_quantities", joinColumns = @JoinColumn(name = "quantity_id"),inverseJoinColumns = @JoinColumn(name = "cart_id"))
    @JsonIgnore
    private List<Quantity> quantities;
    public Cart(User user){
        this.user = user;
    }
}
