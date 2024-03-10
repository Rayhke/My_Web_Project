<<<<<<< HEAD
/*
package com.example.forum.controller;

import com.example.forum.service.impl.ForumServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
=======
package com.example.forum.controller;

import com.example.forum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
>>>>>>> 2788a79b835efcc00a4616021485da918b740814

@RestController
@RequestMapping("/forum")
public class ForumController {

<<<<<<< HEAD
    private final ForumServiceImpl forumService;

    @Autowired
    public ForumController(ForumServiceImpl forumService) {
=======
    private final ForumService forumService;

    @Autowired
    public ForumController(ForumService forumService) {
>>>>>>> 2788a79b835efcc00a4616021485da918b740814
        this.forumService = forumService;
    }

    @PostMapping(value = "/plus")
    public ForumDTO createdForum(@RequestBody ForumDTO ForumDTO) {
        return forumService.save(ForumDTO.getId(), ForumDTO.getAuthor());
    }
}
<<<<<<< HEAD
*/
=======
>>>>>>> 2788a79b835efcc00a4616021485da918b740814
