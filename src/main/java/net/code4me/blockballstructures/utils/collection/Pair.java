package net.code4me.blockballstructures.utils.collection;

public class Pair<K, V> {

    private final Object key;
    private final Object value;

    public Pair(Object key, Object value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return (K) key;
    }

    public V getValue() {
        return (V) value;
    }
}
