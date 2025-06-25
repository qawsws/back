package org.zerock.tourist_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

// 생성일, 수정일을 자동으로 처리하기 위한 어노테이션
@EnableJpaAuditing
@SpringBootApplication
public class TouristSpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(TouristSpringbootApplication.class, args);
    }

}
