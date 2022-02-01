package com.alkemy.disney.disney.auth.controller;

import com.alkemy.disney.disney.auth.dto.AuthenticationRequest;
import com.alkemy.disney.disney.auth.dto.AuthenticationResponse;
import com.alkemy.disney.disney.auth.dto.UserDTO;
import com.alkemy.disney.disney.auth.service.JwtUtils;
import com.alkemy.disney.disney.auth.service.UserDetailCustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class UserAuthController{

    private UserDetailCustomService userDetailCustomService;
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtTokenUtil;

    @Autowired
    public UserAuthController(
            UserDetailCustomService userDetailCustomService,
            AuthenticationManager authenticationManager,
            JwtUtils jwtTokenUtil){
        this.userDetailCustomService = userDetailCustomService;
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;

    }
    @PostMapping("/singup")//TODO "@valid como primera anotacion de singup
    public ResponseEntity<Object> singUp(@RequestBody UserDTO user) throws Exception{
        this.userDetailCustomService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).build();}

    @PostMapping("/singin")
    public ResponseEntity<AuthenticationResponse> singin(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        UserDetails userDetails;
        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword())
            );
                userDetails = (UserDetails) auth.getPrincipal();
            }catch (BadCredentialsException e){
                throw new Exception("Incorrect username or password", e);
        }

        final String jwt = jwtTokenUtil.generateToken(userDetails);
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
        }

    }

