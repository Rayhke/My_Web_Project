package com.example.forum.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@AllArgsConstructor
@Builder
@Entity
public class Forum extends BaseEntity {

    @Id
    private Long id;
    // private String title;
    private String author;

}
