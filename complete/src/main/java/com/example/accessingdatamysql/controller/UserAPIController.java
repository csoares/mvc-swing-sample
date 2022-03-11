package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.entity.User;
import com.example.accessingdatamysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController

@RequestMapping(path="/demo") // This means URL's start with /demo (after Application path)
public class UserAPIController {
    @Autowired  private UserService userService;

    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody String addNewUser (@RequestParam String name
            , @RequestParam String email,  @RequestParam String password) {

        User n = new User();

        n.setUsername(name);
        n.setEmail(email);
        n.setPassword(password);

        userService.saveUser(n);
        return "saved";
    }

    @PostMapping("/users")
    public User saveDepartment(
            @Valid  @RequestBody  User user)
    {
        return userService.saveUser(user);
    }

    @GetMapping("/all")
    public @ResponseBody Iterable<User> getAllUsers() {
        return userService.fetchUserList();
    }



}