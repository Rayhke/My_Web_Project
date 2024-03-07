package com.example.forum.controller;

import com.example.forum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/forum")
public class ForumController {

    private final ForumService forumService;

    @Autowired
    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @PostMapping(value = "/plus")
    public ForumDTO createdForum(@RequestBody ForumDTO ForumDTO) {
        return forumService.save(ForumDTO.getId(), ForumDTO.getAuthor());
    }
}
