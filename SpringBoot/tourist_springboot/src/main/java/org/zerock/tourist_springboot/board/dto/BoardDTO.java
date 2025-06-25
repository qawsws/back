package org.zerock.tourist_springboot.board.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.zerock.tourist_springboot.board.domain.Board;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardDTO {
    private Long num;
    private String title;
    private String content;
    private String id;
    private int visitCount;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    public BoardDTO(Board board){
        this.num = board.getNum();
        this.title = board.getTitle();
        this.content = board.getContent();
        this.id = board.getId();
        this.visitCount = board.getVisitCount();
        this.createdAt = board.getCreatedAt();
        this.updatedAt = board.getUpdatedAt();
    }
}
