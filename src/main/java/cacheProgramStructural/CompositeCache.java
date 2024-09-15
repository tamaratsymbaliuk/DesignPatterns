package cacheProgramStructural;

import java.util.ArrayList;
import java.util.List;

public class CompositeCache implements ICacheAdapter {
    private final List<ICacheAdapter> caches = new ArrayList<>();
    public void addCache(ICacheAdapter cache) {
        caches.add(cache);
    }
    @Override
    public void add(String key, Integer value) {
        for (ICacheAdapter cache : caches) {
            cache.add(key, value);
        }
    }

    @Override
    public Integer fetch(String key) {
        for (ICacheAdapter cache : caches) {
            Integer value = cache.fetch(key);
            if (value != null) {
                return value;
            }
        }
        return null;
    }

    @Override
    public void delete(String key) {
        for (ICacheAdapter cache : caches) {
            cache.delete(key);
        }
    }

    @Override
    public void clearCache() {
        for (ICacheAdapter cache : caches) {
            cache.clearCache();
        }
    }

    @Override
    public int size() {
        return caches.stream().mapToInt(ICacheAdapter::size).sum();
    }

    @Override
    public boolean hasKey(String key) {
        for (ICacheAdapter cache : caches) {
            if (cache.hasKey(key)) {
                return true;
            }
        }
        return false;
    }
}