package org.zerock.tourist_spring.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.zerock.tourist_spring.board.dto.BoardDTO;
import org.zerock.tourist_spring.board.service.BoardService;


@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model model) {
        log.info("list");
        model.addAttribute("dtoList", boardService.getAll());
        return "list";
    }
    @GetMapping("/read")
    public String read(Long num, Model model) {
        model.addAttribute("dto", boardService.getOne(num));
        return "view";
    }

    @GetMapping("/write")
    public String writeGet() {
        return "board/write";
    }

}
