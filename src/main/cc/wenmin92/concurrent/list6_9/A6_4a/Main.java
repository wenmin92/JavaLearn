package cc.wenmin92.concurrent.list6_9.A6_4a;

public class Main {
    public static void main(String[] args) {
        Database<String,String> database  = new Database<String,String>();

        // AssignThread�X���b�h�̋N��
        new AssignThread(database, "Alice", "Alaska").start();
        new AssignThread(database, "Alice", "Australia").start();
        new AssignThread(database, "Bobby", "Brazil").start();
        new AssignThread(database, "Bobby", "Bulgaria").start();

        // RetrieveThread�X���b�h�̋N��
        for (int i = 0; i < 100; i++) {
            new RetrieveThread(database, "Alice").start();
            new RetrieveThread(database, "Bobby").start();
        }

        // ��10�b�Ԓ�~
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
        }

        // �����I��
        System.exit(0);
    }
}
