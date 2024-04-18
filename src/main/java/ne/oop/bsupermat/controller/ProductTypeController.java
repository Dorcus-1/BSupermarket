package ne.oop.bsupermat.controller;

import lombok.AllArgsConstructor;
import ne.oop.bsupermat.dto.requests.CreateProductDTO;
import ne.oop.bsupermat.dto.requests.CreateProductTypeDTO;
import ne.oop.bsupermat.payload.ApiResponse;
import ne.oop.bsupermat.serviceImpls.ProductTypeServiceImpl;
import ne.oop.bsupermat.utils.ExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("api/v1/product_type")
public class ProductTypeController {
    private final ProductTypeServiceImpl productTypeServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllProductTypes(){
        try{
            return ResponseEntity.ok(new ApiResponse(true,"Product_type retrieved sucessfully",productTypeServiceImpl.getAllProductTypes()));

        }catch (Exception e){
            return ExceptionUtils.handleControllerExceptions(e);
        }
    }


    @PostMapping("/create_product_type")

    public ResponseEntity<ApiResponse> createProductType(@RequestBody CreateProductTypeDTO createProductTypeDTO){
        try{
            return ResponseEntity.ok(new ApiResponse(true,"Product_type created successfully",productTypeServiceImpl.saveProductType(createProductTypeDTO)));
        }catch(Exception e){
            return ExceptionUtils.handleControllerExceptions(e);
        }
    }
}
