package com.example.forum.controller;

import com.example.forum.entity.Page;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageDTO {

    private Long id;

    private String title;

    private String author;

    private String category;

    private String main_text;

    public Page Join() {
        return new Page().builder()
                .id(id)
                .title(title)
                .author(author)
                .category(category)
                .main_text(main_text)
                .build();
    }
}
