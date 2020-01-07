package nl.pharmapartners.mypharma.pl.controllers;

import nl.pharmapartners.mypharma.library.dal.repository.PatientMedicineRepository;
import nl.pharmapartners.mypharma.library.dal.repository.UserRepository;
import nl.pharmapartners.mypharma.library.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/user")
public class UserController {

    private UserRepository userRepository;
    private PatientMedicineRepository patientRepository;

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

    @GetMapping()
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping(path = "/{token}")
    public User getUserByToken(@PathVariable String token){

        User user = new User();
        user.setToken(token);
        Example<User> example = Example.of(user);
        Optional<User> optionalUser = userRepository.findOne(example);

        if(optionalUser.isEmpty()) {
            throw new UsernameNotFoundException("Could not find user with token: " + token);
        }

        user = optionalUser.get();
        return user;
    }
}
