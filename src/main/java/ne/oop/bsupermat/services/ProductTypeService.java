package ne.oop.bsupermat.services;

import ne.oop.bsupermat.model.Cart;
import ne.oop.bsupermat.model.Product;
import ne.oop.bsupermat.model.ProductType;

import java.util.List;

public interface ProductTypeService {

    List<ProductType> getAllProductTypes();
    ProductType getProductTypeById(String id);
    ProductType saveProductType(ProductType productType);
    void deleteProductType(String id);
}
