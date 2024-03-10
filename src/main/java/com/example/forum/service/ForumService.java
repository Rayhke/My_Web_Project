package com.example.forum.service;

import com.example.forum.controller.ForumDTO;
import com.example.forum.entity.Forum;

import java.util.Optional;

public interface ForumService {

    ForumDTO save(Long id, String author);

    ForumDTO update(Long id, String author);

    Optional<Forum> findById(Long id);

}
