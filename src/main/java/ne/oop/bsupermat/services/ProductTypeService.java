package ne.oop.bsupermat.services;

import ne.oop.bsupermat.dto.requests.CreateProductDTO;
import ne.oop.bsupermat.dto.requests.CreateProductTypeDTO;
import ne.oop.bsupermat.model.Cart;
import ne.oop.bsupermat.model.Product;
import ne.oop.bsupermat.model.ProductType;

import java.util.List;

public interface ProductTypeService {

    List<ProductType> getAllProductTypes();
    ProductType getProductTypeById(String id);
    ProductType saveProductType(CreateProductTypeDTO createProductTypeDTO);
    void deleteProductType(String id);
}
