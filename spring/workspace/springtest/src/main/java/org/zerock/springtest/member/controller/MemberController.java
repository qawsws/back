package org.zerock.springtest.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.springtest.member.dto.MemberDTO;
import org.zerock.springtest.member.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/join")
    public String joinGet() {
        return "todo/join";
    }
    @PostMapping("/join")
    public String joinPost(MemberDTO memberDTO) {
        memberService.addMember(memberDTO);
        return "redirect:/member/login";
    }

    @GetMapping("/login")
    public String loginGet() {
        return "todo/login";
    }

    @PostMapping("/login")
    public String loginPost(String id, String pw, HttpSession session,
                            RedirectAttributes redirectAttributes) {
        MemberDTO dto = memberService.getMember(id, pw);
        if (dto != null && dto.getId() != null) {
            session.setAttribute("UserId", dto.getId());
            session.setAttribute("userDTO", dto);
            return "redirect:/todo/list";
        } else {
            redirectAttributes.addFlashAttribute("Msg", "아이디나 비밀번호를 확인해주세요");
            return "redirect:/member/login";
        }
    }
    @GetMapping("/logout")
    public String logoutGet(HttpSession session,
                            HttpServletRequest req,
                            HttpServletResponse resp){
        session.removeAttribute("UserId");
        session.removeAttribute("userDTO");

        session.invalidate();
        return "redirect:/member/login";
    }
    @PostMapping("/remove")
    public String removeMember(HttpSession session) {
        String userId = (String) session.getAttribute("UserId");
        if (userId!=null) {
            memberService.removeMember(userId);
            session.invalidate();
        }
        return "redirect:/member/login";
    }

}


