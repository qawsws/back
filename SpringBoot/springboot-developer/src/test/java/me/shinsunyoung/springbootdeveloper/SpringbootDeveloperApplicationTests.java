package me.shinsunyoung.springbootdeveloper;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 생성일, 수정일을 자동으로 처리하기 위한 어노테이션
@EnableJpaAuditing
@SpringBootTest
class SpringbootDeveloperApplicationTests {

    @Test
    void contextLoads() {
    }

}
