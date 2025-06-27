package org.zerock.tourist_springboot.common.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Arrays;

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
    // page, size데이터를 출력
    private String link;
    // 제목,내용,작성자
    private String types="";
    // 검색어
    private String keyword;
    // 완료여부
    private boolean finished;
    // 검색 시작날짜
    private LocalDate from;
    // 검색 종료날짜
    private LocalDate to;

    public String[] getTypeArr(){
        if(types==null && types.isEmpty()){
            return null;
        }
        return types.split(",");
    }

    public int getSkip(){
        // 1페이지 : 0
        // 2페이지 : 10
        // 3페이지 : 20
        return (page - 1) * 10;
    }

    public String getLink(){
        StringBuilder builder = new StringBuilder();
        builder.append("page=" + this.page);
        builder.append("&size=" + this.size);
        if(finished){
            // checkbox 타입은 on으로 저장
            builder.append("&finished=on");
        }
        if(types != null && getTypeArr().length>0){
            // 제목, 작성자 두개다 설정되어 있다면 반복문을 이용하여 두개 모두 파라미터로 설정
            builder.append("&types="+types);
        }
        if(keyword != null){
            try{
                // 한글이 깨지지 않도록 URLEncoder를 사용
                builder.append("&keyword="+ URLEncoder.encode(keyword,"UTF-8"));
            }catch(UnsupportedEncodingException e){
                e.printStackTrace();
            }
        }
        if(from != null){
            builder.append("&from="+from.toString());
        }
        if(to != null){
            builder.append("&to="+to.toString());
        }
        link = builder.toString();
        return link;
    }
}