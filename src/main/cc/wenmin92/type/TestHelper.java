package cc.wenmin92.type;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class TestHelper {

    public static void main(String[] args) {
        testParameterizedType();
    }

    private static void testParameterizedType() {
        Field[] fields = ParameterizedTypeBean.class.getDeclaredFields();
        // 打印出所有的 Field 的 TYpe 是否属于 ParameterizedType
        for (Field f : fields) {
            System.out.println(f.getName() + "\tgetGenericType() instanceof ParameterizedType\t" + (f.getGenericType() instanceof ParameterizedType));
            System.out.println(f.getName() + "\tgetTypeName\t" + f.getGenericType().getTypeName());
            if (f.getGenericType() instanceof ParameterizedType) {
                ParameterizedType type = (ParameterizedType) f.getGenericType();
                System.out.println(f.getName() + "\tgetActualTypeArguments\t" + Arrays.toString(type.getActualTypeArguments()));
                System.out.println(f.getName() + "\tgetRawType\t" + type.getRawType());
                System.out.println(f.getName() + "\tgetOwnerType\t" + type.getOwnerType());
            }
        }
        System.out.println(fields[0].getGenericType().getClass().getName());
        // getParameterizedTypeMes("map");
        // getParameterizedTypeMes("entry");

    }

    private static void getParameterizedTypeMes(String fieldName) throws NoSuchFieldException {
        Field f;
        f = ParameterizedTypeBean.class.getDeclaredField(fieldName);
        f.setAccessible(true);
        System.out.println(f.getGenericType());
        boolean b = f.getGenericType() instanceof ParameterizedType;
        System.out.println(b);
        if (b) {
            ParameterizedType pType = (ParameterizedType) f.getGenericType();
            System.out.println(pType.getRawType());
            for (Type type : pType.getActualTypeArguments()) {
                System.out.println(type);
            }
            System.out.println(pType.getOwnerType()); // null
        }
    }
}