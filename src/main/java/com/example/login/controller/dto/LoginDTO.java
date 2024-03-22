package com.example.login.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LoginDTO {

    private String id;

    private String pwd;

    /*public Login Join() {
        return new Login().builder().build();
    }*/
}