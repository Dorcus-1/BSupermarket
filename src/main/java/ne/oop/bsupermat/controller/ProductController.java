package ne.oop.bsupermat.controller;


import lombok.AllArgsConstructor;
import ne.oop.bsupermat.dto.requests.CreateProductDTO;
import ne.oop.bsupermat.payload.ApiResponse;
import ne.oop.bsupermat.serviceImpls.ProductServiceImpl;
import ne.oop.bsupermat.utils.ExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/product")
@AllArgsConstructor
public class ProductController {
    private final ProductServiceImpl productServiceImpl;

    @GetMapping("/all")
    public ResponseEntity <ApiResponse> getAllProducts(){
        try{
            return ResponseEntity.ok(new ApiResponse(true,"Products retrieved sucessfully",productServiceImpl.getAllProducts()));
        }catch (Exception e){
            return ExceptionUtils.handleControllerExceptions(e);
        }
    }

    @PostMapping("create_product")
    public ResponseEntity<ApiResponse> createProducts(@RequestBody CreateProductDTO createProductDTO) {
        try {
            return ResponseEntity.ok(new ApiResponse(true, "Product created successfully", productServiceImpl.saveProduct(createProductDTO)));
        }catch (Exception e){
            return ExceptionUtils.handleControllerExceptions(e);
        }
    }
}
