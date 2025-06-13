package org.zerock.tourist_spring.board.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.tourist_spring.board.dto.BoardDTO;
import org.zerock.tourist_spring.board.mapper.BoardMapper;
import org.zerock.tourist_spring.board.vo.BoardVO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> getAll() {
        List<BoardDTO> dtoList = boardMapper.selectAll().stream()
                .map(vo -> BoardDTO.builder()
                        .num(vo.getNum())
                        .title(vo.getTitle())
                        .content(vo.getContent())
                        .id(vo.getId())
                        .postdate(vo.getPostdate())
                        .visitcount(vo.getVisitcount())
                        .build()
                ).collect(Collectors.toList());
        return dtoList;
    }
    @Override
    public BoardDTO getOne(Long num) {
        boardMapper.updateVisitCount(num);
        BoardVO boardVO = boardMapper.selectOne(num);
        BoardDTO dto = BoardDTO.builder()
                .num(boardVO.getNum())
                .title(boardVO.getTitle())
                // 모든 엔터키를 <br/> 태그로 변경
                .content(boardVO.getContent().replaceAll("(\r\n|\r|\n)","<br/>"))
                .id(boardVO.getId())
                .postdate(boardVO.getPostdate())
                .visitcount(boardVO.getVisitcount())
                .build();

        return dto;
    }
}
