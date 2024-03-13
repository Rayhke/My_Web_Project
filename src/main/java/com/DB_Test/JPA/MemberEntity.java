package com.DB_Test.JPA;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "member")
public class MemberEntity {

    @Id
    @Column(name = "member_id", length = 50)
    private String member_id;

    @Column(name = "password", length = 45)
    private String pwd;

    @Column(length = 45)
    private String nickname;

    @Column(length = 45)
    private String phone;

    @Column(length = 45)
    private String email;

    @Override
    public String toString() {
        return "MemberEntity [id=" + member_id + ", password=" + pwd + ", nickname=" + nickname + ", phone=" + phone + ", email="
                + email + "]";
    }
}