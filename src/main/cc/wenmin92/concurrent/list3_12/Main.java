package cc.wenmin92.concurrent.list3_12;

import cc.wenmin92.concurrent.list3_1.Request;
import cc.wenmin92.concurrent.list3_1.RequestQueue;

public class Main {
    public static void main(String[] args) {
        RequestQueue requestQueue1 = new RequestQueue();
        RequestQueue requestQueue2 = new RequestQueue();
        requestQueue1.putRequest(new Request("abc"));
        // requestQueue2.putRequest(new Request("xyz"));
        new TalkThread("Alice", requestQueue1, requestQueue2).start();
        new TalkThread("Bobby", requestQueue2, requestQueue1).start();
    }
}
