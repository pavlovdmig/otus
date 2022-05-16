import ru.otus.homework.annotations.After;
import ru.otus.homework.annotations.Before;
import ru.otus.homework.annotations.Test;

import java.lang.reflect.Method;
import java.util.*;

import static ru.otus.homework.reflection.ReflectionHelper.*;

public class TestRunner {
    private static final String TEST_KEY = "test";
    private static final String BEFORE_KEY = "before";
    private static final String AFTER_KEY = "after";

    public void run (String className) throws ClassNotFoundException{



        var clazz = Class.forName(className);
        var test = getAnnotationMethods(clazz , Test.class);
        var before = getAnnotationMethods(clazz , Before.class);
        var alltest = Arrays.asList(clazz.getDeclaredMethods());

        //Object object = instantiate(clazz);
        //callMethod(object,test.get(1));
        System.out.println(alltest);

        var methods = prepareLoad(clazz);





    }

    private Map<String,List<Method>> prepareLoad(Class<?> clazz)
    {
        Map<String,List<Method>> methodList = new HashMap<>();
        List<Method> testMethods = new ArrayList<>();
        methodList.put(TEST_KEY, testMethods);
        methodList.put(BEFORE_KEY, testMethods);
        methodList.put(AFTER_KEY, testMethods);
         for (Method method : clazz.getDeclaredMethods())
         {
             if (method.isAnnotationPresent(Test.class))
                 methodList.put(TEST_KEY, Collections.singletonList(method));
             else if (method.isAnnotationPresent(Before.class))
                 methodList.put(BEFORE_KEY, Collections.singletonList(method));
             else if (method.isAnnotationPresent(After.class))
                 methodList.put(AFTER_KEY, Collections.singletonList(method));
         }
            return methodList;
        }
}