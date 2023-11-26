package com.example.datasofttestapi.controllers;

import com.example.datasofttestapi.models.dtos.LoginDTO;
import com.example.datasofttestapi.models.entities.User;
import com.example.datasofttestapi.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/BOOKSTORE")
public class LoginController {

    @Autowired
    UserService usrSv;
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO data){
        try{
            User user = usrSv.findByUsername(data.getUsername());
            if (user != null && user.getPasswd().equals(data.getPassword())) {
                return new ResponseEntity<>("Acceso concedido", HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<>("Username or password incorrect", HttpStatus.UNAUTHORIZED);
            }

        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Error during login process", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
