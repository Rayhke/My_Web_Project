package com.example.forum.service;

import com.example.forum.controller.ForumDTO;
import com.example.forum.entity.Forum;
import com.example.forum.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

public interface ForumService {
    /*private final ForumRepository forumRepository;

    @Autowired
    public ForumService(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public ForumDTO save(Long id, String author) {
        return null;
    }*/

    ForumDTO save(Long id, String author);

    ForumDTO update(Long id, String author);
}
