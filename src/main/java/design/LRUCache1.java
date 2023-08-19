package design;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author tianbo
 * @date 2019-04-08
 */
public class LRUCache1 {
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache1(final int capacity) {
        cache = new LinkedHashMap(capacity, 0.75F, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > capacity;
            }
        };
    }

    public int get(int key) {
        Integer integer = cache.get(key);
        return integer == null ? -1 : integer;
    }

    public void put(int key, int value) {
        cache.put(key, value);
    }
}
