package cacheProgramStructural;

public class LoggingCacheDecorator extends CacheDecorator {
    public LoggingCacheDecorator(ICacheAdapter cacheAdapter) {
        super(cacheAdapter);
    }
    @Override
    public void add(String key, Integer value) {
        System.out.println("Adding key: " + key + " with value: " + value);
        super.add(key, value);
    }

    @Override
    public Integer fetch(String key) {
        Integer value = super.fetch(key);
        System.out.println("Fetching key: " + key + " with value: " + value);
        return value;
    }

    @Override
    public void delete(String key) {
        System.out.println("Deleting key: " + key);
        super.delete(key);
    }
}

