package com.example.users.entity;

import lombok.Getter;

@Getter
public enum RoleType {
    Y("관리자", true),
    N("일반인", false);

    private String title;
    private boolean check;

    RoleType(String title, boolean check) {
        this.title = title;
        this.check = check;
    }
}
