package ne.oop.bsupermat.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cart {
    @Id
    private long id;
    @OneToOne
    private User user;
    @ManyToMany
    @JoinTable(name = "cart_quantities", joinColumns = @JoinColumn(name = "quantity_id"),inverseJoinColumns = @JoinColumn(name = "cart_id"))
    @JsonIgnore
    private List<Quantity> quantities;
}
