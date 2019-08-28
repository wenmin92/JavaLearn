package cc.wenmin92.clazz;

public class InstanceInitTest {
    public static void main(String[] args) {
        float range = 3;
        int count = 10;
        float sinX = 0;
        float j = 2f / count;
        for (int i = 0; i < count; i++) {
            sinX = (float) ((Math.pow((j * i - 1), 3) + 1) / 2);
            float sinY = (float) Math.sin(sinX * range * Math.PI);
            System.out.println(sinX);
        }
    }
}
