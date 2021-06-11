package com.example.library.controller;

import com.example.library.model.User;
import com.example.library.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path="/add") // Map ONLY POST Requests
    public  String addNewUser (@RequestParam String name,
                                            @RequestParam String surname,
                                            @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = userService.createUser(name,surname, email);
        userService.save(n);

        return "Saved";
    }

    @GetMapping(path="/all")
    public Iterable<User> getAllUsers(){

        return userService.findAll();
    }

}
