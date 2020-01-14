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
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class LoginController {

    private UserDetailService userDetailsService;
    private JwtUtil jwtUtil;
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;
  
    @Autowired
    private void setUserDetailsService(UserDetailService userDetailsService,
                                       UserRepository userRepository) {
        this.userDetailsService = userDetailsService;
        this.userRepository = userRepository;
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
        user.setEmailAddress(authenticationRequest.getUsername());
      
        Example<User> example = Example.of(user);
        Optional<User> optionalUser = userRepository.findOne(example);

        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user with username: " + authenticationRequest.getUsername());
        }

        user = optionalUser.get();
        user.setToken(jwt);

        userRepository.save(user);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }
}
