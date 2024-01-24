package com.japroject.controller;

import com.japroject.model.User;
import com.japroject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    @ResponseBody
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user) {
        userService.saveUser(user);
    }
    @PostMapping("/admin")
    public void addAdmin(@RequestBody User user) {
        userService.saveAdmin(user);
    }

}
