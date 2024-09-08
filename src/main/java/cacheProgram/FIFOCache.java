package cacheProgram;

import java.util.LinkedHashMap;
import java.util.Map;

public class FIFOCache implements Cache { // First-In, First-Out
    private final int capacity;
    private final Map<String, Integer> cache;
    public FIFOCache(int capacity) {
        this.capacity = capacity;
        this.cache = new LinkedHashMap<>(capacity,0.75f, false) {

        }
    }

    @Override
    public void put(String key, int value) {

    }

    @Override
    public int get(String key) {
        return 0;
    }

    @Override
    public void remove(String key) {

    }

    @Override
    public void clear() {

    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean containsKey(String key) {
        return false;
    }
}
