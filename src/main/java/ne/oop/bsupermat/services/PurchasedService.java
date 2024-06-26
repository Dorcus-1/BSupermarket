package ne.oop.bsupermat.services;

import ne.oop.bsupermat.dto.requests.CreatePurchasedDTO;
import ne.oop.bsupermat.model.Cart;
import ne.oop.bsupermat.model.Product;
import ne.oop.bsupermat.model.Purchased;

import java.util.List;

public interface PurchasedService {
    List<Purchased> getAllPurchased();
    Purchased getPurchasedById(String id);
    Purchased savePurchased(CreatePurchasedDTO createPurchasedDTO);
    void deletePurchased(String id);
}
