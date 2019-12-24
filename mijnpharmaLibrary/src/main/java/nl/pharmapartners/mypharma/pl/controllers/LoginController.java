package nl.pharmapartners.mypharma.pl.controllers;


import nl.pharmapartners.mypharma.library.AuthenticationRequest;
import nl.pharmapartners.mypharma.library.AuthenticationResponse;
import nl.pharmapartners.mypharma.library.JwtUtil;
import nl.pharmapartners.mypharma.library.UserDetailService;
import nl.pharmapartners.mypharma.library.dal.repository.UserRepository;
import nl.pharmapartners.mypharma.library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:1800", maxAge = 3600)
public class LoginController {

    private UserDetailService userDetailsService;
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private void setUserDetailsService(UserDetailService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Autowired
    private void setJwtUtil(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username or password", e);
        }
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt = jwtUtil.generateToken(userDetails);

        User user = new User();
        user.setJwt(jwt);
        Example<User> example = Example.of(user);
        Optional<User> option = userRepository.findOne(example);

        user = option.get();
        user.setJwt(jwt);

        userRepository.save(user);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
