package com.example.forum.controller;

import lombok.*;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@ToString
@Builder
public class ForumDTO {
    @Id
    private Long id;
    private String author;

    @Builder
    public ForumDTO(Long id, String author) {
        this.id = id;
        this.author = author;
    }
    /*public Forum toEntity() {
    public Forum toEntity() {
        return Forum.builder()
                .id(id)
                .author(author)
                .build();
    }*/
}
