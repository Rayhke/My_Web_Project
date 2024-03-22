package com.example.users.controller.dto;

import com.example.users.entity.Member;
import com.example.users.entity.Users;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor      // 기본 생성자 자동 생성
@AllArgsConstructor     // 필드 변수를 매개변수로 한 생성자 자동 생성
public class UsersDTO {

    private String userId;

    private String userPwd;

    private String userNickname;

    private String userPhone;

    private String userEmail;

    public Users userEntity() {
        return Users.builder()
                .nickname(userNickname)
                .role(null)
                .build();
    }

    public Member memberEntity() {
        return Member.builder()
                .id(userId)
                .pwd(userPwd)
                .nickname(userNickname)
                .phone(userPhone)
                .email(userEmail)
                .build();
    }
}
