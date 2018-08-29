package cc.wenmin92.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.List;

public class TestReflect {
    public static void main(String[] args) {
        // testField();

        // for (Field field : B.class.getDeclaredFields()) {
        //     if (field.getName().equals("a")) field.setAccessible(true);
        //     System.out.println(field.getName() + " : " + field.isAccessible());
        // }
        System.out.println(Modifier.toString(Modifier.methodModifiers()));

        try {
            Method m1 = TestReflect.class.getDeclaredMethod("m1", int.class);
            Parameter[] parameters = m1.getParameters();
            System.out.println(m1);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    private void m1() { }

    private void m1(int i) {}

    private void noneStaticMethod() {
        B b = new B();
        // b.a = "a";

        Inner inner = new Inner();
        inner.a = "a";
    }

    private static void testField() {
        Field[] fields = B.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getType().isAssignableFrom(B.class));
        }
    }

    private static class Inner {
        private String a;
        private int b;
        private B self;
    }
}
