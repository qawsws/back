package org.zerock.testproject;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class JUnitQuiz {
    //문제1
    @Test
    public void junitTest1(){
        String name1 = "홍길동";
        String name2 = "홍길동";
        String name3 = "홍길은";
        //1 모든 변수가 null이 아닌가 확인하는 코드
        assertThat(name1).isNotNull();
        assertThat(name2).isNotNull();
        assertThat(name3).isNotNull();
        //2 name1과 name2가 같은지 확인
        assertThat(name1).isEqualTo(name2);
        //3 name1과 name3가 다른지 확인
        assertThat(name1).isNotEqualTo(name3);
    }
    @Test
    public void junitTest2(){
        int number1 = 15;
        int number2 = 0;
        int number3 = -5;
        // 1 number1이 양수인지 확인
        assertThat(number1).isPositive();
        // 2 number2은 0인지 확인
        assertThat(number2).isZero();
        // 3 number3은 음수인지 확인
        assertThat(number3).isNegative();
        // 4 number1은 number2 보다 큰지 확인
        assertThat(number1).isGreaterThan(number2);
        // 5 number3은 number2 보다 작은지 확인
        assertThat(number3).isLessThan(number2);
    }
    @Test
    public void junitTest3(){
        System.out.println("This is first test");
    }
    @Test
    public void junitTest4(){
        System.out.println("This is second test");
    }
    @BeforeEach
    public void before(){
        System.out.println("Hello!");
    }
    @AfterAll
    public static void after(){
        System.out.println("Bye!");
    }
}
