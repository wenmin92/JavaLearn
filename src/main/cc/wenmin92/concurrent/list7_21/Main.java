package cc.wenmin92.concurrent.list7_21;

public class Main {
    public static void main(String[] args) {
        System.out.println("BEGIN");
        Blackhole.enter(new Object());
        System.out.println("END");
    }
}
