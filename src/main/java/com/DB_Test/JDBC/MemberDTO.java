package com.DB_Test.JDBC;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDTO {

    private String id;

    private String pwd;

    private String nickname;

    private String phone;

    private String email;

    @Override
    public String toString() {
        return "MemberDTO [id=" + id + ", password=" + pwd + ", nickname=" + nickname + ", phone=" + phone + ", email="
                + email + "]";
    }
}
