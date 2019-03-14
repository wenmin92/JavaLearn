package cc.wenmin92.concurrent.list5_1;

import java.util.Random;

public class MakerThread extends Thread {

    private static int id;

    private final Table table;
    private final Random random = new Random();

    public MakerThread(String name, Table table) {
        super(name);
        this.table = table;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(random.nextInt(1000));
                table.put(String.format("[ Cake No.%d made by %s ]", nextId(), getName()));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    synchronized private int nextId() {
        return id++;
    }
}
