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
<<<<<<< HEAD
    private String author;
    
=======
    // private String title;
    private String author;

>>>>>>> 2788a79b835efcc00a4616021485da918b740814
}
