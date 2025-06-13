package org.zerock.tourist_spring.board.mapper;

import org.zerock.tourist_spring.board.vo.BoardVO;

import java.util.List;

public interface BoardMapper {
    List<BoardVO> selectAll();
    BoardVO selectOne(Long num);
    void updateVisitCount(Long num);
}
