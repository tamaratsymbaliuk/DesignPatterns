package cacheProgramStructural;

public abstract class CacheDecorator implements ICacheAdapter {
    protected final ICacheAdapter cacheAdapter;
    public CacheDecorator(ICacheAdapter cacheAdapter) {
        this.cacheAdapter = cacheAdapter;
    }
    @Override
    public void add(String key, Integer value) {
        cacheAdapter.add(key, value);
    }

    @Override
    public Integer fetch(String key) {
        return cacheAdapter.fetch(key);
    }

    @Override
    public void delete(String key) {
        cacheAdapter.delete(key);
    }

    @Override
    public void clearCache() {
        cacheAdapter.clearCache();
    }

    @Override
    public int size() {
        return cacheAdapter.size();
    }

    @Override
    public boolean hasKey(String key) {
        return cacheAdapter.hasKey(key);
    }
}
