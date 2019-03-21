package cc.wenmin92.concurrent.listB_2;

public class Main {
    public static void main(String[] args) {
        Runner runner = new Runner();

        runner.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
        }

        runner.shutdown();
    }
}
