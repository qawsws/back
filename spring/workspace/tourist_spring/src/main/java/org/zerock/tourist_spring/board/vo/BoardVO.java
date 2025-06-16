package org.zerock.tourist_spring.board.vo;

import lombok.*;

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
    public void changeBoard(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
