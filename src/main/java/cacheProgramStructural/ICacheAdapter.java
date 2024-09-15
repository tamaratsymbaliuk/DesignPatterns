package cacheProgramStructural;

public interface ICacheAdapter {
    void add(String key, Integer value);
    Integer fetch(String key);
    void delete(String key);
    void clearCache();
    int size();
    boolean hasKey(String key);
}
