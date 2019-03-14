package cc.wenmin92.concurrent.list6_1;

import java.util.Random;

public class WriteThread extends Thread {

    private final Data data;
    private final String filter;
    private int index;
    private Random random;

    public WriteThread(Data data, String filter) {
        this.data = data;
        this.filter = filter;
        index = 0;
        random = new Random();
    }

    @Override
    public void run() {
        try {
            while (true) {
                data.write(nextChar());
                Thread.sleep(random.nextInt(3000));
            }
        } catch (InterruptedException e) { }
    }

    private char nextChar() {
        char c = filter.charAt(index);
        index++;
        if (index >= filter.length()) {
            index = 0;
        }
        return c;
    }
}
