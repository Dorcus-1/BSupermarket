package ne.oop.bsupermat.services;

import ne.oop.bsupermat.model.Cart;
import ne.oop.bsupermat.model.Purchased;
import ne.oop.bsupermat.model.Quantity;

import java.util.List;

public interface QuantityService {
    List<Quantity> getAllQuantities();
    Purchased getQuantityById(String id);
    Purchased saveQuantity(Quantity quantity);
    void deleteQuantity(String id);

}
