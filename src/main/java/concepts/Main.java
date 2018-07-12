package concepts;

import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InterruptedException {
        TestClass testClass = new TestClass();
        testClass.function();
        testClass.printValue();
        Class classRef = testClass.getClass();

        Constructor constructor = classRef.getConstructor();

        System.out.println(constructor.getName());

        Method[] methods = classRef.getMethods();

        for(Method method : methods) {
            System.out.println(method.getName());
        }

        Method method1 = classRef.getDeclaredMethod("function", int.class);
        method1.invoke(testClass, 20);

        WeakReference<String> str = new WeakReference<String>(new String("abc"));
        Thread.sleep(90000);
        System.out.println("Weak " + str.get());

        int[] array = new int[] {1, 5, 3};
        Arrays.sort(array);


    }

    public Interface1 test = new Interface1() {
        @Override
        public void function() {
            System.out.println("abc");
        }
    };
}
