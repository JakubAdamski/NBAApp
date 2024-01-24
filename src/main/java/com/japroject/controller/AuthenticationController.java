package com.japroject.controller;


import com.japroject.model.User;
import com.japroject.request.AuthenticationRequest;
import com.japroject.request.RegisterRequest;
import com.japroject.response.AuthenticationResponse;
import com.japroject.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/aut")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class AuthenticationController {


    private final AuthenticationService authenticationService;

    @PostMapping("/rejestracja")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request
    ) {
        return ResponseEntity.ok(authenticationService.register(request));
    }

    @PostMapping("/logowanie")
    public ResponseEntity<AuthenticationResponse> login(
            @RequestBody AuthenticationRequest request
    ) {
        return ResponseEntity.ok(authenticationService.authenticate(request));

    }

    @GetMapping("/me")
    public ResponseEntity<User> me() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) authentication.getPrincipal();
        return ResponseEntity.ok(user);
    }

}
