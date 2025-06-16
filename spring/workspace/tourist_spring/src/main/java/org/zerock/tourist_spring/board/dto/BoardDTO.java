package org.zerock.tourist_spring.board.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardDTO {
    private int num;
    private String title;
    private String content;
    private String id;
    private LocalDate postdate;
    private int visitcount;
}

