package cc.wenmin92.concurrent.list4_1;

public class Main {
    public static void main(String[] args) {
        Data data = new Data("data.txt", "");
        new SaverThread("SaverThread", data).start();
        new ChangerThread("ChangerThread", data).start();
    }
}
