package me.asu;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author victor.
 * @since 2018/7/30
 */
public final class ConcurrentCache<K, V> {

    private final int       size;
    private final Map<K, V> eden;
    private final Map<K, V> longterm;

    /**
     * 缓存类
     * @param size 缓存池大小
     */
    public ConcurrentCache(int size) {
        this.size = size;
        this.eden = new ConcurrentHashMap<>();
        this.longterm = new WeakHashMap<>();
    }

    /**
     * 获取一个缓存
     * @param k key
     * @return value
     */
    public V get(K k) {
        V v = eden.get(k);
        if (v == null) {
            synchronized (longterm) {
                v = longterm.get(k);
            }
            if (v != null) {
                eden.put(k, v);
            }
        }

        return v;
    }

    /**
     * 添加一个缓存
     * @param k key
     * @param v value
     */
    public void put(K k, V v) {
        if (eden.size() > size) {
            synchronized (longterm) {
                longterm.putAll(eden);
            }
            this.eden.clear();
        }
        eden.put(k, v);
    }

    /**
     * 删除缓存
     *
     * @param k key
     * @return value
     */
    public synchronized V remove(K k) {
        V remove = eden.remove(k);
        if (remove != null) {
            return remove;
        }
        return longterm.remove(k);
    }

    /**
     * 删除所有的缓存
     *
     * @return Map&lt;K,V&gt;
     */
    public synchronized Map<K, V> removeAll() {
        Map<K, V> all = getAll();
        eden.clear();
        longterm.clear();
        return all;
    }

    /**
     * 获取所有的缓存
     *
     * @return Map&lt;K,V&gt;
     */
    public synchronized Map<K, V> getAll() {
        int capacity = eden.size() + longterm.size() + 1;
        Map<K, V> m = new HashMap<>(capacity);
        m.putAll(longterm);
        m.putAll(eden);
        return m;
    }
}
