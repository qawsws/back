package org.zerock.tourist_spring.board.mapper;

import org.zerock.tourist_spring.board.vo.BoardVO;

import java.util.List;

public interface BoardMapper {
    List<BoardVO> selectAll();
    BoardVO selectOne(int num);
    void updateVisitCount(int num);
    void deleteBoard(int num);
    void updateBoard(BoardVO boardVO);
}
