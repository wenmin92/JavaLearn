package cc.wenmin92.concurrent.list3_12;

import cc.wenmin92.concurrent.list3_1.Request;
import cc.wenmin92.concurrent.list3_1.RequestQueue;

public class TalkThread extends Thread {
    private final RequestQueue input;
    private final RequestQueue output;

    TalkThread(String name, RequestQueue input, RequestQueue output) {
        super(name);
        this.input = input;
        this.output = output;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":BEGIN");
        for (int i = 0; i < 20; i++) {
            Request request1 = input.getRequest();
            System.out.println(Thread.currentThread().getName() + " gets " + request1);

            Request request2 = new Request(request1.getName() + "!");
            System.out.println(Thread.currentThread().getName() + " puts " + request2);
            output.putRequest(request2);
        }
    }
}
