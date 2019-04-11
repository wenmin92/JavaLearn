package cc.wenmin92.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        // 参考 http://www.runoob.com/java/java-regular-expressions.html


        // boolean matches = "cb<a>bc".matches("\\ba\\b");

        // 注意是 \\b 不是 \b
        boolean matches = Pattern.compile("\\ba\\b").matcher("cb a bc").find();
        System.out.println(matches);
    }
}
