package cc.wenmin92.reflect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class TestReflect {
    public static void main(String[] args) {
        Field[] fields = B.class.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getType().isAssignableFrom(A.class));
        }

        List<C> bs = new ArrayList<>();
    }

    interface A {}

    static class B {
        A a;
        String b;
        int c;
    }

    static class C extends B {

    }

    static class D {
        List<B> cs;

        public D(List<B> cs) {
            this.cs = cs;
        }
    }
}
