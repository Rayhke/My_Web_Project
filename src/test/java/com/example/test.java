package com.example;

import com.example.forum.entity.BaseEntity;
import com.example.forum.entity.Forum;
import com.example.user.dto.UserDTO;
import com.example.user.entity.Member;
import com.example.user.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class test {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("mysql");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            /*UserDTO userDTO = new UserDTO(
                    "nink2458",
                    "asd123",
                    "비둘기",
                    "010-1234-5678",
                    "nink2458@aaa.com");
            User user = userDTO.userEntity();
            Member member = userDTO.memberEntity();*/

            /*Forum forum = Forum.builder()
                    .id(1L)
                    .author("이동현")
                    .build();*/

            // em.persist(user);
            // em.persist(member);
            // em.persist(forum);
            tx.commit();
        } catch(Exception e) {
            tx.rollback();
            throw new IllegalStateException(e);
        } finally {
            em.close();
        }
        emf.close();
    }
}
