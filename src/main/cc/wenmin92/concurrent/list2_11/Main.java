package cc.wenmin92.concurrent.list2_11;

public class Main {
    private static final long CALL_COUNT = 1000000000L;

    public static void main(String[] args) {
        trial("NotSync", CALL_COUNT, new NotSync());
        trial("Sync", CALL_COUNT, new Sync());
    }

    private static void trial(String msg, long count, Object obj) {
        System.out.println(msg + " : BEGIN");
        long start = System.currentTimeMillis();
        for (long i = 0; i < count; i++) {
            obj.toString();
        }
        System.out.println(msg + " : END");
        System.out.println("Escape time = " + (System.currentTimeMillis() - start) + " msec.");
    }
}
