package cc.wenmin92.concurrent.listB_2;

public class Runner extends Thread {

    private boolean quite;

    @Override
    public void run() {
        while (!quite) {
            System.out.println("run...");
            try {
                sleep(10);
            } catch (InterruptedException e) {
            }
        }
    }

    void shutdown() {
        quite = true;
    }
}
