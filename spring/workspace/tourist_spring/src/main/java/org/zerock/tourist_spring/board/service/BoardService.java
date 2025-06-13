package org.zerock.tourist_spring.board.service;

import org.zerock.tourist_spring.board.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> getAll();
    BoardDTO getOne(Long num);
}
