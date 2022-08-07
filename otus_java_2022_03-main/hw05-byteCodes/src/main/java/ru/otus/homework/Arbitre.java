package ru.otus.homework;


import ru.otus.homework.anotation.Log;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Arrays;

class Arbitre {

    private Arbitre() {
    }

    static TestLoggingInterface createMyClass() {
        InvocationHandler handler = new DemoInvocationHandler(new TestLogging());
        return (TestLoggingInterface) Proxy.newProxyInstance(Arbitre.class.getClassLoader(),
                new Class<?>[]{TestLoggingInterface.class}, handler);
    }

    static class DemoInvocationHandler implements InvocationHandler {
        private final TestLoggingInterface myClass;
        ArrayList<Method> method = new ArrayList<>();
        DemoInvocationHandler(TestLoggingInterface myClass) {
            this.myClass = myClass;
            for (Method logmethod: myClass.getClass().getDeclaredMethods())
             {
                if(logmethod.isAnnotationPresent(Log.class))
                    method.add(logmethod);
            }
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            System.out.println("invoking method:" + method);
            return method.invoke(myClass, args);
        }

        @Override
        public String toString() {
            return "DemoInvocationHandler{" +
                    "myClass=" + myClass +
                    '}';
        }
    }
}
