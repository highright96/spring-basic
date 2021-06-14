package dev.highright96.junit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class Lifecycle {
    public Lifecycle() {
        System.out.println("Lifecycle 생성");
    }

//    @BeforeEach
//    void setUp(){
//        System.out.println("BeforeEach");
//    }

    @BeforeAll
    static void beforeAll(){
        System.out.println("BeforeAll");
    }

    @Test
    void test1(){
        System.out.println("Test1");
    }

    @Test
    void test2(){
        System.out.println("Test2");
    }

//    @AfterEach
//    void tearDown(){
//        System.out.println("AfterEach");
//    }

    @AfterAll
    static void afterAll(){
        System.out.println("AfterAll");
    }
}
