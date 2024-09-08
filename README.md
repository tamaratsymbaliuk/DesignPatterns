# DesignPatterns
# Cache Program

## Overview
This is a cache program implemented using creational design patterns in Java. The cache supports operations like put, get, remove, and clearing of cache entries, and uses the **LRU (Least Recently Used)** strategy. The program leverages design patterns like **Singleton**, **Factory Method**, and **Prototype**.

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
2. **Factory Method Pattern**: Used to create different cache strategies (e.g., LRU, FIFO).
3. **Prototype Pattern**: Used to clone cache entries when required.
4. **LRU Cache Strategy**: Default cache strategy that evicts the least recently used entry when the cache reaches its capacity.

## Usage
1. Clone or download the project.
2. Compile the Java files.
3. Run the `Main` class to see the cache in action.

## Future Extensions
- Implement other cache strategies like **FIFO** or **LFU**.
- Enhance the cache to support different data types for values.
