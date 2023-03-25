package com.example.user.controller;

import com.example.user.model.Card;
import com.example.user.service.UserService;
import com.example.user.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("user")
public class UserController {
    private UserService userService;

    private UserController(UserService userService){
        this.userService = userService;
    }
    // localhost:8080/card/create
    @PostMapping("/create")
    public ResponseEntity<?> createCard(@RequestBody User user){
        String result = userService.create(user);
        return ResponseEntity.ok(result);
    }
    // localhost:8080/card/get
    @GetMapping("/get")
    public ResponseEntity<?> getCard(@RequestParam Integer id){
        User result = userService.get(id);
        if (result == null){
            return ResponseEntity.badRequest().body("Card is not found");
        }
        return ResponseEntity.ok(result);
    }
    // localhost:8080/card/update
    @PutMapping("/update")
    public ResponseEntity<?> updateCard(@RequestBody User user, @RequestParam Integer id){
        String result = userService.update(user, id);
        return ResponseEntity.ok(result);
    }
    // localhost:8080/card/delete
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCard(@RequestParam Integer id){
        String result = userService.delete(id);
        return ResponseEntity.ok(result);
    }
}
