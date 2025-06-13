package org.zerock.tourist_spring.board.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class BoardDTO {
    private int num;
    private String title;
    private String content;
    private String id;
    private String postdate;
    private int visitcount;
}
