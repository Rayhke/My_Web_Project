package com.example.forum.repository;

import com.example.forum.entity.Forum;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class ForumJpaRepository implements ForumRepository {

    /*private final DataSource dataSource;

    @Autowired
    public ForumJpaRepository(DataSource dataSource) {
        this.dataSource = dataSource;
    }*/

    @Override
    public List<Forum> findAll() {

        EntityManagerFactory emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        List<Forum> forumList;

        try {
            tx.begin();
            forumList = em.createQuery("SELECT * FROM forum ORDER BY id DESC", Forum.class).getResultList();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            /**
             * 의도치 않은 값을 건내줬을 경우
             * throw new IllegalArgumentException("");
             * 
             * 의도치 않은 값을 받았을 경우
             * throw new IllegalStateException("");
             */
            throw new IllegalStateException("[forum 테이블 조회 : error]");

        } finally {
            em.close(); emf.close();
        }
        return forumList;
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("mysql");
    }
}
