package cc.wenmin92.format;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFormat {
    public static void main(String[] args) {
        // stringFormat();
        // printFormat();
        // decimalFormat();
        // dateFormat();
    }

    private static void dateFormat() {
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    private static void stringFormat() {
        System.out.println(String.format("%1$tH %1$tI %1$tk %1$tl", new Date()));
        System.out.println(String.format("%1$tB %1$tb %1$tA %1$ta", new Date()));
        System.out.println(String.format("%1$tC %1$tY %1$ty %1$tj %1$tm %1$td %1$te ", new Date()));
        System.out.println(String.format("%1$tR %1$tT %1$tr %1$tD %1$tF %1$tc ", new Date()));
    }

    private static void printFormat() {
        System.out.format("%1.1f", 12.543);
    }

    private static void decimalFormat() {
        System.out.println(NumberFormat.getNumberInstance().format(12.3214));
        System.out.println(new DecimalFormat("#.#").format(12.654));
    }
}
