package ne.oop.bsupermat.serviceImpls;

import lombok.RequiredArgsConstructor;
import ne.oop.bsupermat.dto.requests.CreateProductDTO;
import ne.oop.bsupermat.dto.requests.CreateProductTypeDTO;
import ne.oop.bsupermat.model.ProductType;
import ne.oop.bsupermat.repositories.CartRepository;
import ne.oop.bsupermat.repositories.ProductTypeRepository;
import ne.oop.bsupermat.services.ProductTypeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductTypeServiceImpl implements ProductTypeService{
    private final ProductTypeRepository productTypeRepository;

    @Override
    public List<ProductType> getAllProductTypes() {
        return null;
    }

    @Override
    public ProductType getProductTypeById(String id) {
        return null;
    }

    @Override
    public ProductType saveProductType(CreateProductTypeDTO createProductTypeDTO) {
        try{
           ProductType productType= new ProductType();
           productType.setTypename(createProductTypeDTO.getProductTypeName());

           return productTypeRepository.save(productType);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void deleteProductType(String id) {

    }
}
