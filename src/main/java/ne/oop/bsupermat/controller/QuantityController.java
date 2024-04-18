package ne.oop.bsupermat.controller;

import lombok.AllArgsConstructor;
import ne.oop.bsupermat.dto.requests.CreatePurchasedDTO;
import ne.oop.bsupermat.dto.requests.CreateQuantityDTO;
import ne.oop.bsupermat.payload.ApiResponse;
import ne.oop.bsupermat.serviceImpls.QuantityServiceImpl;
import ne.oop.bsupermat.utils.ExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/quantity")
@AllArgsConstructor
public class QuantityController {

    private final QuantityServiceImpl quantityServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllQuantities(){
        try{
            return ResponseEntity.ok(new ApiResponse(true,"Quantities retrieved successfully",quantityServiceImpl.getAllQuantities()));

        }catch (Exception e){
            return ExceptionUtils.handleControllerExceptions(e);
        }
    }
    @PostMapping("/create_quantity")

    public ResponseEntity<ApiResponse> createQuantity(@RequestBody CreateQuantityDTO createQuantityDTO){
        try{
            return ResponseEntity.ok(new ApiResponse(true,"Quantity created successfully",quantityServiceImpl.saveQuantity(createQuantityDTO)));
        }catch(Exception e){
            return ExceptionUtils.handleControllerExceptions(e);
        }
    }
}
