package org.zerock.tourist_spring.board.mapper;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.zerock.tourist_spring.board.vo.BoardVO;

@Log4j2
@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations="file:src/main/webapp/WEB-INF/root-context.xml")
public class BoardMapperTest {
    @Autowired(required = false)
    private BoardMapper boardMapper;

    @Test
    public void testSelectAll(){
        log.info(boardMapper.selectAll());
    }
    @Test
    public void testInsert(){
        BoardVO boardVO = BoardVO.builder()
                .title("PK 반환 테스트")
                .content("PK의 값이 설정되는지")
                .id("hong")
                .build();
        boardMapper.insertBoard(boardVO);
        log.info(boardVO);
    }
}
