package ne.oop.bsupermat.serviceImpls;

import lombok.RequiredArgsConstructor;
import ne.oop.bsupermat.dto.requests.CreateCartDTO;
import ne.oop.bsupermat.model.Cart;
import ne.oop.bsupermat.model.User;
import ne.oop.bsupermat.repositories.CartRepository;
import ne.oop.bsupermat.repositories.UserRepository;
import ne.oop.bsupermat.services.CartService;
import ne.oop.bsupermat.utils.ExceptionUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CartServiceImpl implements CartService {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    @Override
    public List<Cart> getAllCarts() {
        try {
            return cartRepository.findAll();
        } catch (Exception e) {
            ExceptionUtils.handleServiceExceptions(e);
            return null;
        }
    }

    @Override
    public Cart getCartById(String id) {
        return null;
    }

    @Override
    public Cart saveCart(CreateCartDTO createCartDTO) {
        try{
            User user= userRepository.findById(createCartDTO.getUser()).get();
            Cart cart= new Cart(user);
            return cartRepository.save(cart);
        } catch (Exception e) {
            ExceptionUtils.handleServiceExceptions(e);
            return null;
        }
    }

    @Override
    public void deleteCart(String id) {

    }
}
