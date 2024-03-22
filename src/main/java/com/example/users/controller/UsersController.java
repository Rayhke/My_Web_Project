package com.example.users.controller;

import com.example.users.controller.dto.LoginDTO;
import com.example.users.controller.dto.UsersDTO;
import com.example.users.entity.Member;
import com.example.users.service.UsersService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class UsersController {

    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO,
                        HttpServletRequest request) {
        Member result = usersService.findById(loginDTO.getUserId());
        if (result.getId().equals(loginDTO.getUserId())) {
            if (result.getPwd().equals(loginDTO.getUserPwd())) {
                HttpSession session = request.getSession();
                session.setAttribute("loginUser", result.getNickname());
                session.setMaxInactiveInterval(60 * 30);
            } else {

            }
        }
        return "/";
    }

    @GetMapping("/member")
    public String member() {
        return "member";
    }

    @PostMapping("/member")
    public String save(@ModelAttribute UsersDTO usersDTO) {
        // usersService.save(userDTO);
        return "users/ok";
    }
}