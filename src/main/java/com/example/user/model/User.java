

package com.example.user.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class User {

    private Integer userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private Integer cardId;
    private Card card;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
    private LocalDateTime deleteAt;


}
