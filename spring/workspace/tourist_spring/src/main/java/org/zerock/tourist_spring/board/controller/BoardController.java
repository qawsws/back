package org.zerock.tourist_spring.board.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.logging.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.tourist_spring.board.dto.BoardDTO;
import org.zerock.tourist_spring.board.mapper.BoardMapper;
import org.zerock.tourist_spring.board.service.BoardService;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;
    @GetMapping("/list")
    public String getBoardList(Model model){
        model.addAttribute("boardLists", boardService.findAll());
        return "list";
    }
    @GetMapping({"/read", })
    public String read(int num, Model model){
        model.addAttribute("dto", boardService.findOne(num));
        return "read";
    }
    @GetMapping({ "/edit"})
    public String edit(int num, Model model){
        model.addAttribute("dto", boardService.findOne(num));
        return "edit";
    }
    @RequestMapping(value="/edit", method= RequestMethod.POST)
    public String editPost(BoardDTO boardDTO,
                           RedirectAttributes redirectAttributes) {

        log.info("editPost");
        if (boardDTO.getTitle().length() > 0 && boardDTO.getContent() != null) {
            String result = boardService.editBoard(boardDTO);
            redirectAttributes.addFlashAttribute("msg", result);
            redirectAttributes.addAttribute("num", boardDTO.getNum());
            return "redirect:/board/read";
        } else {
            redirectAttributes.addFlashAttribute("msg", "수정에 실패했습니다.");
            redirectAttributes.addAttribute("num", boardDTO.getNum());
            return "redirect:/board/list?errorMsg=error";
        }
    }
        @PostMapping("/remove")
        public String remove (int num) {
            BoardDTO dto = boardService.findOne(num);
            if (dto != null) {
                boardService.removeBoard(num);
                return "redirect:/board/list";
            } else {
                return "redirect:/board/list?errorMsg=error";
            }
        }
    }


