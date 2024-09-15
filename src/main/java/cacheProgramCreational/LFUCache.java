package cacheProgramCreational;

import java.text.MessageFormat;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LFUCache implements ICache { // Least Frequently Used
    private int capacity;
    private String serverName;
    private final Map<String, LFUCacheItem> keyToCacheItemMap; // {key:LFUCacheItem}  cache: {key1:{6, 2}}, {key2:{2, 1}}, {key3:{3, 2}}
    private final PriorityQueue<LFUCacheItem> keyFrequenciesMinHeap; // {LFUCacheItem} [{key2: 1}, {key1: 2}, {key3: 2}] - frequencies heap

    public LFUCache() {
        this.capacity = 10; // by default
        this.keyToCacheItemMap = new HashMap<>();
        this.keyFrequenciesMinHeap = new PriorityQueue<>(Comparator.comparingInt(value -> value.getFrequency())); // it only sorts when you add/remove
    }

    @Override
    public void put(String key, Integer value) {
        // If the key is already in our cache,
        // Let's update its value and increase its frequency
        if (containsKey(key)) {
            LFUCacheItem node = keyToCacheItemMap.get(key);
            LFUCacheItem clonedNode = node.clone();
            clonedNode.setValue(value);
            keyToCacheItemMap.put(key, clonedNode);
            increaseCacheItemFrequency(node, clonedNode);
            return;
        }
        // If the key is new, we want to add it to cache.
        // Before that, let's check for capacity.
        // if the elements size is equal to it, let's remove it from the heap and the map.
        while (getSize() >= capacity) {
            LFUCacheItem nodeWithMinFrequency = keyFrequenciesMinHeap.poll();
            keyToCacheItemMap.remove(nodeWithMinFrequency.getKey());
        }
        // Let's add new item to the heap and the map with a default frequency.
        LFUCacheItem nodeToAdd = new LFUCacheItem(key, value);
        keyToCacheItemMap.put(key, nodeToAdd);
        keyFrequenciesMinHeap.add(nodeToAdd);
    }

    @Override
    public int get(String key) {
        // If we use the cache item from the cache,
        // let's increase its frequency
        if (containsKey(key)) {
            LFUCacheItem node = keyToCacheItemMap.get(key);
            LFUCacheItem clonedNode = node.clone();
            keyToCacheItemMap.put(key, clonedNode);
            increaseCacheItemFrequency(node, clonedNode);
            return clonedNode.getValue();
        }
        System.out.println(MessageFormat.format("ERROR: Key {0} is not in cache.", key));
        return 0;
        }

        @Override
        public void remove(String key) {
             if(containsKey(key)) {
                 LFUCacheItem node = keyToCacheItemMap.get(key);
                 keyToCacheItemMap.remove(key);
                 keyFrequenciesMinHeap.remove(node);
             } else {
                 System.out.println(MessageFormat.format("ERROR: Key {0} is not in the cache.", key));
             }
        }

        @Override
        public void clear() {
            keyToCacheItemMap.clear();
            keyFrequenciesMinHeap.clear();
        }

        @Override
        public int getSize() {
            return keyToCacheItemMap.size();
        }

        @Override
        public boolean containsKey (String key){
            return keyToCacheItemMap.containsKey(key);
        }
        public void setCapacity(int capacity) {
            this.capacity = capacity;
        }

       public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    // cache.put("key1", 1); // key1:1,  freq 1
    // cache.put("key1", 6); // key1:6    freq 2
    // cache.put("key2", 2); // key1:6, key2:2 freq 1
    // cache.put("key3", 3); // cache: key1:6, key2:2, key3:3 freq 1  [key1, key2, key3]
    // cache.get("key3"); // get key3  let's remove key 3 -> [key1, key2] -> and add new node with key3 key and +1 freq [key1, key2, key3]
    private void increaseCacheItemFrequency(LFUCacheItem nodeToDelete, LFUCacheItem nodeToAdd) {
        keyFrequenciesMinHeap.remove(nodeToDelete);
        nodeToAdd.setFrequency(nodeToAdd.getFrequency() + 1);
        keyFrequenciesMinHeap.add(nodeToAdd);
    }
}

