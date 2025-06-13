package org.zerock.tourist_spring.board.vo;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class BoardVO {
    private int num;
    private String title;
    private String content;
    private String id;
    private String postdate;
    private int visitcount;
    public void changeBoard(String title, String content, String id, String postdate, int visitcount) {
        this.title = title;
        this.content = content;
        this.id = id;
        this.postdate = postdate;

    }
}
