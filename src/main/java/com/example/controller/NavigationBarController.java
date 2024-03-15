package com.example.controller;

import com.example.forum.controller.ForumDTO;
import groovy.util.logging.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
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
        List<ForumDTO> list = new ArrayList<>();
        // 이것을 DB로 연결하여 가져와야 한다.
        list.add(ForumDTO.builder()
                .id(3L)
                .category("일반")
                .title("비둘기 고꾸라지다!")
                .author("비둘기")
                .build());
        list.add(ForumDTO.builder()
                .id(2L)
                .category("공지")
                .title("아니 글쎄 치킨이 되었어요.")
                .author("닭둘기")
                .build());
        list.add(ForumDTO.builder()
                .id(1L)
                .category("유머")
                .title("고속도로 달리다 연로가 떨어졌어요.")
                .author("봉고차")
                .build());
        model.addAttribute("forumPageList", list);
        return "forum";
    }

}
