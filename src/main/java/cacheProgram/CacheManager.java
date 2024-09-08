package cacheProgram;

public class CacheManager {
    private static CacheManager instance;
    private Cache cache;

    // Private constructor to prevent instantiation
    private CacheManager() {
        this.cache = CacheFactory.createCache("LRU", 5); // Default LRU cache with capacity 5
    }
    // Singleton getInstance method
    public static synchronized CacheManager getInstance() {
        if (instance == null) {
            instance = new CacheManager();
        }
        return instance;
    }

    public Cache getCache() {
        return cache;
    }
}
