package cacheProgramStructural;

import cacheProgramCreational.ICache;

public class CacheAdapter implements ICacheAdapter {
    private final ICache cache;
    public CacheAdapter(ICache cache) {
        this.cache = cache;
    }
    @Override
    public void add(String key, Integer value) {
        cache.put(key, value);
    }

    @Override
    public Integer fetch(String key) {
        return cache.get(key);
    }

    @Override
    public void delete(String key) {
        cache.remove(key);
    }

    @Override
    public void clearCache() {
        cache.clear();
    }

    @Override
    public int size() {
        return cache.getSize();
    }

    @Override
    public boolean hasKey(String key) {
        return cache.containsKey(key);
    }
}
