package cc.wenmin92.concurrent.list10_10;

public class Service {

    private volatile static boolean interruptRequest;

    public static void service() {
        new Thread(() -> {
            interruptRequest = false;
            System.out.print("service");
            try {
                for (int i = 0; i < 50; i++) {
                    if (interruptRequest) {
                        return;
                    }

                    System.out.print('.');
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                    }
                }
            } finally {
                System.out.println("done.");
            }
        }).start();
    }

    public static void cancel() {
        interruptRequest = true;
        System.out.print("cancel.");
        Thread.currentThread().interrupt();
    }
}
