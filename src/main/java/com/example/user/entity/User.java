package com.example.user.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.EnumType;
import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

@Entity
@Getter
// @Setter
@ToString
@Builder
@AllArgsConstructor
public class User {

    @Id
    private String nickname;

    /*@Column
    @Enumerated(EnumType.STRING)
    private RoleType role;*/
    private String role;

    public void updateUser(String nickname, String role) {
        this.nickname = nickname;
        this.role = role;
    }

    public void updateRoleType(String role) {
        this.role = role;
    }

}
