package ne.oop.bsupermat.serviceImpls;

import lombok.RequiredArgsConstructor;
import ne.oop.bsupermat.dto.requests.CreateQuantityDTO;
import ne.oop.bsupermat.exceptions.NotFoundException;
import ne.oop.bsupermat.model.Product;
import ne.oop.bsupermat.model.Purchased;
import ne.oop.bsupermat.model.Quantity;
import ne.oop.bsupermat.repositories.ProductRepository;
import ne.oop.bsupermat.repositories.QuantityRepository;
import ne.oop.bsupermat.services.QuantityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuantityServiceImpl implements QuantityService {

    private final QuantityRepository quantityRepository;
    private final ProductRepository productRepository;
    @Override
    public List<Quantity> getAllQuantities() {
        return null;
    }

    @Override
    public Quantity getQuantityById(String id) {
        return null;
    }

    @Override
    public Quantity saveQuantity(CreateQuantityDTO createQuantityDTO) {
        try{
            Product product= productRepository.findById(createQuantityDTO.getProduct()).orElseThrow(()->new NotFoundException("id not found"));
            Quantity quantity=new Quantity();
            quantity.setQuantity(createQuantityDTO.getQuantity());
            quantity.setProduct(product);
            return quantityRepository.save(quantity);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteQuantity(String id) {

    }
}
