package com.example.forum.controller;

import com.example.forum.entity.Forum;
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

<<<<<<< HEAD
    /*public Forum toEntity() {
=======
    public Forum toEntity() {
>>>>>>> 2788a79b835efcc00a4616021485da918b740814
        return Forum.builder()
                .id(id)
                .author(author)
                .build();
<<<<<<< HEAD
    }*/
=======
    }
>>>>>>> 2788a79b835efcc00a4616021485da918b740814
}
