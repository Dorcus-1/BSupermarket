package ne.oop.bsupermat.controller;

import lombok.AllArgsConstructor;
import ne.oop.bsupermat.dto.requests.CreateRoleDTO;
import ne.oop.bsupermat.dto.requests.CreateUserDTO;
import ne.oop.bsupermat.payload.ApiResponse;
import ne.oop.bsupermat.serviceImpls.UserServiceImpl;
import ne.oop.bsupermat.utils.ExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/user")
@AllArgsConstructor
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @GetMapping("all")
    public ResponseEntity<ApiResponse> getAllUser(){
        try{
            return ResponseEntity.ok(new ApiResponse(true,"Users retrieved successfully",userServiceImpl.getAllUsers()));

        }catch (Exception e){
            return ExceptionUtils.handleControllerExceptions(e);
        }
    }
    @PostMapping("/create_user")

    public ResponseEntity<ApiResponse> createUser(@RequestBody CreateUserDTO createUserDTO){
        try{
            return ResponseEntity.ok(new ApiResponse(true,"User created successfully",userServiceImpl.saveUser(createUserDTO)));
        }catch(Exception e){
            return ExceptionUtils.handleControllerExceptions(e);
        }
    }
}
