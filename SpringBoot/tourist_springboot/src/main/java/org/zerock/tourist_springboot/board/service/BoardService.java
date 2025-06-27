package org.zerock.tourist_springboot.board.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
        // 전체 데이터 개수
        int totalCount = boardRepository.findAll().size();
        //Pageable을 이용한 페이징 조건 생성
        Pageable pageable = PageRequest.of(
                pageRequestDTO.getPage()-1 // 페이지 번호, 0페이지부터 시작
                ,pageRequestDTO.getSize() // 페이지 사이즈
                ,Sort.by("num").descending());// 정렬방식
        // 페이징 처리된 findAll의 결과물을 저장
        List<Board> boardList = boardRepository.findAll(pageable).getContent();
        // Board를 BoardDTO로 변경
        List<BoardDTO> dtoList = boardList.stream()
                .map(BoardDTO::new)
                .collect(Collectors.toList());
        // PageResponseDTO를 생성하여 반환
        return PageResponseDTO.<BoardDTO>withAll()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(dtoList)
                .total(totalCount)
                .build();
    }
    public PageResponseDTO<BoardDTO> searchList(PageRequestDTO pageRequestDTO) {
        return boardRepository.searchDsl(pageRequestDTO);
    }

    @Transactional // 조회수 1증가를 위한 트랜잭션
    public BoardDTO findOne(Long num){
        // num을 기준으로 데이터를 저장
        Board vo = boardRepository.findById(num).get();
        // 조회수 증가 SQL실행
        vo.updateVisitCount();
        // 화면에서 사용하는 객체인 DTO로 변경
        BoardDTO dto = new BoardDTO(vo);

        return dto;
    }
    public BoardDTO findOneEdit(Long num){
        Board board = boardRepository.findById(num).get();
        return new BoardDTO(board);
    }

    public void removeBoard(Long num){
        boardRepository.deleteById(num);
    }
    @Transactional
    public void editBoard(BoardDTO boardDTO){
        Board vo = boardRepository.findById(boardDTO.getNum()).get();
        vo.changeBoard(boardDTO);
    }

    public Long addBoard(BoardDTO boardDTO){
        Board vo = boardDTO.toEntity();
        boardRepository.save(vo);
        // INSERT를 실행한 후 AutoIncrement로 생성된 PK를 vo에 저장해줌
        return vo.getNum();
    }
}
