package com.example.login.service;

import com.example.login.repository.LoginRepository;
import com.example.users.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional  // 트랜잭션이 없어도 상호작용 가능
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    @Autowired
    public LoginServiceImpl(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    public Member login(String id) {
        return loginRepository.findById(id);
    }
}