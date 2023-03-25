package com.example.user.service;

import com.example.user.model.Card;
import com.example.user.model.User;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private CardService cardService;
    private List<User> userList;
    private Integer index;
    public UserService(CardService cardService){
        this.cardService = cardService;
        this.userList = new ArrayList<>();
        this.index = 0;
    }
    public String create(User user) {
        Card card = cardService.get(user.getCardId());
        if (card == null){
            return "Card is not found";
        }
        user.setUserId(++this.index);
        user.setCard(card);
        user.setCreateAt(LocalDateTime.now());
        this.userList.add(user);
        return "User successful created";
    }

    public User get(Integer id) {
        for (User user: this.userList) {
            if(user.getUserId().equals(id) && user.getDeleteAt() == null){
                return user;
            }
        }
        return null;
    }

    public String update(User user, Integer id) {
        Card card = cardService.get(user.getCardId());
        if (card == null){
            return "Card is not found";
        }
        User u = get(id);
        if(u == null){
            return "User is not found";
        }
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setSurname(user.getSurname());
        u.setPassword(user.getPassword());
        u.setCardId(user.getCardId());
        u.setCard(card);
        u.setUpdateAt(LocalDateTime.now());
        this.userList.add(u);
        return "User successful updated";
    }

    public String delete(Integer id) {
        User user = get(id);
        if(user == null){
            return "User is not found";
        }
        user.setDeleteAt(LocalDateTime.now());
        this.userList.add(user);
        return "User successful deleted";
    }

}
