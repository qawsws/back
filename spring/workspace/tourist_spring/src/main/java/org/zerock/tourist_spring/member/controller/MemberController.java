package org.zerock.tourist_spring.member.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.tourist_spring.member.dto.MemberDTO;
import org.zerock.tourist_spring.member.service.MemberService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;
    @GetMapping("/join")
    public String joinGet(){
        return "join";
    }
    @PostMapping("/join")
    public String joinPost(MemberDTO memberDTO){
        memberService.addMember(memberDTO);
        return "redirect:/";
    }
    @GetMapping("/login")
    public String loginGet(){
        return "login";
    }
    @PostMapping("/login")
    public String loginPost(String id, String pw,
                            HttpSession session,
                            RedirectAttributes redirectAttributes){
        // 계정과 일치하는 데이터를 저장
        MemberDTO dto = memberService.getMember(id, pw);
        if(dto != null && dto.getId() != null) {
            // id와pw가 일치할 경우 session에 UserId를 저장
            session.setAttribute("UserId", dto.getId());
            session.setAttribute("userDTO", dto);
            return "redirect:/";
        }else{
            redirectAttributes.addFlashAttribute("loginErrMsg"
                    , "아이디나 비밀번호를 확인해주세요");
            return "redirect:/member/login";
        }
    }
    @GetMapping("/logout")
    public String logoutGet(HttpSession session,
                            HttpServletRequest req,
                            HttpServletResponse resp){
        // session에 데이터를 각각 삭제하는 경우
        session.removeAttribute("UserId");
        session.removeAttribute("userDTO");
        // session에 데이터를 모두 삭제하는 경우
        session.invalidate();
        return "redirect:/";
    }
}
