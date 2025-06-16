package org.zerock.tourist_spring.board.service;

import org.zerock.tourist_spring.board.dto.BoardDTO;
import org.zerock.tourist_spring.board.vo.BoardVO;

import java.util.List;

public interface BoardService {
    List<BoardDTO> findAll();
    BoardDTO findOne(int num);
    void removeBoard(int num);
    String editBoard(BoardDTO boardDTO);
}
