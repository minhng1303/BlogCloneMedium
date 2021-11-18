package com.hanu.mediumclone.controllers;

import com.hanu.mediumclone.models.JwtRequest;
import com.hanu.mediumclone.models.JwtResponse;
import com.hanu.mediumclone.services.MyUserDetailsService;
import com.hanu.mediumclone.utils.JwtUtils;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@AllArgsConstructor
@NoArgsConstructor
public class HelloController {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService userDetailsService;

    @GetMapping("/")
    public String hello() {
        System.out.println("Inside");
        return "Hello World";
    }

    @PostMapping("/authenticate")
    public JwtResponse authenticate(@RequestBody JwtRequest jwtRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            jwtRequest.getUsername(),
                            jwtRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Invalid Credential " + e.getMessage());
        }

        final UserDetails userDetail = userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        final String token = jwtUtils.generateToken(userDetail);
        return new JwtResponse(token, userDetail.getUsername());
    };

}
