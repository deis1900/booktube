package com.booktube.restController;

import com.booktube.model.User;
import com.booktube.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/registration",consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<User> registration(User user){
        return new ResponseEntity<User>(userService.saveAndFlush(user), HttpStatus.OK);
    }

}

