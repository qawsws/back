package org.zerock.tourist_spring.board.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.zerock.tourist_spring.board.dto.BoardDTO;
import org.zerock.tourist_spring.board.mapper.BoardMapper;
import org.zerock.tourist_spring.board.vo.BoardVO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    @Override
    public List<BoardDTO> findAll() {
        List<BoardDTO> dtoList = boardMapper.selectAll().stream()
                .map(vo -> BoardDTO.builder()
                        .num(vo.getNum())
                        .title(vo.getTitle())
                        .content(vo.getContent())
                        .id(vo.getId())
                        .postdate(vo.getPostdate())
                        .visitcount(vo.getVisitcount())
                        .build()
                )
                .collect(Collectors.toList());
        return dtoList;
    }

    public BoardDTO findOne(int num) {
        // 조회수 증가 SQL실행
        boardMapper.updateVisitCount(num);
        // num을 기준으로 데이터를 저장
        BoardVO vo = boardMapper.selectOne(num);
        // 화면에서 사용하는 객체인 DTO로 변경
        BoardDTO dto = BoardDTO.builder()
                .num(vo.getNum())
                .title(vo.getTitle())
                // 모든 엔터키를 <br/> 태그로 변경
                .content(vo.getContent().replaceAll("(\r\n|\r|\n)", "<br/>"))
                .id(vo.getId())
                .postdate(vo.getPostdate())
                .visitcount(vo.getVisitcount())
                .build();
        return dto;
    }

    @Override
    public void removeBoard(int num) {
        boardMapper.deleteBoard(num);
    }

    @Override
    public String editBoard(BoardDTO boardDTO) {
        BoardVO vo = boardMapper.selectOne(boardDTO.getNum());
        if (vo != null) {
            vo.changeBoard(boardDTO.getTitle(),
                    boardDTO.getContent());
            boardMapper.updateBoard(vo);
            return "수정했습니다.";
        } else {
            return "수정 처리중에 예외가 발생했습니다.";
        }
    }
}