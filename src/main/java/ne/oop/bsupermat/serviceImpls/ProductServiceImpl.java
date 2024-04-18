package ne.oop.bsupermat.serviceImpls;

import lombok.RequiredArgsConstructor;
import ne.oop.bsupermat.dto.requests.CreateProductDTO;
import ne.oop.bsupermat.exceptions.NotFoundException;
import ne.oop.bsupermat.model.Product;
import ne.oop.bsupermat.model.ProductType;
import ne.oop.bsupermat.repositories.ProductRepository;
import ne.oop.bsupermat.repositories.ProductTypeRepository;
import ne.oop.bsupermat.services.ProductService;
import ne.oop.bsupermat.utils.ExceptionUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductTypeRepository productTypeRepository;
    @Override
    public List<Product> getAllProducts() {
        try{
            return productRepository.findAll();
        }catch (Exception e){
            ExceptionUtils.handleServiceExceptions(e);
            return null;
        }
    }
    @Override
    public Product getProductById(String id) {
        return null;
    }
    @Override
    public Product saveProduct(CreateProductDTO createProductDTO) {
        try{
            Date date=new Date();
            ProductType productType= productTypeRepository.findById(createProductDTO.getProductType()).orElseThrow(()->new  NotFoundException("Product type not found"));
            Product product=new Product();
            product.setProductName(createProductDTO.getProductName());
            product.setPrice(createProductDTO.getPrice());
            product.setDate(date);
            product.setCode(createProductDTO.getCode());
            product.setProductType(productType);
             return productRepository.save(product);

        }catch (Exception e){
            ExceptionUtils.handleServiceExceptions(e);
            return null;
        }
    }

    @Override
    public void deleteProduct(String id) {

    }
}
