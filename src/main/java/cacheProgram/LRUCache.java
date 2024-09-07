package cacheProgram;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache implements Cache {
    private final int capacity;
    private final Map<String, Integer> cache;

    // LRU Cache using LinkedHashMap with access-order enabled
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<String, Integer>(capacity, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > capacity;
            }
        };
    }

    @Override
    public void put(String key, int value) {
        cache.put(key, value);
    }

    @Override
    public int get(String key) {
       // return cache.get(key);  since get could return null use getOrDefault
        return cache.getOrDefault(key, -1);
    }

    @Override
    public void remove(String key) {
        cache.remove(key); // here we don't worry about null in remove method of Java's Map If the key doesn't exist, nothing happens—there's no error or exception thrown, and it simply does nothing.
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public int size() {
        return cache.size();
    }

    @Override
    public boolean containsKey(String key) {
        return cache.containsKey(key);
    }
}
