package com.example.forum.entity;

import lombok.Getter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;

import javax.persistence.MappedSuperclass;
import java.sql.Timestamp;

/**
 * @@EntityListeners : Entity 의 변화를 감지하여 Entity 와 매핑된 테이블의 데이터 조작
 * @AuditingEntityListener.class : Entity 의 영속, 수정 이벤트 감지 역할 수행
 * @@MappedSuperclass : 상속용 Entity 객체이며, 별도로 테이블을 만들지 않도록 한다. (즉, 부모의 기능만 이용)
 */
@Getter
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseEntity {

    @CreationTimestamp
    @Column(updatable = false)  // 최초 생성일 고정
    private Timestamp createdAt;

    @UpdateTimestamp
    private Timestamp updatedAt;

}
