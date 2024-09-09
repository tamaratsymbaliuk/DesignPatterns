# DesignPatterns
# Cache Program

## Overview
This is a cache program implemented using creational design patterns in Java. The cache supports operations like put, get, remove, and clearing of cache entries, with support for multiple cache strategies: **LRU (Least Recently Used)**, **FIFO (First-In, First-Out)**, and **LFU (Least Frequently Used)**. The program leverages design patterns like **Singleton**, **Factory Method**, and **Prototype** to provide flexibility and scalability in managing cache instances.

## Requirements
- Cache key: `String`
- Cache value: `Integer`
- Cache operations:
    - `put(String key, int value)`: Add or update a value in the cache.
    - `get(String key)`: Retrieve a value from the cache by key.
    - `remove(String key)`: Remove a value from the cache.
    - Optional:
        - `clear()`: Clear all cache entries.
        - `size()`: Get the current size of the cache.
        - `containsKey(String key)`: Check if a key exists in the cache.

## Features
1. **Singleton Pattern**: Ensures only one instance of the cache manager exists.
2. **Factory Method Pattern**: Used to create different cache strategies (e.g., LRU, FIFO, LFU).
3. **Prototype Pattern**: Used to clone cache entries when required.
4. **Cache Strategies**:
    - **LRU (Least Recently Used)**: Evicts the least recently accessed entry when the cache reaches its capacity.
    - **FIFO (First-In, First-Out)**: Evicts the oldest entry when the cache reaches its capacity.
    - **LFU (Least Frequently Used)**: Evicts the entry with the fewest accesses when the cache reaches its capacity.

## Usage
1. Clone or download the project.
2. Compile the Java files.
3. Run the `Main` class to see different cache strategies in action. You can instantiate any of the cache strategies (LRU, FIFO, LFU) through the **Factory Method**.

### Example Code:

```java
Cache lruCache = CacheFactory.createCache("LRU", 3);
Cache fifoCache = CacheFactory.createCache("FIFO", 3);
Cache lfuCache = CacheFactory.createCache("LFU", 3);
