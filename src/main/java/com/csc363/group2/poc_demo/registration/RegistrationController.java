package com.csc363.group2.poc_demo.registration;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins ="*")
@RequestMapping(path = "api/v1/registration")
@AllArgsConstructor
public class RegistrationController {

    private final RegistrationService registrationService;

    @PostMapping
    public String register(@RequestBody RegistrationRequest request) {
        return registrationService.register(request);
    }

    @GetMapping(path = "confirm")
    public String confirm(@RequestParam("token") String token) {
        return registrationService.confirmToken(token);
    }

}
