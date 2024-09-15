package cacheProgramCreational;

import java.text.MessageFormat;
import java.util.*;

public class FIFOCache implements ICache { // First-In, First-Out
    private final int capacity; // Maximum size of the cache
    private final Map<String, Integer> dictMap; // Stores key-value pairs
    private final LinkedList<String> orderQueue; // Tracks the order in which keys are inserted
    public FIFOCache(int capacity) {
        this.capacity = capacity;
        this.orderQueue = new LinkedList<>();// Initializes an empty LinkedList
        this.dictMap = new HashMap<>();// Initializes an empty HashMap
    }

    @Override
    public void put(String key, Integer value) {
        if (containsKey(key)) {
            dictMap.put(key, value);  // [key2:2, key3:3, key1:6]

            // update the order of the key from queue
            orderQueue.remove(key); // [key2, key3 ]
            orderQueue.addLast(key); // [key2, key3, key1]
        } else {
            while (getSize() >= capacity) {
                // remove the oldest element from queue and cache.
                String oldestItemKey = orderQueue.removeFirst(); // [key3, key1, key2, ], remove key3 -> [ key1, key2, ]
                dictMap.remove(oldestItemKey); // [key2:2, key1:6]
            }
            dictMap.put(key, value); // [ key1, key2, key4]
            orderQueue.addLast(key); // [key2:2, key1:6, key4:10]
        }
    }

    @Override
    public int get(String key) {
        if (containsKey(key)) {
            return dictMap.get(key);
        }
        System.out.println(MessageFormat.format("ERROR: Key {0} is not in the cache", key));
        return 0;
    }

    @Override
    public void remove(String key) {
        if (containsKey(key)) {
            dictMap.remove(key); // O(1)
            orderQueue.remove(key); // O(n), doubled linked list we can remove it in O(1)
        } else {
            System.out.println(MessageFormat.format("ERROR: Key {0} is not in the cache.", key));
        }
    }

    @Override
    public void clear() {
        dictMap.clear();
        orderQueue.clear();
    }

    @Override
    public int getSize() {
        return dictMap.size();
    }

    @Override
    public boolean containsKey(String key) {
        return dictMap.containsKey(key);
    }
}
