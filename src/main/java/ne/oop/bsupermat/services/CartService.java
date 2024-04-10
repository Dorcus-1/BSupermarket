package ne.oop.bsupermat.services;

import ne.oop.bsupermat.model.Cart;

import java.util.List;

public interface CartService {
    List<Cart> getAllCarts();
    Cart getCartById(String id);
    Cart saveCart(Cart cart);
    void deleteCart(String id);

}
