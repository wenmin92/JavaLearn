package cc.wenmin92.innerclass;

public class AnotherClass {
    public void test() {
        TestInnerClass outer = new TestInnerClass();
        TestInnerClass.Inner inner = outer.new Inner();
    }
}
