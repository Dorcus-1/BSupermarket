package ne.oop.bsupermat.services;

import ne.oop.bsupermat.dto.requests.CreateQuantityDTO;
import ne.oop.bsupermat.model.Cart;
import ne.oop.bsupermat.model.Purchased;
import ne.oop.bsupermat.model.Quantity;

import java.util.List;

public interface QuantityService {
    List<Quantity> getAllQuantities();
    Quantity getQuantityById(String id);
    Quantity saveQuantity(CreateQuantityDTO createQuantityDTO);
    void deleteQuantity(String id);

}
