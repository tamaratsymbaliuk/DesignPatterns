package cacheProgram;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache implements Cache { // Least Frequently Used
    private final int capacity;
    private final Map<String, Integer> cache; // Stores key-value pairs
    private final Map<String, Integer> frequencyMap; // Tracks the frequency of each key
    private final PriorityQueue<CacheEntry> frequencyQueue; // Min-heap to evict least frequently used

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.frequencyMap = new HashMap<>();
        this.frequencyQueue = new PriorityQueue<>((a, b) -> a.frequency - b.frequency); // Min-heap based on frequency
    }

    @Override
    public void put(String key, int value) {
        if (cache.size() >= capacity) {
            // Evict the least frequently used key
            CacheEntry lfuEntry = frequencyQueue.poll();
            if (lfuEntry != null) {
                cache.remove(lfuEntry.key);
                frequencyMap.remove(lfuEntry.key);
            }
        }
        cache.put(key, value); //  add new key-value pair to the cache
        frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1); // Update frequency count
        frequencyQueue.offer(new CacheEntry(key, frequencyMap.get(key)));// Add to the frequency queue
    }

    @Override
    public int get(String key) {
        if (!cache.containsKey(key)) {
            return -1; // key not found
        }
            // Increment frequency count
            frequencyMap.put(key, frequencyMap.get(key) + 1);
            frequencyQueue.offer(new CacheEntry(key, frequencyMap.get(key))); // Update frequency in the queue

            return cache.get(key); // Return the value associated with the key
        }


        @Override
        public void remove(String key) {
            cache.remove(key); // Remove the entry from the cache
            frequencyMap.remove(key); // Remove the key from frequency map
            frequencyQueue.removeIf(entry -> entry.key.equals(key)); // Remove the key from the frequency queue
        }

        @Override
        public void clear() {
            cache.clear(); // Clear all key-value pairs in the cache
            frequencyMap.clear(); // Clear the frequency map
            frequencyQueue.clear(); // Clear the frequency queue
        }

        @Override
        public int size () {
            return cache.size();
        }

        @Override
        public boolean containsKey (String key){
            return cache.containsKey(key);
        }


        // Inner class to represent an entry in the LFU cache
        private static class CacheEntry {
            String key;
            int frequency;

            CacheEntry(String key, int frequency) {
                this.key = key;
                this.frequency = frequency;
            }

        }
    }

