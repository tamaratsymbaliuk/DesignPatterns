package cacheProgram;

public class CacheFactory {
    public static Cache createCache(String type, int capacity) {
        if ("LRU".equalsIgnoreCase(type)) {
            return new LRUCache(capacity);
        } else if ("FIFO".equalsIgnoreCase(type)) {
            return new FIFOCache(capacity);
        } else if ("LFU".equalsIgnoreCase(type)) {
            return new LFUCache(capacity);
        }
        return null;
    }

}
