package com.example.forum.controller;

import lombok.*;

import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ForumDTO {
    @Id
    private Long id;
    private String author;

    /*public Forum toEntity() {
    public Forum toEntity() {
        return Forum.builder()
                .id(id)
                .author(author)
                .build();
    }*/
}
