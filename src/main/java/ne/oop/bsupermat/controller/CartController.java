package ne.oop.bsupermat.controller;

import lombok.RequiredArgsConstructor;
import ne.oop.bsupermat.dto.requests.CreateCartDTO;
import ne.oop.bsupermat.model.Cart;
import ne.oop.bsupermat.payload.ApiResponse;
import ne.oop.bsupermat.serviceImpls.CartServiceImpl;
import ne.oop.bsupermat.utils.ExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartServiceImpl cartService;
    @GetMapping("/all")
    public ResponseEntity<ApiResponse> getAllCarts() {
        try {
            return ResponseEntity.ok(new ApiResponse(true,"Carts retrieved successfully", cartService.getAllCarts()));
        } catch (Exception e) {
            return  ExceptionUtils.handleControllerExceptions(e);
        }
    }
    @PostMapping("/create_cart")
    public ResponseEntity<ApiResponse> createCart(@RequestBody CreateCartDTO createCartDTO){
        try {
            return ResponseEntity.ok(new ApiResponse(true,"Cart created successfully", cartService.saveCart(createCartDTO)));
        } catch (Exception e) {
            return  ExceptionUtils.handleControllerExceptions(e);
        }
    }


}
