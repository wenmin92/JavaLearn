package cc.wenmin92.concurrent.list8_9;

public class Main {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + ":BEGIN");
        new MyFrame();
        System.out.println(Thread.currentThread().getName() + ":END");
    }
}
