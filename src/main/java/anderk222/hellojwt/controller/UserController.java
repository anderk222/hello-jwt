package anderk222.hellojwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import anderk222.hellojwt.model.User;
import anderk222.hellojwt.service.UserService;

@RestController
@CrossOrigin("*")
public class UserController {
    
    @Autowired
    UserService service;

    @PostMapping("/register")
    public String register(@RequestBody User user){

        service.register(user); 

        return "ok";

    }

}
