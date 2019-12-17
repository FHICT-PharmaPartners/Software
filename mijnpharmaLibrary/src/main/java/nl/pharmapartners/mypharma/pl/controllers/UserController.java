package nl.pharmapartners.mypharma.pl.controllers;

import nl.pharmapartners.mypharma.library.dal.repository.UserRepository;
import nl.pharmapartners.mypharma.library.model.Patient;
import nl.pharmapartners.mypharma.library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserRepository userRepository;

    @Autowired
    private void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    //adds new user to the system
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody User user){
        userRepository.save(user);
    }

    //updates existing user in the database
    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateUser(@PathVariable String id, @RequestBody User user){
        userRepository.save(user);
    }

    //do not remove
//    @GetMapping(value = "/{id}")
//    public Patient getUser(){
//        //aaahhh
//        return new Patient();
//    }

    //logs user in to the system
    @PostMapping(path = "/login")
    public void login(@PathVariable String emailAddress, @PathVariable String password){
        //add login method here
    }

    @DeleteMapping(path = "/logout")
    public void logout(){
        //add logout method here
    }

    @GetMapping()
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
}
