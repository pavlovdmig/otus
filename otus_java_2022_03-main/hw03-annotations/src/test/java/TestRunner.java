import ru.otus.homework.annotations.After;
import ru.otus.homework.annotations.Before;
import ru.otus.homework.annotations.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.*;

import static ru.otus.homework.reflection.ReflectionHelper.*;

public class TestRunner {
    private static final String TEST_KEY = "test";
    private static final String BEFORE_KEY = "before";
    private static final String AFTER_KEY = "after";
    public void run(String className) throws ClassNotFoundException {
        var clazz = Class.forName(className);
        var methods = prepareLoad(clazz);
        var test = methods.get(TEST_KEY);
        var before = methods.get(BEFORE_KEY).get(0);
        var after = methods.get(AFTER_KEY).get(0);
        int passed = 0;
        int failed = 0;
        int count = test.size();

        for(Method method : test)
        {
            if(runner(clazz,method,before,after))
            {
                passed++;
            }
            else
                failed++;
        }
        System.out.println("Успешно: " + passed);
        System.out.println("Свалилось: " + failed);
        System.out.println("Всего: " + count);
    }

    private Map<String, List<Method>> prepareLoad(Class<?> clazz) {

        Map<String, List<Method>> methodList = new HashMap<>();

        List<Method> testMethods = new ArrayList<>();
        List<Method> beforeMethods = new ArrayList<>();
        List<Method> afterMethods = new ArrayList<>();

        methodList.put(TEST_KEY, testMethods);
        methodList.put(BEFORE_KEY, beforeMethods);
        methodList.put(AFTER_KEY, afterMethods);

        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(Test.class))
                testMethods.add(method);
            else if (method.isAnnotationPresent(Before.class))
                beforeMethods.add(method);
            else if (method.isAnnotationPresent(After.class))
                afterMethods.add(method);
        }
        return methodList;
    }
    private boolean runner(Class<?> classTest, Method test, Method beforeMethod, Method afterMethod) {
        var clazz = instantiate(classTest);
        try {
            callMethod(clazz, beforeMethod);
        }
        catch (Exception exception) {
            return false;
        }
        boolean passed = true;
        try {
            callMethod(clazz, test);
        } catch (Exception exception) {
            passed = false;
        } finally {
            try {
                callMethod(clazz, afterMethod);
            } catch (Exception exception) {
                passed = false;
            }
        }
        return passed;
    }
}