package ru.otus.homework.reflection;

import ru.otus.homework.annotations.After;
import ru.otus.homework.annotations.Before;
import ru.otus.homework.annotations.Test;

public class TestClass {

    @Test
    void test1() {
        System.out.println("Первый тест");
    }

    @Test
    void test2() {
        throw new NullPointerException("Упал");
    }
    @Test
    void test3() {
        System.out.println("Третий тест");
    }
    @Before
    void before() {System.out.println("before");}
    @After
    void after() {System.out.println("after");}
}
