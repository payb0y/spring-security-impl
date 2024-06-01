package com.example.demo.employee.api;

import com.example.demo.employee.entity.Token;
import com.example.demo.employee.repository.EmployeRepository;
import com.example.demo.employee.repository.TokenRepository;
import com.example.demo.employee.service.JwtService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(path = "api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final EmployeRepository employeRepository;
    private final TokenRepository tokenRepository;
    private final JwtService jwtService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest authRequest) {
        try {
            UserDetails userDetails = employeRepository.findByEmail(authRequest.email).orElseThrow(() -> new IllegalArgumentException("User not found"));
            log.info("User details: {}", userDetails);
            String token = jwtService.generateToken(userDetails);
            List<Token> tokens = tokenRepository.getAllTokensByMail(userDetails.getUsername());
            tokens.forEach(t -> t.setIsRevoked(true));
            tokenRepository.saveAll(tokens);
            tokenRepository.save(Token.builder()
                    .token(token)
                    .email(userDetails.getUsername())
                    .isRevoked(false)
                    .build());

            return ResponseEntity.ok(token);
        } catch (Exception e) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }


    public record AuthRequest(String email, String password) {
    }
}
