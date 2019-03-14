package cc.wenmin92.concurrent.list5_1;

public class Table {
    private final String[] buffer;
    private int tail;
    private int head;
    private int count;

    public Table(int count) {
        buffer = new String[count];
        tail = 0;
        head = 0;
        this.count = 0;
    }

    synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " puts " + cake);
        if (count >= buffer.length) {
            wait();
        }

        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        count ++;
        notifyAll();
    }

    synchronized String take() throws InterruptedException {
        while (count <= 0) {
            wait();
        }

        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count--;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + " takes " + cake);
        return cake;
    }
}
