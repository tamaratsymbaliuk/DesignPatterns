package cacheProgram;

import java.util.*;

public class FIFOCache implements Cache { // First-In, First-Out
    private final int capacity; // Maximum size of the cache
    private final Map<String, Integer> cache; // Stores key-value pairs
    private final Queue<String> orderQueue; // Tracks the order in which keys are inserted
    public FIFOCache(int capacity) {
        this.capacity = capacity;
        this.orderQueue = new LinkedList<>();// Initializes an empty LinkedList
        this.cache = new HashMap<>();// Initializes an empty HashMap
    }

    @Override
    public void put(String key, int value) {
        if (cache.size() >= capacity) {
            // poll -  retrieves and removes the head (first element) of the queue
            String oldestKey = orderQueue.poll();
            cache.remove(oldestKey);
        }
        cache.put(key, value);
        orderQueue.offer(key); // Add the key to the order queue, offer is similar to add(),
        // but unless add() returns false without throwing an exception f.e. when a queue is full
    }

    @Override
    public int get(String key) {
        return cache.getOrDefault(key, -1); // Return -1 if the key doesn't exist
    }

    @Override
    public void remove(String key) {
        cache.remove(key);
        orderQueue.remove(key);
    }

    @Override
    public void clear() {
        cache.clear();
        orderQueue.clear();
    }

    @Override
    public int size() {
        return cache.size();
    }

    @Override
    public boolean containsKey(String key) {
        return cache.containsKey(key);
    }
}
