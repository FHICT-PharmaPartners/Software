package nl.pharmapartners.mypharma.restserver.controllers;

import com.google.gson.Gson;
import nl.pharmapartners.mypharma.library.bll.UserRepository;
import nl.pharmapartners.mypharma.library.model.User;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController()
@RequestMapping("/example")
public class ExampleController {

    // GET /api/example
    @GetMapping()
    public String test() {
        return "Test Method";
    }

    // GET /api/example/users
    @GetMapping("/users")
    public String users() {
         ArrayList<User> users = new UserRepository().getUsers();
         return new Gson().toJson(users).toString();
    }

    // GET /api/example/paramFromUrl/cheesecake
    @GetMapping("/paramFromUrl/{param}")
    public String fromUrl(@PathVariable("param") String param) {
        return "Your param is: " + param;
    }

    // GET /api/example/test
    @GetMapping("/test")
    public String ff() {
        return "Test with extra path";
    }

    // GET /api/example/echo?text=HELLO
    @GetMapping("/echo")
    public String echo(@RequestParam("text") String text) {
        return text;
    }

    // POST /api/example/multiply
    // DATA: a = Hello
    //       b = World
    @PostMapping("/test")
    public String post(@RequestParam("a") String a, @RequestParam("b") String b) {
        JSONObject json = new JSONObject();
        json.put("a", a);
        json.put("b", b);
        return json.toString();
    }

    // PUT /api/example/multiply
    // DATA: a = 3
    //       b = 5
    @PutMapping("/multiply")
    public String multiply(@RequestParam("a") int a, @RequestParam("b") int b) {
        JSONObject json = new JSONObject();
        json.put("a", a);
        json.put("b", b);
        json.put("result", a * b);
        return json.toString();
    }

}
