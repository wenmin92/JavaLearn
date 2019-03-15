package cc.wenmin92.concurrent.list7_21;

public class Blackhole {
    public static void enter(Object obj) {
        System.out.println("Step 1");
        magic(obj);
        System.out.println("Step 2");
        synchronized (obj) {
            System.out.println("Step 3 (never reached here)");
        }
    }

    public static void magic(Object obj) {
        new Thread(() -> {
            synchronized (obj) { while (true) { try { Thread.sleep(100); } catch (InterruptedException e) { } } }
        }).start();
    }
}
