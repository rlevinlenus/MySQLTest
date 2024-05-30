package com.testrest.MySQLRest.controller;

import com.testrest.MySQLRest.model.User;
import com.testrest.MySQLRest.repository.UserJPARepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/users")
public class UserController {

    @Autowired
    private UserJPARepository userJPARepository;

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userJPARepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable final String firstname){
        User user = userJPARepository.findByName(firstname);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping("/load")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User localuser = userJPARepository.save(user);
        return new ResponseEntity<>(localuser, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        userJPARepository.deleteById(id);
        return new ResponseEntity<>("User successfully deleted", HttpStatus.NOT_FOUND);
    }

}
