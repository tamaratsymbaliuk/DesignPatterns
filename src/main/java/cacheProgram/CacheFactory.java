package cacheProgram;

public class CacheFactory {
    public static Cache createCache(String type, int capacity) {
        if ("LRU".equalsIgnoreCase(type)) {
            return new LRUCache(capacity);
        }
        // Additional cache types (e.g., FIFO) can be added here
        return null;
    }

}
