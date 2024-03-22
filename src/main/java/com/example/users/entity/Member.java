package com.example.users.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
public class Member {

    @Id
    @Column(name = "member_id")
    private String id;

    @Column(name = "password")
    private String pwd;

    /*@Column(name = "nickname")
    private String name;*/
    // private User user;  // FK 인, user 테이블의 nickname 을 참조

    private String nickname;

    private String phone;

    private String email;

}
