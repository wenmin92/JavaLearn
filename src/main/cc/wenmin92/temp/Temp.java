package cc.wenmin92.temp;

import java.util.Locale;

public class Temp {
    public static void main(String[] args) {
        setSinePath(-1.1f, 1f, 3.1f, 0);
    }

    private static void setSinePath(float left, float top, float right, float bottom) {
        StringBuilder log = new StringBuilder();
        log.append("\n").append(String.format(Locale.ROOT, "(%.4f, %.4f, %.4f, %.4f)", left, top, right, bottom));
        log.append("\n").append(String.format(Locale.ROOT, "(%.4f, %.4f)", left, bottom)).append("\n");

        float range = right - left;
        for (float i = 0; i < range; i += 0.1) {
            float y = (float) (Math.sin(i * Math.PI / range) * top);
            log.append(String.format(Locale.ROOT, "(%.4f, %.4f)", left + i, y)).append("\n");
        }
        System.out.println(log);
    }
}
