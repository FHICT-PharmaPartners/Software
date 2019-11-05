package nl.pharmapartners.mypharma.restserver.controllers;

import nl.pharmapartners.mypharma.library.model.Patient;
import nl.pharmapartners.mypharma.library.model.User;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/user")
public class UserController {

    //Post request to register the user
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addNewUser(@RequestBody User user) {

    }

    //Get request for single user
    @GetMapping(value = "/{id}")
    public void getUserById(@PathParam("id") int id) {

    }

    //Put request to update user information
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUserInformation(User user) {

    }

    //Post request to log the user in
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void logUserIn(String emailAddress, String password) {

    }

    //Delete request to log the user out
    @DeleteMapping()
    public void logUserOut() {

    }
}
