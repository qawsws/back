package org.zerock.springex2.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageRequestDTO {
    // 아무것도 설정하지 않고 DTO를 만들었을 경우 0이 아닌 1이 설정됨
    @Builder.Default
    @Min(value=1)
    // 정수만 저장할 수 있도록 설정
    @Positive
    private int page = 1;

    // 최소값은 10 최대값은 100으로 설정
    @Builder.Default
    @Min(value=10)
    @Max(value=100)
    private int size = 10;

    private String link;

    public int getSkip(){
        // 1페이지 : 0
        // 2페이지 : 10
        // 3페이지 : 20
        return (page - 1) * 10;
    }
    public String getLink(){
        if(link == null){
            StringBuilder builder = new StringBuilder();
            builder.append("page=" + this.page);
            builder.append("&size=" + this.size);
            link = builder.toString();
        }
        return link;
    }
}
