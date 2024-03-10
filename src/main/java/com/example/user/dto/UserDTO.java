package com.example.user.dto;

import com.example.user.entity.Member;
import com.example.user.entity.User;
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
public class UserDTO {
    private String userId;
    private String userPwd;
    private String userNickname;
    private String userPhone;
    private String userEmail;

<<<<<<< HEAD
    /*public User userEntity() {
=======
    public User userEntity() {
>>>>>>> 2788a79b835efcc00a4616021485da918b740814
        return User.builder()
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
<<<<<<< HEAD
    }*/
=======
    }
>>>>>>> 2788a79b835efcc00a4616021485da918b740814
}
