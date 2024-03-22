package com.example.login.repository;

import com.example.users.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;

public class LoginJpaRepository implements LoginRepository {

    private final EntityManager em;

    @Autowired
    public LoginJpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Member findById(String id) {
        try {
            Member result = em.find(Member.class, id);
            return result;
        } catch(Exception e) {
            throw new IllegalArgumentException("[조회 실패] : " + e);
        }
    }
}