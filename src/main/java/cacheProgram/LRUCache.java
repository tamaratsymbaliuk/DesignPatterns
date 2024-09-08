package cacheProgram;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache implements Cache { // Least Recently Used
    private final int capacity;
    private final Map<String, Integer> cache;

    // LRU Cache using LinkedHashMap with access-order enabled
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<String, Integer>(capacity, 0.75f, true) {
            // For LRU, the LinkedHashMap implementation is the best and most efficient. It leverages built-in Java features to handle access order and eviction.
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {// provides a convenient way to automatically evict the oldest entry when the cache exceeds capacity.
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
