package com.example.users.service;

import com.example.users.controller.dto.UsersDTO;
import com.example.users.entity.Member;
import com.example.users.entity.Users;
import com.example.users.repository.UsersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class UsersService {

    @Autowired
    private final UsersRepository usersRepository;

    @Autowired
    private final EntityManager em;

    public Users save(UsersDTO usersDTO) {
        return null;
    }

    public Member findById(String userId) {
        return em.find(Member.class, userId);
    }
}
