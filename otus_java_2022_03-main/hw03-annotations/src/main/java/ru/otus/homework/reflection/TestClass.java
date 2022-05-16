package ru.otus.homework.reflection;

import ru.otus.homework.annotations.Before;
import ru.otus.homework.annotations.Test;

public class TestClass {

    @Test
    void test1() {
        System.out.println("Первый тест");
    }

    @Test
    void test2() {
        System.out.println("Второй тест");
    }

    @Before
    void before() {System.out.println("before");}
}
