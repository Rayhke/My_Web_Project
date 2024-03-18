package com.example.forum.repository;

import com.example.forum.controller.ForumSearchDTO;
import com.example.forum.entity.Page;

import java.util.List;

public interface ForumRepository {

    Page save(Page page);

    Page findById(Long id);

    List<Page> findAll();

    Page update(Page page);

    Long deleteById(Long id);

    List<Page> findByTitleOrAuthor(ForumSearchDTO searchDTO);

    // List<Forum> findByValue(ForumSearchDTO searchDTO);
}