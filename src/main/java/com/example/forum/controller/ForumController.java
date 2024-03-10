package com.example.forum.controller;

import com.example.forum.service.impl.ForumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/forum")
public class ForumController {

    private final ForumServiceImpl forumService;

    @Autowired
    public ForumController(ForumServiceImpl forumService) {
        this.forumService = forumService;
    }

    @PostMapping(value = "/plus")
    public ForumDTO createdForum(@RequestBody ForumDTO forumDTO) {
        return forumService.save(forumDTO.getId(), forumDTO.getAuthor());
    }
}