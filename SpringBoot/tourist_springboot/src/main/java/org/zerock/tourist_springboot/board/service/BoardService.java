package org.zerock.tourist_springboot.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.zerock.tourist_springboot.board.domain.Board;
import org.zerock.tourist_springboot.board.dto.BoardDTO;
import org.zerock.tourist_springboot.board.repository.BoardRepository;
import org.zerock.tourist_springboot.common.dto.PageRequestDTO;
import org.zerock.tourist_springboot.common.dto.PageResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    public List<BoardDTO> findAll() {
        List<BoardDTO> dtoList = boardRepository.findAll().stream()
                .map(BoardDTO::new)
                .collect(Collectors.toList());
        return dtoList;
    }

    public PageResponseDTO<BoardDTO> findList(PageRequestDTO pageRequestDTO) {
        int totalCount = boardRepository.findAll().size();
        List<BoardDTO> dtoList = boardRepository.findAll().stream()
                .map(BoardDTO::new)
                .collect(Collectors.toList());
        return PageResponseDTO.<BoardDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalCount)
                .build();
    }
    @Transactional //조회수
    public BoardDTO findOne(Long num){
        // num을 기준으로 데이터를 저장
        Board vo = boardRepository.findById(num).get();
        // 조회수 증가 SQL실행
        vo.updateVisitCount();
        // 화면에서 사용하는 객체인 DTO로 변경
        BoardDTO dto = new BoardDTO(vo);
        return dto;
    }

    public BoardDTO findOneEdit(Long num) {
        Board board = boardRepository.findById(num)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다: " + num));
        return new BoardDTO(board);
    }

//    public void removeBoard(int num){
//        boardMapper.deleteBoard(num);
//    }
//    public void editBoard(BoardDTO boardDTO){
//        BoardVO vo = boardMapper.selectOne(boardDTO.getNum());
//        vo.changeBoard(boardDTO);
//        boardMapper.updateBoard(vo);
//    }
//    public int addBoard(BoardDTO boardDTO){
//        BoardVO vo = BoardVO.builder()
//                .title(boardDTO.getTitle())
//                .content(boardDTO.getContent())
//                .id(boardDTO.getId())
//                .build();
//        // vo안에 자동생성된 primary key인 num이 저장되어있음
//        boardMapper.insertBoard(vo);
//        return vo.getNum();
//    }
}
