package org.zerock.tourist_spring.board.service;

import org.zerock.tourist_spring.board.dto.BoardDTO;
import org.zerock.tourist_spring.common.dto.PageRequestDTO;
import org.zerock.tourist_spring.common.dto.PageResponseDTO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> findAll();
    PageResponseDTO<BoardDTO> findList(PageRequestDTO pageRequestDTO);
    BoardDTO findOne(int num);
    void removeBoard(int num);
    void editBoard(BoardDTO boardDTO);
    BoardDTO findOneEdit(int num);
}
