package com.microservice.controller;

import com.microservice.dto.AuthenticationReqDTO;
import com.microservice.dto.ResponseDTO;
import com.microservice.security.JwtTokenUtil;
import com.microservice.security.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {
    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtTokenUtil tokenUtil;

    @PostMapping(path = "/authenticate")
    public ResponseEntity<ResponseDTO> createAuthenticationToken(@RequestBody AuthenticationReqDTO authReqDTO) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authReqDTO.getUsername(), authReqDTO.getPassword()));
        } catch (BadCredentialsException ex) {
            throw new Exception("Wrong password", ex);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authReqDTO.getUsername());
        final String jwt = tokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new ResponseDTO(jwt));
    }

    @GetMapping(path = "/test")
    public ResponseEntity<?> createAuthenticationToken() throws Exception {
        return ResponseEntity.ok("Hello");
    }
}
