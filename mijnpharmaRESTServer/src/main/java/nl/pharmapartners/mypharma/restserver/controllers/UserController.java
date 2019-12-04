package nl.pharmapartners.mypharma.restserver.controllers;

import com.google.gson.Gson;
import nl.pharmapartners.mypharma.library.bll.UserRepository;
import nl.pharmapartners.mypharma.library.model.User;
import nl.pharmapartners.mypharma.restserver.model.MedicalInfo;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    //Post request to register the user
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addNewUser(@RequestBody User user) {

    }

    //Get request for single user
    @GetMapping(value = "/{id}")
    public String getUserById(@PathVariable("id") int id) {
        User user = new UserRepository().getUserById(id);
        String response = new Gson().toJson(user);

        return response;
    }

    //Put request to update user information
    @PutMapping(value = "/{id}/updateUserInfo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateUserInformation(@PathVariable("id") String id, @ModelAttribute MedicalInfo info) {

    }
    
    //Post request to log the user in
    @GetMapping()
    public String getEmail(HttpSession session) {
        return (String) session.getAttribute("email");
    }
}
