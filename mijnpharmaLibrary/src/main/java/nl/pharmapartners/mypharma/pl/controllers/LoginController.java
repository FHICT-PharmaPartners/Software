package nl.pharmapartners.mypharma.pl.controllers;


import nl.pharmapartners.mypharma.library.AuthenticationRequest;
import nl.pharmapartners.mypharma.library.AuthenticationResponse;
import nl.pharmapartners.mypharma.library.JwtUtil;
import nl.pharmapartners.mypharma.library.UserDetailService;
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
public class LoginController {

    private UserDetailService userDetailsService;
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

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
        return ResponseEntity.ok(new AuthenticationResponse(jwt));
    }

    @GetMapping(value = "/login")
    public String login() {
        return "<script\n" +
                "  src=\"https://code.jquery.com/jquery-3.4.1.min.js\"\n" +
                "  integrity=\"sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo=\"\n" +
                "  crossorigin=\"anonymous\"></script>" +
                "<form action='/api/login' method='post'><input name='username'></input><input name='password'></input><button>soiehfe</button></form>" +
                "<script>" +
                "$.ajax({" +
                "url: '/api/login'," +
                "type: 'post'," +
                "data: '{" +
                "  \"username\": \"test@test.nl\"," +
                "  \"password\": \"P@ssw0rd\"" +
                "}'," +
                "dataType: 'json'," +
                "contentType: 'application/json'," +
                "success: function(data) {" +
                "localStorage.setItem('jwt', data.jwt);" +
                "}" +
                "})" +
                "</script>";
    }
}
