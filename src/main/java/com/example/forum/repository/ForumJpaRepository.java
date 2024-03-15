package com.example.forum.repository;

import com.example.forum.entity.Forum;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

@Repository
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

        List<Forum> forumList = null;

        try {
            tx.begin();
            forumList = em.createQuery("SELECT * FROM forum ORDER BY id DESC", Forum.class).getResultList();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new IllegalArgumentException("");
        } finally {
            em.close(); emf.close();
        }
        return forumList;
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("mysql");
    }
}
