package cc.wenmin92.type;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Collection;

public class TypeClazz<T1, T2 extends Number> {

    public T2 member;
    public T1 member2;
    public Collection<? extends Number> collection;
    public Collection<T2> collection2;
    public T2[] array;

    public <T extends Type> void method(T p1, T2 p2) { }

    public static Type printlnFieldType(String name) {
        System.out.println("name: " + name);
        Class clazzType = TypeClazz.class;
        Type type = null;
        try {
            Field field = clazzType.getDeclaredField(name);
            type = field.getGenericType();
            printType(field.getGenericType());
        } catch (Exception ignored) {
        }
        if (type instanceof ParameterizedType) {
            ParameterizedType pType = (ParameterizedType) type;
            Type[] types = pType.getActualTypeArguments();
            for (Type t : types) {
                System.out.print(">>");
                printType(t);
            }
        }
        return type;
    }

    public static void printlnMethodReturnType(String name) {
        System.out.println("name: " + name);
        Class clazzType = TypeClazz.class;
        try {
            Method[] ms = clazzType.getDeclaredMethods();
            Method method = null;
            for (Method m : ms) {
                if (m.getName().equals(name)) {
                    method = m;
                    break;
                }
            }
            printType(method.getGenericReturnType());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printlnMethodParamTypes(String name) {
        System.out.println("name: " + name);
        Class clazzType = TypeClazz.class;
        try {
            Method[] ms = clazzType.getDeclaredMethods();
            Method method = null;
            for (Method m : ms) {
                if (m.getName().equals(name)) {
                    method = m;
                    break;
                }
            }
            Type[] types = method.getGenericParameterTypes();
            for (Type t : types) {
                printType(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printType(Type type) {
        Class<?>[] interfaces = type.getClass().getInterfaces();
        for (Class<?> i : interfaces) {
            try {
                if ((i.getSimpleName().toLowerCase().contains("type"))) {
                    System.out.println(">>> " + i.getSimpleName());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String... args) {
        printlnFieldType("member");
        printlnFieldType("member2");
        printlnFieldType("collection");
        printlnFieldType("collection2");
        printlnFieldType("array");
        printlnMethodReturnType("method");
        printlnMethodParamTypes("method");
    }
}