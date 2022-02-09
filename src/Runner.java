import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class Runner {

    public static void start(String testClassName) {
        try {
            Class testClass = Class.forName(testClassName);
            start(testClass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void start(Class testClass){
    Method[] methods = testClass.getDeclaredMethods();
    ArrayList<Method> tests = new ArrayList<>();
    Method beforeSuite = null;
    Method afterSuite = null;

    for (Method o : methods) {
        if(o.getAnnotation(Test.class) != null) {
            tests.add(o);
        } else if(o.getAnnotation(BeforeSuite.class) != null){
            if (beforeSuite!=null){throw new RuntimeException("Несколко методов с аннотацией @BeforeSuite");}
            beforeSuite=o;
        } else if(o.getAnnotation(AfterSuite.class) != null){
            if (afterSuite!=null){throw new RuntimeException("Несколко методов с аннотацией @AfterSuite");}
            afterSuite=o;
        }
    }

    Collections.sort(tests, new Comparator<Method>() {
        @Override
        public int compare(Method o1, Method o2) {
            return o1.getAnnotation(Test.class).priority() - o2.getAnnotation(Test.class).priority();
        }
    });

        try {
            Object testClassInstance = testClass.newInstance();
            if (beforeSuite!=null){
            beforeSuite.invoke(testClassInstance);
            }
            for (Method m:tests){m.invoke(testClassInstance);}
            if (afterSuite!=null){
                afterSuite.invoke(testClassInstance);
            }
        } catch (IllegalAccessException|InvocationTargetException|InstantiationException e) {
            e.printStackTrace();
        }


    }

}
