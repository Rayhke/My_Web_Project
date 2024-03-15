package com.example.forum.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Forum extends BaseEntity {

    @Id
    private Long id;
    private String title;
    private String author;
    private String category;

    public void update(Forum other) {
        title = other.getTitle();
        author = other.getAuthor();
        category = other.getCategory();
    }
}
