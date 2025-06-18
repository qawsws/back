package org.zerock.tourist_spring.board.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.tourist_spring.board.dto.BoardDTO;
import org.zerock.tourist_spring.board.mapper.BoardMapper;
import org.zerock.tourist_spring.board.service.BoardService;
import org.zerock.tourist_spring.common.dto.PageRequestDTO;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
//    @GetMapping("/list")
//    public String getBoardList(Model model){
//        model.addAttribute("boardLists", boardService.findAll());
//        return "list";
//    }
    @GetMapping("/list")
    public String getBoardList(@Valid PageRequestDTO pageRequestDTO,
                               BindingResult bindingResult,
                               Model model){
        if(bindingResult.hasErrors()){
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", boardService.findList(pageRequestDTO));
        return "list";
    }
    @GetMapping("/read")
    public String getBoardRead(int num, Model model, PageRequestDTO pageRequestDTO){
        model.addAttribute("dto", boardService.findOne(num));
        return "read";
    }
    @GetMapping("/edit")
    public String getBoardEdit(int num, Model model, PageRequestDTO pageRequestDTO){
        model.addAttribute("dto", boardService.findOneEdit(num));
        return "edit";
    }
    @PostMapping("/edit")
    public String editBoard(BoardDTO boardDTO, PageRequestDTO pageRequestDTO,
                            RedirectAttributes redirectAttributes,
                            HttpSession session){
        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
        if(session.getAttribute("UserId") != null){
            String userId = session.getAttribute("UserId").toString();
            // 게시글의 ID와 로그인한 ID가 같은지 확인
            if(boardDTO.getId().equals(userId)){
                boardService.editBoard(boardDTO);
                redirectAttributes.addFlashAttribute("msg", "수정했습니다.");
                return "redirect:/board/read?num="+boardDTO.getNum();
            }else{
                redirectAttributes.addFlashAttribute("msg", "게시글 수정할 권한이 없습니다.");
                return "redirect:/board/list";
            }
        }
        redirectAttributes.addFlashAttribute("msg", "로그인 해주세요.");
        return "redirect:/board/list";
    }
    @PostMapping("/remove")
    public String postBoardRemove(int num, PageRequestDTO pageRequestDTO,
                                  HttpSession session,
                                  RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
        // 로그인한 계정의 ID 저장
        String userId = session.getAttribute("UserId").toString();
        // 게시글 정보 저장
        BoardDTO boardDTO = boardService.findOneEdit(num);
        // 게시글 작성자와 로그인 ID를 비교
        if(boardDTO.getId().equals(userId)){
            // ID와 작성자가 일치할 경우 게시글을 삭제하고
            boardService.removeBoard(num);
            // list화면을 출력
            return "redirect:/board/list";
        }else{
            // 로그인ID와 게시글 작성자가 일치하지 않으면 상세보기 화면을 출력
            redirectAttributes.addAttribute("num",num);
            return "redirect:/board/read";
        }
    }
    @GetMapping("/write")
    public String getWrite(HttpSession session, RedirectAttributes redirectAttributes){
        if(session.getAttribute("UserId") == null){
            redirectAttributes.addFlashAttribute("msg","로그인 해주세요");
            return "redirect:/board/list";
        }
        return "write";
    }
    @PostMapping("/write")
    public String postWrite(BoardDTO boardDTO, HttpSession session, RedirectAttributes redirectAttributes){
        Object id = session.getAttribute("UserId");
        if(id == null){
            redirectAttributes.addFlashAttribute("msg","로그인 해주세요");
            return "redirect:/board/list";
        }
        boardDTO.setId(id.toString());
        int num = boardService.addBoard(boardDTO);
        return "redirect:/board/read?num="+num;
    }
}
