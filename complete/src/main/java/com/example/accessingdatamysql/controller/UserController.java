package com.example.accessingdatamysql.controller;

import com.example.accessingdatamysql.entity.User;
import com.example.accessingdatamysql.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/view/{id}")
    public String listUsers(@RequestParam(name="id", required=false, defaultValue="1")  Integer id, Model model) {
        User u=userService.getUserWithId(id);
        model.addAttribute("username", u.getUsername());
        model.addAttribute("email", u.getEmail());
        return "user";
    }

    @GetMapping("/list")
    public String listUAllsers(Model model) {
        List<User> users=userService.fetchUserList();
        model.addAttribute("users", users);
        return "list";
    }
}
