package ne.oop.bsupermat.serviceImpls;

import lombok.RequiredArgsConstructor;
import ne.oop.bsupermat.dto.requests.CreatePurchasedDTO;
import ne.oop.bsupermat.exceptions.NotFoundException;
import ne.oop.bsupermat.model.Purchased;
import ne.oop.bsupermat.model.Quantity;
import ne.oop.bsupermat.model.User;
import ne.oop.bsupermat.repositories.PurchasedRepository;
import ne.oop.bsupermat.repositories.QuantityRepository;
import ne.oop.bsupermat.repositories.UserRepository;
import ne.oop.bsupermat.services.PurchasedService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchasedServiceImpl implements PurchasedService {

    private final UserRepository userRepository;
    private final QuantityRepository quantityRepository;
    private final PurchasedRepository purchasedRepository;
    @Override
    public List<Purchased> getAllPurchased() {
        return null;
    }

    @Override
    public Purchased getPurchasedById(String id) {
        return null;
    }

    @Override
    public Purchased savePurchased(CreatePurchasedDTO createPurchasedDTO) {
        try{
            User user= userRepository.findById(createPurchasedDTO.getUser()).orElseThrow(()->new NotFoundException("User Not Found"));
            Quantity quantity=quantityRepository.findById(createPurchasedDTO.getQuantity()).orElseThrow(()->new NotFoundException("Quantity not found"));
            Purchased purchased=new Purchased();
            purchased.setUser(user);
            purchased.setQuantity(quantity);
            return purchasedRepository.save(purchased);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deletePurchased(String id) {

    }
}
