package ne.oop.bsupermat.controller;

import lombok.AllArgsConstructor;
import ne.oop.bsupermat.dto.requests.CreateQuantityDTO;
import ne.oop.bsupermat.dto.requests.CreateRoleDTO;
import ne.oop.bsupermat.payload.ApiResponse;
import ne.oop.bsupermat.serviceImpls.RoleServiceImpl;
import ne.oop.bsupermat.utils.ExceptionUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/role")
@AllArgsConstructor
public class RoleController {
    private final RoleServiceImpl roleServiceImpl;

    @GetMapping("all")
    public ResponseEntity<ApiResponse> getAllRoles(){
        try{
            return ResponseEntity.ok(new ApiResponse(true,"Roles retrieved successfully",roleServiceImpl.getAllRoles()));

        }catch (Exception e){
            return ExceptionUtils.handleControllerExceptions(e);
        }
    }
    @PostMapping("/create_role")

    public ResponseEntity<ApiResponse> createRole(@RequestBody CreateRoleDTO createRoleDTO){
        try{
            return ResponseEntity.ok(new ApiResponse(true,"Role created successfully",roleServiceImpl.saveRole(createRoleDTO)));
        }catch(Exception e){
            return ExceptionUtils.handleControllerExceptions(e);
        }
    }
}
