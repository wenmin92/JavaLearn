package cc.wenmin92.concurrent.list6_9;

import java.util.concurrent.atomic.AtomicInteger;

public class RetrieveThread extends Thread {
    private final Database<String, String> database;
    private final String key;
    private static final AtomicInteger counter = new AtomicInteger(0);

    public RetrieveThread(Database<String, String> database, String key) {
        this.database = database;
        this.key = key;
    }

    @Override
    public void run() {
        while (true) {
            int count = counter.incrementAndGet();
            String value = database.retrieve(key);
            System.out.println(count + ":" + key + " => " + value);
        }
    }
}
