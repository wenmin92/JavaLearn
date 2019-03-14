package cc.wenmin92.concurrent.list5_1;

import java.util.Random;

public class EaterThread extends Thread {

    private final Table table;
    private final Random random = new Random();

    public EaterThread(String name, Table table) {
        super(name);
        this.table = table;
    }

    @Override
    public void run() {
        try {
            while (true) {
                table.take();
                Thread.sleep(random.nextInt(1000));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
