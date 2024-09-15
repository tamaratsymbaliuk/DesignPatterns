package cacheProgram;

import java.text.MessageFormat;

public class CacheFactory {
    public static ICache createCacheInstance(CacheTypeEnum type, int capacity) {
        switch (type) {
            case CacheTypeEnum.FIFO -> {
                return new FIFOCache(capacity);
            }
            case CacheTypeEnum.LFU -> {
                LFUCacheBuilder lfuCacheBuilder = new LFUCacheBuilder().setCapacity(capacity).setServerName("localhost:8080");
                return lfuCacheBuilder.build();
            }
            case CacheTypeEnum.LRU -> {
                return new LRUCache(capacity);
            }
            default -> {
                System.out.println(MessageFormat.format("cache with type {0} is not implemented yet.", type));
                return null;
            }

        }

    }
}
