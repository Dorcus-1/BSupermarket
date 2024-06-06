package ne.oop.bsupermat.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ne.oop.bsupermat.dto.requests.LoginDTO;
import ne.oop.bsupermat.dto.response.LoginResponse;
import ne.oop.bsupermat.payload.ApiResponse;
import ne.oop.bsupermat.services.AuthService;
import ne.oop.bsupermat.utils.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/auth")
@Slf4j
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> login(@RequestBody LoginDTO loginDTO) {
        try {
            log.info("Request to login user {}", loginDTO.getEmail());
            LoginResponse loginResponse = authService.login(loginDTO);
            return new ResponseEntity<>(new ApiResponse(
                    true,
                    "Login successful",
                    loginResponse
            ), HttpStatus.OK);

        } catch (Exception e) {
            log.error("Error occurred while logging in user {}", loginDTO.getEmail(), e);
            return  ExceptionUtils.handleControllerExceptions(e);
        }
    }
}
