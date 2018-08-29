package cc.wenmin92.innerclass;

import java.util.ArrayList;

public class TestInnerClass {

    private String a;
    private int b;
    private Inner self;

    public static void main(String[] args) {
        TestInnerClass outer = new TestInnerClass();
        Inner inner = outer.new Inner();
        inner.a = "a";
        System.out.println(inner);

        // 双括号初始化
        invite(new ArrayList<String>() {{ add(" Harry "); add(" Tony "); }});

        // 在静态方法中打印当前类名
        new Object() {}.getClass().getEnclosingClass();
    }

    private static void invite(ArrayList<String> strings) {

    }

    class Inner {
        private String a = TestInnerClass.this.a;
        private int b;
        private Inner self;

        @Override
        public String toString() {
            return "Inner{" +
                    "a='" + a + '\'' +
                    ", b=" + b +
                    ", self=" + self +
                    '}';
        }
    }
}
