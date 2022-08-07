package ru.otus.homework;

import ru.otus.homework.anotation.Log;

public class TestLogging implements TestLoggingInterface{
    @Override
    @Log
    public void calculation(int x) {
        System.out.println(x);
    }

    @Override
    @Log
    public void calculation(int x, int y) {
        System.out.println(x+","+y);

    }

    @Override
    @Log
    public void calculation(int x, int y, String z) {
        System.out.println(x+","+y+","+z);
    }


    public String toString() {
        return "TestLogging{}";
    }
}
