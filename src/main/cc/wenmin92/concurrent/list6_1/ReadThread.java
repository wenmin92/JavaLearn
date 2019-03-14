package cc.wenmin92.concurrent.list6_1;

public class ReadThread extends Thread {

    private final Data data;

    public ReadThread(Data data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true) {
                char[] chars = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(chars));
            }
        } catch (InterruptedException e) { }
    }
}
