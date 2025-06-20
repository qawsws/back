package org.zerock.springtest.todo.service;

import org.zerock.springtest.todo.dto.PageRequestDTO;
import org.zerock.springtest.todo.dto.PageResponseDTO;
import org.zerock.springtest.todo.dto.TodoDTO;

import java.util.List;

// TodoService클래스를 만들기 위한 설계도
public interface TodoService {
    void register(TodoDTO todoDTO);
    List<TodoDTO> getAll();
    TodoDTO getOne(Long tno);
    void removeTodo(Long tno);
    String editTodo(TodoDTO todoDTO);
    PageResponseDTO<TodoDTO> getList(PageRequestDTO pageRequestDTO);
}









