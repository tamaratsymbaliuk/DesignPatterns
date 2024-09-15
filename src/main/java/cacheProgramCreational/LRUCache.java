package cacheProgramCreational;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache implements ICache { // Least Recently Used
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
    public void put(String key, Integer value) {
        cache.put(key, value);
    }

    @Override
    public int get(String key) {
        if (!containsKey(key)) {
            System.out.println(MessageFormat.format("ERROR: Key {0} is not in cache.", key));
            return 0;
        }
        return cache.get(key);
    }

    @Override
    public void remove(String key) {
        if (!containsKey(key)) {
            System.out.println(MessageFormat.format("ERROR: Key {0} is not in cache.", key));
        } else {
            cache.remove(key);
        }
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public int getSize() {
        return cache.size();
    }

    @Override
    public boolean containsKey(String key) {
        return cache.containsKey(key);
    }
}
