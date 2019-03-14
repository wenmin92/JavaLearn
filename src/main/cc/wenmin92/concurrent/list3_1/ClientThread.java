package cc.wenmin92.concurrent.list3_1;

import java.util.Random;

public class ClientThread extends Thread {
    private final RequestQueue requestQueue;
    private final Random random;

    public ClientThread(String name, RequestQueue requestQueue) {
        super(name);
        this.requestQueue = requestQueue;
        this.random = new Random();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            Request request = new Request("No." + i);
            System.out.println(Thread.currentThread().getName() + " requests " + request);
            requestQueue.putRequest(request);
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) { }
        }
    }
}
