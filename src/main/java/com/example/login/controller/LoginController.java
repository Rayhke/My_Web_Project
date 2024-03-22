package com.example.login.controller;

import com.example.login.controller.dto.LoginDTO;
import com.example.login.service.LoginService;
import com.example.users.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @Autowired
    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/")
    public String login(@ModelAttribute LoginDTO loginDTO,
                        HttpServletRequest request) {
        Member result = login(loginDTO.getId());

        return "";
    }

    /**
     * @param id Users ID
     * @return 동일한 계정 아이디 엔티티 반환
     */
    public Member login(String id) {
        return loginService.login(id);
    }
}
