package org.zerock.tourist_springboot.board.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.tourist_springboot.board.dto.BoardDTO;
import org.zerock.tourist_springboot.board.service.BoardService;
import org.zerock.tourist_springboot.common.dto.PageRequestDTO;


@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/list")
    public String getBoardList(@Valid PageRequestDTO pageRequestDTO,
                               BindingResult bindingResult,
                               Model model){
        if(bindingResult.hasErrors()){
            pageRequestDTO = PageRequestDTO.builder().build();
        }
        model.addAttribute("responseDTO", boardService.searchList(pageRequestDTO));
        return "board/list";
    }
    @GetMapping("/read")
    public String getBoardRead(Long num, Model model, PageRequestDTO pageRequestDTO){
        BoardDTO dto = boardService.findOne(num);
        dto.setContent(dto.getContent().replaceAll("(\r\n|\r|\n)","<br/>"));
        model.addAttribute("dto",dto);
        return "board/read";
    }
    @GetMapping("/edit")
    public String getBoardEdit(Long num, Model model, PageRequestDTO pageRequestDTO){
        model.addAttribute("dto", boardService.findOneEdit(num));
        return "board/edit";
    }
    @PostMapping("/edit")
    public String editBoard(BoardDTO boardDTO, PageRequestDTO pageRequestDTO,
                            RedirectAttributes redirectAttributes){
        redirectAttributes.addAttribute("page", pageRequestDTO.getPage());
        redirectAttributes.addAttribute("size", pageRequestDTO.getSize());
        boardService.editBoard(boardDTO);
        redirectAttributes.addFlashAttribute("msg", "수정했습니다.");
        return "redirect:/board/read?num="+boardDTO.getNum();
    }
    @PostMapping("/remove")
    public String removeBoard(Long num,
                              RedirectAttributes redirectAttributes,
                              PageRequestDTO pageReuqestDTO){
        redirectAttributes.addAttribute("page", pageReuqestDTO.getPage());
        redirectAttributes.addAttribute("size", pageReuqestDTO.getSize());
        boardService.removeBoard(num);
        return "redirect:/board/list";
    }
    @GetMapping("/write")
    public String writeBoardGet(PageRequestDTO pageRequestDTO){
        return "board/write";
    }
    @PostMapping("/write")
    public String writeBoardPost(BoardDTO boardDTO){
        Long num = boardService.addBoard(boardDTO);
        return "redirect:/board/read?num="+num;
    }




}
