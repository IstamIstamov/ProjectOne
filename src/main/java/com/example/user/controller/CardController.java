package com.example.user.controller;

import com.example.user.model.Card;
import com.example.user.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// localhost:8080/card
@RestController
@RequestMapping("card")
public class CardController {

    private CardService cardService;

    private CardController(CardService cardService){
        this.cardService = cardService;
    }
    // localhost:8080/card/create
    @PostMapping("/create")
    public ResponseEntity<?> createCard(@RequestBody Card card){
        String result = cardService.create(card);
        return ResponseEntity.ok(result);
    }
    // localhost:8080/card/get
    @GetMapping("/get")
    public ResponseEntity<?> getCard(@RequestParam Integer id){
        Card result = cardService.get(id);
        if (result == null){
            return ResponseEntity.badRequest().body("Card is not found");
        }
        return ResponseEntity.ok(result);
    }
    // localhost:8080/card/update
    @PutMapping("/update")
    public ResponseEntity<?> updateCard(@RequestBody Card card,@RequestParam Integer id){
        String result = cardService.update(card, id);
        return ResponseEntity.ok(result);
    }
    // localhost:8080/card/delete
    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCard(@RequestParam Integer id){
        String result = cardService.delete(id);
        return ResponseEntity.ok(result);
    }
}
