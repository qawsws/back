package org.zerock.tourist_spring.board.vo;

import lombok.*;
import org.zerock.tourist_spring.board.dto.BoardDTO;

import java.time.LocalDate;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardVO {
    private int num;
    private String title;
    private String content;
    private String id;
    private LocalDate postdate;
    private int visitcount;
    public void changeBoard(BoardDTO boardDTO){
        this.title = boardDTO.getTitle();
        this.content = boardDTO.getContent();
    }

}
