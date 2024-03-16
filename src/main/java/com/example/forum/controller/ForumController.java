package com.example.forum.controller;

import com.example.forum.entity.Forum;
import com.example.forum.service.ForumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/forum")
public class ForumController {

    private final ForumService forumService;

    @Autowired
    public ForumController(ForumService forumService) {
        this.forumService = forumService;
    }

    @GetMapping("/")
    public String forum(Model model) {
        List<Forum> list = getForumList();
        for (Forum forum : list) {
            System.out.println(forum.toString());
        }
        if (list.isEmpty()) {
            model.addAttribute("error", "조회 실패");
        } else {
            model.addAttribute("forumPageList", list);
        }
        return "forum";
    }

    @PostMapping("/select")
    public String test(Model model) {
        return "redirect:";
    }

    public List<Forum> getForumList() {
        return forumService.getForumList();
    }
}
