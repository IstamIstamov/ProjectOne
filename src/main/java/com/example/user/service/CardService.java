package com.example.user.service;

import com.example.user.model.Card;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class CardService {
    private List<Card> cardList;
    private Integer index;
    public CardService(){
        this.cardList = new ArrayList<>();
        this.index = 0;
    }

    public String create(Card card) {
        if (card.getCardNumber().toString().length() != 16){
            return "Card number is error";
        }
        card.setCardId(++this.index);
        card.setCreateAt(LocalDateTime.now());
        this.cardList.add(card);
        return "Card successful created";
    }

    public Card get(Integer id) {
        for (Card card:this.cardList) {
            if(card.getCardId().equals(id) && card.getDeleteAt() == null){
                return card;
            }
        }
        return null;
    }

    public String update(Card card, Integer id) {
        Card c = get(id);
        if(c == null){
            return "Card is not found";
        }
        c.setCardName(card.getCardName());
        c.setCardNumber(card.getCardNumber());
        c.setUpdateAt(LocalDateTime.now());
        this.cardList.add(c);
        return "Card successful updated";
    }

    public String delete(Integer id) {
        Card card = get(id);
        if(card == null){
            return "Card is not found";
        }
        card.setDeleteAt(LocalDateTime.now());
        this.cardList.add(card);
        return "Card successful deleted";
    }
}
