package com.example.forum.repository;

import com.example.forum.controller.dto.SearchDTO;
import com.example.forum.entity.Page;

import java.util.List;

public interface ForumRepository {

    Page save(Page page);

    Page findById(Long id);

    List<Page> findAll();

    Page update(Page page);

    Long deleteById(Long id);

    List<Page> findByTitleOrAuthor(SearchDTO searchDTO);
}