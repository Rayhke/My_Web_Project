package com.example.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@ToString
@Builder
@AllArgsConstructor
public class User {

    @Id
    private String nickname;

    private String role;

    public void updateUser(String nickname, String role) {
        this.nickname = nickname;
        this.role = role;
    }

    public void updateRoleType(String role) {
        this.role = role;
    }

}
