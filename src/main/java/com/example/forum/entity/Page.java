package com.example.forum.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "forum_page")
public class Page { // extends BaseEntity

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String author;

    private String category;

    @Column(length = 1001)
    private String main_text;

    public void update(Page other) {
        title = other.getTitle();
        author = other.getAuthor();
        category = other.getCategory();
        main_text = other.getMain_text();
    }

    public boolean allNotNull() {
        return (title == "" || title == null
                || author == "" || author == null
                || category == "" || category == null
                || main_text == "" || main_text == null);
    }
}
