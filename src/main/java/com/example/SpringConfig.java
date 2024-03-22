package com.example;

import com.example.forum.repository.ForumJpaRepository;
import com.example.forum.repository.ForumRepository;
import com.example.forum.service.ForumService;
import com.example.forum.service.ForumServiceImpl;
import com.example.login.repository.LoginJpaRepository;
import com.example.login.repository.LoginRepository;
import com.example.login.service.LoginService;
import com.example.login.service.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;

@Configuration
public class SpringConfig {

    private final EntityManager em;

    @Autowired
    public SpringConfig(EntityManager em) {
        this.em = em;
    }
    // ===============================================
    /** 로그인 */
    @Bean
    public LoginService loginService() {
        return new LoginServiceImpl(loginRepository());
    }

    @Bean
    public LoginRepository loginRepository() {
        return new LoginJpaRepository(em);
    }
    // ===============================================
    /** 게시판 */
    @Bean
    public ForumService forumService() {
        return new ForumServiceImpl(forumRepository());
    }

    @Bean
    public ForumRepository forumRepository() {
        return new ForumJpaRepository(em);
    }
    // ===============================================
}