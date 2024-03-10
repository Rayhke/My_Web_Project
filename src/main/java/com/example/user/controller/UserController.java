<<<<<<< HEAD
/*
=======
>>>>>>> 2788a79b835efcc00a4616021485da918b740814
package com.example.user.controller;

import com.example.user.dto.LoginDTO;
import com.example.user.dto.UserDTO;
import com.example.user.entity.Member;
import com.example.user.service.UsersService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class UserController {

    @Autowired
    private final UsersService usersService;

    @PostMapping("/login")
    public String login(@ModelAttribute LoginDTO loginDTO, HttpServletRequest request) {
        Member result = usersService.findId(loginDTO.getUserId());
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
    public String save(@ModelAttribute UserDTO userDTO) {
        usersService.save(userDTO);
        return "users/ok";
    }

}
<<<<<<< HEAD
*/
=======
>>>>>>> 2788a79b835efcc00a4616021485da918b740814
