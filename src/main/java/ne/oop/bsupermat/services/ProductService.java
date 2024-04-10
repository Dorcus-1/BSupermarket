package ne.oop.bsupermat.services;

import ne.oop.bsupermat.model.Cart;
import ne.oop.bsupermat.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product getProductById(String id);
    Product saveProduct(Product product);
    void deleteProduct(String id);
}
