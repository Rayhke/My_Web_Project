package com.DB_Test.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class MemberService implements MemberRepository {

    @Override
    public MemberEntity insert(MemberEntity member) {

        EntityManagerFactory emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();     // 시작
            em.persist(member);
            tx.commit();    // 종료
        } catch (Exception e) {
            tx.rollback();
            throw new IllegalStateException("삽입 : " + e);
        } finally {
            close(em, emf);
        }
        return member;
    }

    @Override
    public MemberEntity select(String member_id) {

        EntityManagerFactory emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        MemberEntity member;

        try {
            tx.begin();
            member = em.find(MemberEntity.class, member_id);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new IllegalStateException("조회 : " + e);
        } finally {
            close(em, emf);
        }
        return member;
    }

    @Override
    public MemberEntity update(MemberEntity member) {

        EntityManagerFactory emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        MemberEntity result;

        try {
            tx.begin(); // 트랜잭션 시작
            result = em.find(MemberEntity.class, member.getMember_id());
            result.setPwd(member.getPwd());
            result.setNickname(member.getNickname());
            result.setPhone(member.getPhone());
            result.setEmail(member.getEmail());
            tx.commit(); // 쿼리문 전송
        } catch (Exception e) {
            tx.rollback();
            throw new IllegalStateException("수정 : " + e);
        } finally {
            close(em, emf);
        }
        return result;
    }

    @Override
    public String delete(String member_id) {

        EntityManagerFactory emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        MemberEntity result;

        try {
            tx.begin();
            result = em.find(MemberEntity.class, member_id);
            em.remove(result);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            throw new IllegalStateException("삭제 : " + e);
        } finally {
            close(em, emf);
        }
        return member_id;
    }

    @Override
    public List<MemberEntity> findAll() {

        EntityManagerFactory emf = getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        List<MemberEntity> memberList = null;

        try {
            tx.begin();
            memberList = em.createQuery("SELECT * FROM member ORDER BY member_id ASC", MemberEntity.class).getResultList();
            tx.commit();
        } catch (Exception e) {
            tx.rollback();

        } finally {
            close(em, emf);
        }
        return memberList;
    }

    private EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("mysql");
    }

    private void close(EntityManager em, EntityManagerFactory emf) {
        if (em != null) { em.close(); }
        if (emf != null) { emf.close(); }
    }
}
