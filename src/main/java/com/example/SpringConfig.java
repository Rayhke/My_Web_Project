package com.example;

import com.DB_Test.JPA.MemberService;
import com.example.forum.repository.ForumJpaRepository;
import com.example.forum.repository.ForumRepository;
import com.example.forum.service.ForumService;
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

    @Bean
    public ForumService forumService() {
        return new ForumService(forumRepository());
    }

    @Bean
    public ForumRepository forumRepository() {
        return new ForumJpaRepository(em);
    }
}
