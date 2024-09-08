package cacheProgram;

public class Main {
    public static void main(String[] args) {
        Cache cache = CacheManager.getInstance().getCache();

        // add values to cache
        cache.put("A", 1);
        cache.put("B", 2);
        cache.put("C", 3);

        System.out.println("Get A: " + cache.get("A"));

        cache.remove("A");
        System.out.println("Contains A: " + cache.containsKey("A"));

        cache.clear();

        System.out.println("Cache Size after clear: " + cache.size());
    }
}
