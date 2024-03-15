package com.example.forum.controller;

import com.example.forum.entity.Forum;
import com.example.forum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ForumController {

    private final ForumService forumService;

    @Autowired
    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    public List<Forum> ForumList() {
        return forumService.ForumList();
    }
}
