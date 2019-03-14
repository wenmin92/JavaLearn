package cc.wenmin92.concurrent.list3_1;

import java.util.Random;

public class ServerThread extends Thread {
    private final RequestQueue requestQueue;
    private final Random random;

    public ServerThread(String name, RequestQueue requestQueue) {
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Request request = requestQueue.getRequest();
            System.out.println(Thread.currentThread().getName() + " handles" + request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) { }
        }
    }
}
