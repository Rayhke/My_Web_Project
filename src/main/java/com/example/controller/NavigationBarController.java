package com.example.controller;

import com.example.forum.entity.Forum;
import com.example.forum.repository.ForumJpaRepository;
import com.example.forum.service.ForumService;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Slf4j
@Controller
public class NavigationBarController {

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/forum")
    public String forum(Model model) {
        ForumService test = new ForumService(new ForumJpaRepository());
        List<Forum> list = test.ForumList();
        for (Forum forum : list) {
            System.out.println(forum.toString());
        }
        /*if (list.isEmpty()) {
            model.addAttribute("error", "조회 실패");
        } else {
            model.addAttribute("forumPageList", list);
        }*/
        return "forum";
    }

}
