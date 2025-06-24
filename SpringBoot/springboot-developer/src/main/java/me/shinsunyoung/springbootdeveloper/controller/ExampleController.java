package me.shinsunyoung.springbootdeveloper.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

// 화면을 전달하는 컨트롤러
@Controller
public class ExampleController {
    @GetMapping("/thymeleaf/example")
    public String thymeleafExample(Model model){
        // Person객체를 생성한다
        Person examplePerson = new Person();
        examplePerson.setId(1L);
        examplePerson.setName("홍길동");
        examplePerson.setAge(11);
        examplePerson.setHobbies(List.of("운동", "독서"));
        // 화면에 전달할 데이터를 model에 저장
        model.addAttribute("person", examplePerson);
        model.addAttribute("today", LocalDate.now());
        // 실행할 화면 설정
        // => resources/templates/example.html 파일을 실행함
        return "example";
    }
}
@Setter
@Getter
class Person{
    private Long id;
    private String name;
    private int age;
    private List<String> hobbies;
}
