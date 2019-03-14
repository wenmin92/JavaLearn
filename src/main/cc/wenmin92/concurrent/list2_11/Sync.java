package cc.wenmin92.concurrent.list2_11;

public class Sync {
    private final String name = "Sync";

    @Override
    public synchronized String toString() {
        return "[ " + name + " ]";
    }
}
