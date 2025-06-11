package org.zerock.springex.controller;


import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zerock.springex.dto.TodoDTO;

@Controller
@Log4j2
// 클래스에 작성한 RequestMapping은 매서드를 부를 주소를 작성기전 적어야하는 주소
@RequestMapping("/todo")
public class TodoController {
    // 주소 : http://localhost:8801/todo/list
    @GetMapping("/list")
    public String list(){
        log.info("list");
        return "list";
    }
    // 주소 : http://localhost:8081/todo/register
    @GetMapping("/register")
    public String register(){
        log.info("register");
        return "register";
    }
    @PostMapping("/register")
    public String registerPost(TodoDTO todoDTO){
        log.info("register post");
        log.info(todoDTO);
        return "redirect:/hello";
    }
    // GetMapping과 같은 방식
    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit(){
        log.info("edit");
        return "edit";
    }
    // PostMapping과 같은 방식
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editPost(){
        log.info("editPost");
        return "redirect:/hello";
    }

}
