package com.example.forum.repository;

import com.example.forum.entity.Forum;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

public class ForumJpaRepository implements ForumRepository {

    private final EntityManager em;

    @Autowired
    public ForumJpaRepository(EntityManager em) {
        this.em = em;
    }

    public Forum update(Forum forum) {
        Forum result = em.find(Forum.class, forum.getId());
        result.update(forum);
        return result;
    }

    @Override
    public List<Forum> findAll() {
        // return em.createQuery("SELECT f FROM forum f ORDER BY f.id DESC", Forum.class).getResultList();
        return em.createNativeQuery("SELECT * FROM forum ORDER BY id DESC", Forum.class).getResultList();
    }
}

/**
 * 의도치 않은 값을 건내줬을 경우
 * throw new IllegalArgumentException("");
 *
 * 의도치 않은 값을 받았을 경우
 * throw new IllegalStateException("");
 */