package com.example.user.service;

import com.example.user.dto.UserDTO;
import com.example.user.entity.Member;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    @Autowired
    private final EntityManager em;

    public User save(UserDTO userDTO) {
        return null;
    }

    public Member findById(String userId) {
        return em.find(Member.class, userId);
    }
}
