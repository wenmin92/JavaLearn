package cc.wenmin92.concurrent.list6_1;

public class Main {
    public static void main(String[] args) {
        Data data = new Data(8);
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new WriteThread(data, "hello").start();
        new WriteThread(data, "world").start();
        new WriteThread(data, "home").start();
    }
}
