package cc.wenmin92.concurrent.list3_1;

import java.util.LinkedList;
import java.util.Queue;

public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<>();

    public synchronized void putRequest(Request request) {
        queue.offer(request);
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " notifyAll");
    }

    public synchronized Request getRequest() {
        while (queue.peek() == null) {
            try {
                System.out.println(Thread.currentThread().getName() + " start wait");
                wait();
                System.out.println(Thread.currentThread().getName() + " end wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return queue.poll();
    }
}
