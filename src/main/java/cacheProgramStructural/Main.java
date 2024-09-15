package cacheProgramStructural;

import cacheProgramCreational.CacheFactory;
import cacheProgramCreational.CacheTypeEnum;
import cacheProgramCreational.ICache;

public class Main {
    public static void main(String[] args) {
        System.out.println("Starting...");
        testCache();
    }

    private static void testCache() {
        CompositeCache compositeCache = new CompositeCache();

        ICache fifoCache = CacheFactory.createCacheInstance(CacheTypeEnum.FIFO, 3);
        ICache lruCache = CacheFactory.createCacheInstance(CacheTypeEnum.LRU, 3);

        ICacheAdapter fifoAdapter = new CacheAdapter(fifoCache);
        ICacheAdapter lruAdapter = new CacheAdapter(lruCache);

        // Decorate caches with logging
        ICacheAdapter loggedFifoCache = new LoggingCacheDecorator(fifoAdapter);
        ICacheAdapter loggedLruCache = new LoggingCacheDecorator(lruAdapter);

        compositeCache.addCache(loggedFifoCache);
        compositeCache.addCache(loggedLruCache);

        // Testing composite cache
        loggedFifoCache.add("key1", 1);
        loggedLruCache.add("key2", 2);
        loggedFifoCache.add("key3", 3);

        System.out.println("Fetched from FIFO cache: " + loggedFifoCache.fetch("key1"));
        System.out.println("Fetched from LRU cache: " + loggedLruCache.fetch("key2"));

        loggedFifoCache.delete("key1");
        loggedLruCache.clearCache();

        System.out.println("Size of FIFO cache: " + loggedFifoCache.size());
        System.out.println("Size of LRU cache: " + loggedLruCache.size());
        System.out.println("Composite cache size: " + compositeCache.size());
    }
}

