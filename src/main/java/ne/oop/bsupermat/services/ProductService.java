package ne.oop.bsupermat.services;

import ne.oop.bsupermat.dto.requests.CreateProductDTO;
import ne.oop.bsupermat.model.Cart;
import ne.oop.bsupermat.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(String id);
    Product saveProduct(CreateProductDTO createProductDTO);
    void deleteProduct(String id);
}
