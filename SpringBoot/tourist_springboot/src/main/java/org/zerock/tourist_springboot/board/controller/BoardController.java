package org.zerock.tourist_springboot.board.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.tourist_springboot.board.dto.BoardDTO;
import org.zerock.tourist_springboot.board.service.BoardService;
import org.zerock.tourist_springboot.common.dto.PageRequestDTO;
import org.zerock.tourist_springboot.common.dto.PageResponseDTO;

import java.util.ArrayList;
import java.util.List;

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
        model.addAttribute("responseDTO", boardService.findList(pageRequestDTO));
        return "board/list";
    }
    @GetMapping("/read")
    public String getBoardRead(Long num, Model model, PageRequestDTO pageRequestDTO){
        model.addAttribute("dto", boardService.findOne(num));
        return "board/read";
    }
    @GetMapping("/edit")
    public String getBoardEdit(Long num, Model model, PageRequestDTO pageRequestDTO){
        model.addAttribute("dto", boardService.findOneEdit(num));
        return "edit";
    }
}
