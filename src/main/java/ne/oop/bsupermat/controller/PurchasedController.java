package ne.oop.bsupermat.controller;

import lombok.AllArgsConstructor;
import ne.oop.bsupermat.dto.requests.CreateProductTypeDTO;
import ne.oop.bsupermat.dto.requests.CreatePurchasedDTO;
import ne.oop.bsupermat.payload.ApiResponse;
import ne.oop.bsupermat.serviceImpls.PurchasedServiceImpl;
import ne.oop.bsupermat.utils.ExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/purchased")
@AllArgsConstructor
public class PurchasedController {
    private final PurchasedServiceImpl purchasedServiceImpl;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllPurchased(){
        try{
            return ResponseEntity.ok(new ApiResponse(true,"Purchases retrieved sucessfully",purchasedServiceImpl.getAllPurchased()));

        }catch (Exception e){
            return ExceptionUtils.handleControllerExceptions(e);
        }
    }
    @PostMapping("/create_purchased")

    public ResponseEntity<ApiResponse> createProductType(@RequestBody CreatePurchasedDTO createPurchasedDTO){
        try{
            return ResponseEntity.ok(new ApiResponse(true,"Purchase created successfully",purchasedServiceImpl.savePurchased(createPurchasedDTO)));
        }catch(Exception e){
            return ExceptionUtils.handleControllerExceptions(e);
        }
    }

}
