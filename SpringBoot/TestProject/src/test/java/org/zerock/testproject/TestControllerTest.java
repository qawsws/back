package org.zerock.testproject;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.StatusAggregator;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class TestControllerTest {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
    @Autowired
    private MemberRepository memberRepository;
    @Autowired
    private StatusAggregator statusAggregator;

    @BeforeEach
    public void mockMvcSetUp(){
        this.mockMvc = MockMvcBuilders.
                webAppContextSetup(this.context).
                build();
    }
    @DisplayName("getAllMembers: 아티클 조회에 성공한다.")
    @Test
    public void getAllMembers() throws Exception{
        // Controller에서 실행할 URI설정
        final String url = "/test";
        // id가 1인 데이터가 있으면 수정, 없으면 새롭게 추가
        Member savedMember = memberRepository.save(new Member(1L,"홍길동"));
        // Controller의 /test uri를 실행하는 부분
        // get 방식으로 url=/test을 실행 결과를 JSON로 반환받음
        final ResultActions result = mockMvc.perform(get(url).accept((MediaType.APPLICATION_JSON)));
        // HTTP응답 코드가 200번 정상실행 이면
        result.andExpect(status().isOk())
                //  46번줄에서 저장한 데이터와 올바르게 저장되었는지 확인
                .andExpect(jsonPath("$[0].id").value(savedMember.getId()))
                .andExpect(jsonPath("$[0].name").value(savedMember.getName()));
    }

    @AfterEach
    public void cleanUp(){
        memberRepository.deleteAll();
    }
}