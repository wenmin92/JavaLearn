package cc.wenmin92.temp;

import java.util.Locale;

public class Temp {
    public static void main(String[] args) {
        // setSinePath(-1.1f, 1f, 3.1f, 0);
        System.out.println(humanReadableByteCountKilo(1));
        System.out.println(humanReadableByteCountKilo(145));
        System.out.println(humanReadableByteCountKilo(8921));
        System.out.println(humanReadableByteCountKilo(123540));
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

    public static String humanReadableByteCountKilo(long kiloBytes) {
        int unit = 1024;
        if (kiloBytes < unit) return kiloBytes + " KB";
        int exp = (int) (Math.log(kiloBytes) / Math.log(unit));
        char pre = "MGTPE".charAt(exp - 1);
        return String.format(Locale.getDefault(), "%.2f %sB", kiloBytes / Math.pow(unit, exp), pre);
    }

    public static String humanReadableByteCount(long bytes, boolean si) {
        int unit = si ? 1000 : 1024;
        if (bytes < unit) return bytes + " B";
        int exp = (int) (Math.log(bytes) / Math.log(unit));
        String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }
}
