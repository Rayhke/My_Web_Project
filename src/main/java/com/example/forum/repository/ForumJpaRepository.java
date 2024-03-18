package com.example.forum.repository;

import com.example.forum.controller.ForumSearchDTO;
import com.example.forum.entity.Page;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * 의도치 않은 값을 건내줬을 경우
 * throw new IllegalArgumentException("");
 *
 * 의도치 않은 값을 받았을 경우
 * throw new IllegalStateException("");
 */
public class ForumJpaRepository implements ForumRepository {

    private final EntityManager em;

    @Autowired
    public ForumJpaRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Page save(Page page) {
        try {
            em.persist(page);
            Page result = findById(page.getId());
            return result;
        } catch(Exception e) {
            throw new IllegalStateException("[삽입 실패] : " + e);
        }
    }

    @Override
    public Page findById(Long id) {
        try {
            Page result = em.find(Page.class, id);
            return result;
        } catch(Exception e) {
            throw new IllegalStateException("[조회 실패] : " + e);
        }
    }

    @Override
    public List<Page> findAll() {
        // JPQL
        // return em.createQuery("SELECT f FROM forum_page f ORDER BY f.id DESC", Forum.class).getResultList();
        return em.createNativeQuery(
                "SELECT * FROM forum_page ORDER BY id DESC",
                Page.class
        ).getResultList();
    }

    @Override
    public Page update(Page page) {
        try {
            Page result = findById(page.getId());
            result.update(page);
            return result;
        } catch(Exception e) {
            throw new IllegalStateException("[수정 실패] : " + e);
        }
    }

    @Override
    public Long deleteById(Long id) {
        try {
            Page result = findById(id);
            em.remove(result);
            return id;
        } catch(Exception e) {
            throw new IllegalStateException("[삭제 실패] : " + e);
        }
    }

    @Override
    public List<Page> findByTitleOrAuthor(ForumSearchDTO searchDTO) {
        String query = "SELECT * FROM forum_page WHERE "
                + searchDTO.getMode()
                + " LIKE '%" + searchDTO.getMainText() + "%'"
                + " ORDER BY id DESC";
        try {
            return em.createNativeQuery(query, Page.class).getResultList();
        } catch(Exception e) {
            throw new IllegalStateException("[검색 실패] : " + e);
        }
    }
}