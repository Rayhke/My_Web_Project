package com.example.forum.service;

import com.example.forum.entity.Forum;
import com.example.forum.repository.ForumRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ForumService {

    private final ForumRepository forumRepository;

    @Autowired
    public ForumService(ForumRepository forumRepository) {
        this.forumRepository = forumRepository;
    }

    public List<Forum> getForumList() {
        return forumRepository.findAll();
    }
}
