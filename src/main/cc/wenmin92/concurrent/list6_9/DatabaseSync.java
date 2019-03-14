package cc.wenmin92.concurrent.list6_9;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class DatabaseSync<K, V> implements Database<K, V> {

    private final Map<K, V> map = new HashMap<>();

    public synchronized void clear() {
        verySlowly();
        map.clear();
    }

    public synchronized void assign(K key, V value) {
        verySlowly();
        map.put(key, value);
    }

    public synchronized V retrieve(K key) {
        slowly();
        return map.get(key);
    }

    private void slowly() {
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) { }
    }

    private void verySlowly() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) { }
    }
}
