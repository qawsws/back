package org.zerock.testproject;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class QuizControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

//    JSON : 웹에서 통신에 사용하는 데이터 형식
//            [ ] : 배열, 여러가지 데이터를 넣을때 사용
//    { } : 객체, key:value로 이루어진 데이터
// [
//    {"id":"1", "name":"홍길동"},
//    {"id":"2", "name":"이순신"},
//    {"id":"3", "name":"남가람"}
// ]

    @DisplayName("quiz() : GET /quiz?code=1 " +
            "이면 응답 코드는 201 응답 본문은 Created!를 리턴한다")
    @Test
    public void getQuiz1() throws Exception{
        // uri : controller에서 실행할 주소 설정
        String uri = "/quiz";
        // Controller를 실행하기 위한 코드
        // perform(get방식(주소).param(파라미터키, 파라미터값))
        ResultActions result = mockMvc.perform(get(uri).param("code","1"));
        // Controller의 실행결과 저장되는 result
        // 응답 결과의 status가 201이고 돌려준 문장이 Created!이면 성공
        result.andExpect(status().isCreated())
                .andExpect(content().string("Created!"));
    }
    @DisplayName("quiz() : GET /quiz?code=2 이면 응답 코드는 " +
            "400 응답 본문은 Bad Request!를 리턴한다")
    @Test
    public void getQuiz2() throws Exception{
        String uri = "/quiz";
        ResultActions result = mockMvc.perform(get(uri).param("code","2"));
        result.andExpect(status().isBadRequest())
                .andExpect(content().string("Bad Request!"));
    }
    @DisplayName("/quiz() : POST /quiz에 요청 본문이 {\"value\":1} " +
            "이명 응답코드는 403, 응답 본문은 Forbidden!를 리턴한다.")
    @Test
    public void postQuiz1() throws Exception{
        String uri = "/quiz";
        ResultActions result = mockMvc.perform(post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new Code(1))));
        result.andExpect(status().isForbidden())
                        .andExpect(content().string("Forbidden!"));
    }
    @DisplayName("quiz(): POST /quiz에 요청 본문이 {\"value\":13} 이면" +
            "응답 코드는 200, 응답 본문은 OK!를 리턴한다.")
    @Test
    public void postQuiz2() throws Exception{
        String uri = "/quiz";
        ResultActions result = mockMvc.perform(post(uri)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(new Code(13))));
        result.andExpect(status().isOk())
                .andExpect(content().string("OK!"));
    }
}