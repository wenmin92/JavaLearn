package cc.wenmin92.concurrent.list6_9;

public interface Database<K, V> {
    void clear();
    void assign(K key, V value);
    V retrieve(K key);
}
