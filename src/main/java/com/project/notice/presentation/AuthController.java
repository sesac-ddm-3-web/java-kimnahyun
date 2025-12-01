package com.project.notice.presentation;

import com.project.notice.application.LoginService;
import com.project.notice.application.MemberService;
import com.project.notice.domain.Member;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final LoginService loginService;
    private final MemberService memberService;

    public AuthController(LoginService loginService, MemberService memberService) {
        this.loginService = loginService;
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String loginForm() {

        return "auth/login";
    }

    @PostMapping("/login")
    public String login(
            @RequestParam String username,
            @RequestParam String password,
            HttpSession session,
            Model model
    ) {
        Member member = loginService.login(username, password);

        if (member == null) {
            model.addAttribute("error", "NO_USER_OR_PASSWORD");
            return "auth/login";
        }

        session.setAttribute("loginMember", member);
        return "redirect:/posts";
    }

    @GetMapping("/signup")
    public String signupForm() {
        return "auth/signup";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username,
                         @RequestParam String password,
                         Model model) {

        boolean success = memberService.signup(username, password);

        if (!success) {
            model.addAttribute("error", "DUP_USERNAME");
            return "auth/signup";
        }

        return "redirect:/auth/login";
    }
}